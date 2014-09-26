package nl.zeeuw.run;

import nl.zeeuw.model.Boek;
import nl.zeeuw.model.Persoon;

/**
 * @author Pieter
 * 
 * @date 26 sep. 2014
 */
public class PrintObject {
    
    public static void printPersoon (Persoon p) {
	System.out.println("Naam: " + p.getVoorNaam() + " " + p.getAchterNaam());
	System.out.println("Email: " + p.getEmailAdres() + " Tel: " + p.getTelefoonNr());
	System.out.println("Adres");
	System.out.println(p.getAdres().getStraatNaam() + " " + p.getAdres().getHuisNummer());
	System.out.println(p.getAdres().getPostCode() + " te " + p.getAdres().getWoonPlaats());
    }
    
    public static void printBoek (Boek b) {
	System.out.println("Titel: " + b.getTitel());
	System.out.println("Auteur: " + b.getAuteur().getAchterNaam() + ", " + b.getAuteur().getVoorNaam());
	System.out.println("ISBN: " + b.getIsbn());
	System.out.println("Prijs: " + b.getPrijs());
    }

}
