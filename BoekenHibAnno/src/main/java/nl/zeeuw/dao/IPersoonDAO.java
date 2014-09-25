package nl.zeeuw.dao;

import nl.zeeuw.model.Persoon;

/**
 * @author Pieter
 * 
 * @date 24 sep. 2014
 */
public interface IPersoonDAO {
    
    public Persoon findPersonById (int Id);
    
    public void persistPersoon (Persoon persoon);
    
    public void updatePersoon (Persoon persoon);
    
    public void deletePersoon (Persoon persoon);

}
