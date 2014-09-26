package nl.zeeuw.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Dient als Embeddable voor Persoon. In de database zal een persoon al de velden van het adres bevatten.
 * Deze klasse heeft geen DAO nodig, omdat er geen aparte tabel voor bestaat in de DB. Dit loopt dus allemaal
 * via Persoon.
 * 
 * @author Pieter
 * 
 * @date 26 sep. 2014
 */
@Embeddable 
public class Adres {
    private String straatNaam;
    private int huisNummer;
    private String postCode;
    
    public Adres () {
	
    }

    /**
     * @return the straatNaam
     */
    @Column (name = "straatnaam")
    public String getStraatNaam() {
        return this.straatNaam;
    }

    /**
     * @param straatNaam the straatNaam to set
     */
    public void setStraatNaam(String straatNaam) {
        this.straatNaam = straatNaam;
    }

    /**
     * @return the huisNummer
     */
    @Column (name = "huisnummer")
    public int getHuisNummer() {
        return this.huisNummer;
    }

    /**
     * @param huisNummer the huisNummer to set
     */
    public void setHuisNummer(int huisNummer) {
        this.huisNummer = huisNummer;
    }

    /**
     * @return the postCode
     */
    @Column (name = "postcode")
    public String getPostCode() {
        return this.postCode;
    }

    /**
     * @param postCode the postCode to set
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    
    

}
