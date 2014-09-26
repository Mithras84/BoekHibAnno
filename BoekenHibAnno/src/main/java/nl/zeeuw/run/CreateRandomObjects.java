package nl.zeeuw.run;


import java.util.ArrayList;
import java.util.List;

import nl.zeeuw.model.Adres;
import nl.zeeuw.model.Boek;
import nl.zeeuw.model.Persoon;

/**
 * Even een aparte klasse om de database met personen, boeken en adressen te vullen.
 * Beetje onzin om dat continue in de main te doen.
 * 
 * 
 * @author Pieter
 * 
 * @date 26 sep. 2014
 */
public class CreateRandomObjects {
    
    public static List<Persoon> getRandomPersonenLijst (int size) {
	List<Persoon> list = new ArrayList<>();
	
	for (int i= 0; i < size; i++) {
	    list.add( getRandomPersoon() );
	}
	
	return list;
    }
    
    public static List<Boek> getRandomBoekenLijst (int size) {
	List<Boek> list = new ArrayList<>();
	
	for (int i= 0; i < size; i++) {
	    list.add( getRandomBoek() );
	}
	
	return list;
    }
    
    public static Persoon getRandomPersoon () {
	Persoon p = new Persoon();
	p.setVoorNaam( getRandomVoornaam() );
	p.setAchterNaam( getRandomAchternaam() );
	p.setTelefoonNr("06-" + getRandomNummer(8) );
	p.setAdres( getRandomAdres() );
	p.setEmailAdres( getRandomEmailAdres( p.getVoorNaam(), p.getAchterNaam() ) );
	
	return p;	
    }
    
    public static Boek getRandomBoek () {
	Boek b = new Boek ();
	b.setIsbn( Long.valueOf(getRandomNummer(13) ));
	b.setAuteur( getRandomPersoon() );
	b.setPrijs( getRandomPrijs() );
	b.setTitel( getRandomTitel() );
	
	return b;
    }
    
    public static Adres getRandomAdres () {
	Adres a = new Adres ();
	a.setHuisNummer( Integer.valueOf(getRandomNummer(2) ) );	
	a.setPostCode(getRandomPostcode());
	a.setStraatNaam(getRandomStraatnaam());
	a.setWoonPlaats(getRandomWoonplaats());
	
	return a;
    }
    
    private static String getRandomNummer(int length) {
	String res = "";
	for (int i = 0; i < length; i++) {
	    res += (int)(Math.random() * 10);
	}
	
	return res;
    }
    
    private static String getRandomVoornaam () {
	String voornamenLijst[] = {
		"Henkie", "Wobbe", "Pietje", "Bauke",
		"Klaasje", "Jantje", "Annie",
		"Grietje", "Floortje", "Bep"
		};
	int r = (int) (Math.random() * voornamenLijst.length);
	
	return voornamenLijst[r];
    }
    
    private static String getRandomAchternaam () {
	String achternamenLijst[] = {
		"de Boer", "de Vries", "Ydema", "Mollema",
		"de Jong", "van Voorden", "Westerveld",
		"Timmermans", "van der Molen", "Anteren" 
		};	
	int r = (int) (Math.random() * achternamenLijst.length);
	
	return achternamenLijst[r];
    }
    
    private static String getRandomEmailAdres (String voornaam, String achternaam) {
	String mailHosts[] = {
		"@hotmail.com", "@gmail.com", "@yahoo.com",
		"@xs4all.nl", "@kpnmail.nl" , "@tele2.nl",
		"@ziggo.nl", "@upc.nl", "@rug.nl"
	};
	String res = voornaam + "." + achternaam + mailHosts[(int)(Math.random() * mailHosts.length)];
	
	return res.replace(" ", ".").toLowerCase();
    }
    
    private static String getRandomStraatnaam () {
	String voor[] = {
		"Hoofd" , "Zij" , "Tussen", "Saffier",
		"Grote" , "Kleine" , "Mooie",
		"Kastantje" , "Beuken" , "Berken",
	};	
	String achter[] = {
		"straat" , "weg" , "laan"
	};
	
	int r = (int) (Math.random() * voor.length);
	String res = voor[r];
	
	r = (int) (Math.random() * achter.length);	
	res += achter[r];
	
	return res;
    }
    
    private static String getRandomWoonplaats () {
	String woonplaatsLijst[] = {
		"Groningen" , "Drachten" , "Leeuwarden" , 
		"Meppel" , "Zwolle" , "Utrecht" , 
		"Amsterdam" , "Rotterdam" , "Den Haag",
		"Breda" , "Eindhoven" , "Tilburg"
	};
	
	return woonplaatsLijst[(int) (Math.random() * woonplaatsLijst.length)];
    }
    
    private static String getRandomPostcode () {
	String postcode = getRandomNummer(4) + " ";
	postcode += Character.toString( (char) (Integer.valueOf( getRandomNummer(1)) + 65) );
	postcode += Character.toString( (char) (Integer.valueOf( getRandomNummer(1)) + 65) );
	
	return postcode;	
    }
    
    private static double getRandomPrijs () {
	String res = getRandomNummer(2) + ".";
	res += getRandomNummer(2);
	
	return Double.valueOf(res);
    }
    
    private static String getRandomTitel () {
	String s1[] = {
		"De" ,  "Het" , "Een"
	};
	String s2[] = {
		"Leven", "Boom", "Paard", "Kat",
		"Boer", "Vrouw", "Man", "Aarde"
	};
	String s3[] = {
		"Van", "Op", "Aan", "Met", "Om"
	};
	String s4[] = {
		"Haar", "Hem", "Piet", "Bloemkool",
		"Bosbessen", "Televisie", "Viool",
		"Java", "Koepel", "Water"
	};
	
	String res = s1[(int)(Math.random() * s1.length)] + " ";
	res += s2[(int)(Math.random() * s2.length)] + " ";
	res += s3[(int)(Math.random() * s3.length)] + " ";
	res += s4[(int)(Math.random() * s4.length)];
	
	return res;	
    }

}
