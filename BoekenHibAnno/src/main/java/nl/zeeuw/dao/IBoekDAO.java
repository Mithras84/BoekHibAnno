package nl.zeeuw.dao;

import nl.zeeuw.model.Boek;

/**
 * @author Pieter
 * 
 * @date 17 sep. 2014
 */
public interface IBoekDAO {
    
    public Boek findBoekByISBN (long isbn);
    
    public void persistBoek (Boek boek);
    
    public void updateBoek (Boek boek);
    
    public void deleteBoek (Boek boek);

}
