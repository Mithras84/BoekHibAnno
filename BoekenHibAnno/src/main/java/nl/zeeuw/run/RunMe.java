package nl.zeeuw.run;

import nl.zeeuw.dao.BoekDAO;
import nl.zeeuw.model.Boek;
import nl.zeeuw.model.Persoon;
import nl.zeeuw.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;


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
	testHibBoekDAO();
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

}
