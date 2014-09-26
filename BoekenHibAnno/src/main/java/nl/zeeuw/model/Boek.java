package nl.zeeuw.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * @author Pieter
 * 
 * @date 17 sep. 2014
 */

@Entity
@Table(name = "boek")
public class Boek implements java.io.Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 7858249757697276425L;

    private long isbn;

    private Persoon auteur;

    private String titel;
    
    @Column (name = "prijs")
    private double prijs;
    
    
    public Boek () {	
    }

    /**
     * @return the isbn
     */
    @Id
    @Column (name = "isbn", unique = true, nullable = false)
    public long getIsbn() {
        return this.isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the auteur
     */
    @OneToOne(cascade = CascadeType.ALL)
    public Persoon getAuteur() {
        return this.auteur;
    }

    /**
     * @param auteur the auteur to set
     */
    public void setAuteur(Persoon auteur) {
        this.auteur = auteur;
    }

    /**
     * @return the titel
     */
    @Column (name = "titel")
    public String getTitel() {
        return this.titel;
    }

    /**
     * @param titel the titel to set
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }

    /**
     * @return the prijs
     */
    
    public double getPrijs() {
        return this.prijs;
    }

    /**
     * @param prijs the prijs to set
     */
    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
    
    

}
