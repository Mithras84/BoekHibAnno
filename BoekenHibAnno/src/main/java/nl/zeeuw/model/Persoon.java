package nl.zeeuw.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Pieter
 * 
 * @date 24 sep. 2014
 */

@Entity 
@Table (name="persoon")
public class Persoon implements java.io.Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 6195413032646974148L;
    private int id;
    private String voorNaam;
    private String achterNaam;
    private String telefoonNr;
    private Boek boek;
    private Adres adres;
    
    public Persoon() {}

    @Id @GeneratedValue
    @Column (name = "id", unique = true, nullable = false)
    public int getId () {
	return this.id;
    }
    
    /**
     * @return the boek
     */
    @OneToOne (cascade = CascadeType.ALL)
    public Boek getBoek() {
        return this.boek;
    }
    

    /**
     * @return the adres
     */
    @Embedded
    public Adres getAdres() {
	return adres;
    }

    /**
     * @param boek the boek to set
     */
    public void setBoek(Boek boek) {
        this.boek = boek;
    }

    public void setId (int id) {
	this.id = id;
    }
    /**
     * @return the voorNaam
     */
    @Column (name="voornaam")
    public String getVoorNaam() {
        return this.voorNaam;
    }

    /**
     * @param voorNaam the voorNaam to set
     */
    public void setVoorNaam(String voorNaam) {
        this.voorNaam = voorNaam;
    }

    /**
     * @return the achterNaam
     */
    @Column (name="achternaam")
    public String getAchterNaam() {
        return this.achterNaam;
    }

    /**
     * @param achterNaam the achterNaam to set
     */
    public void setAchterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
    }

    /**
     * @return the telefoonNr
     */
    @Column (name="telefoonnummer")
    public String getTelefoonNr() {
        return this.telefoonNr;
    }

    /**
     * @param telefoonNr the telefoonNr to set
     */
    public void setTelefoonNr(String telefoonNr) {
        this.telefoonNr = telefoonNr;
    }


    /**
     * @param adres the adres to set
     */
    public void setAdres(Adres adres) {
	this.adres = adres;
    }

    

}
