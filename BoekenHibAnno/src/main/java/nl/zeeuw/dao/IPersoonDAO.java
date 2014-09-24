package nl.zeeuw.dao;

import nl.zeeuw.model.Persoon;

/**
 * @author Pieter
 * 
 * @date 24 sep. 2014
 */
public interface IPersoonDAO {
    
    public Persoon findPersonByName (String name);
    
    public void persistPersoon (Persoon persoon);
    
    public void updatePersoon (Persoon persoon);
    
    public void deletePersoon (Persoon persoon);

}
