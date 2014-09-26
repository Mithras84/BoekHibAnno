package nl.zeeuw.run;

import nl.zeeuw.dao.BoekDAO;
import nl.zeeuw.dao.PersoonDAO;
import nl.zeeuw.model.Adres;
import nl.zeeuw.model.Boek;
import nl.zeeuw.model.Persoon;


/**
 * @author Pieter
 * 
 * @date 18 sep. 2014
 */
public class RunMe {

    /**
     * @param args
     */
    public static void main(String[] args) {
	//testHibBoekDAO();
	//testHibPersMetBoekOneToOne ();
	testHibPersoonMetEmbedAdres();
    }

    
    public static void testHibBoekDAO () {
	//Maak een boek
	Boek b = new Boek ();
	b.setIsbn(1234567891012l);
	b.setAuteur("Henkie");
	b.setTitel("Henkie's Boek");
	b.setPrijs(99.99);
	
	//Maak een BoekDAO
	BoekDAO bdao = new BoekDAO ();
	
	//Sla boek op in DB via DAO
	bdao.persistBoek(b);
	
	//Maak nog een boek
	Boek b3 = new Boek ();
	b3.setIsbn(1234567891013l);
	b3.setAuteur("Pietje");
	b3.setTitel("Pietje's Boek");
	b3.setPrijs(99.99);
	
	//Sla dit boek ook op in DB
	bdao.persistBoek(b3);
	
	//Haal de twee boeken uit DB:
	Boek b2 = bdao.findBoekByISBN(1234567891012l);
	Boek b4 = bdao.findBoekByISBN(1234567891013l);
	
	//Print auteur, zie of deze overeenkomen
	System.out.println(b2.getAuteur());
	System.out.println(b4.getAuteur());
	
	//Pietje was de auteur niet, maar zijn vader.. Update boek in DB
	b3.setAuteur("Pietje's Vader");
	b3.setTitel("Pietje's Vader's boek");
	bdao.updateBoek(b3);
	
	//Kijk of verandering is doorgevoerd:
	b4 = bdao.findBoekByISBN(1234567891013l);	
	System.out.println(b4.getAuteur());	
	
    }
    
    public static void testHibPersMetBoekOneToOne () {
	Boek b = new Boek();
	b.setIsbn(1234567891014l);
	b.setAuteur("Henkie");
	b.setTitel("Henkie's tweede boek");
	b.setPrijs(19.99);
	
	Boek b2 = new Boek();
	b2.setIsbn(1234567891015l);
	b2.setAuteur("Henkie");
	b2.setTitel("Henkie's derde boek");
	b2.setPrijs(29.99);
	
	BoekDAO bd = new BoekDAO ();
	bd.persistBoek(b2);
	
	Persoon p = new Persoon ();
	
	p.setVoorNaam("Wobbe");
	p.setAchterNaam("de Vries");
	p.setTelefoonNr("0612345678");
	p.setBoek(b);
	
	PersoonDAO pdao = new PersoonDAO ();
	pdao.persistPersoon(p);
	
	Persoon p2 = pdao.findPersonById(1);
	Boek b3 = p2.getBoek();
	
	System.out.println(p2.getVoorNaam() + " heeft een boek van " + b3.getAuteur());
	
    }
    
    public static void testHibPersoonMetEmbedAdres () {
	Persoon p = new Persoon ();
	p.setVoorNaam("Teddy");
	p.setAchterNaam("Beer");
	p.setTelefoonNr("0644556677");
	
	p.setBoek(null);
	
	Adres a = new Adres ();
	a.setStraatNaam("Berenbos");
	a.setHuisNummer(6);
	a.setPostCode("9999AA");
	p.setAdres(a);
	
	PersoonDAO pd = new PersoonDAO ();
	pd.persistPersoon(p);
	
	Persoon p2 = pd.findPersonById(1);
	System.out.println(p2.getVoorNaam() + " " + p2.getAchterNaam() + "'s Postcode is " + p2.getAdres().getPostCode());
    }

}
