package nl.zeeuw.dao;

import nl.zeeuw.model.Persoon;
import nl.zeeuw.util.HibernateUtil;

import org.hibernate.Session;

/**
 * @author Pieter
 * 
 * @date 24 sep. 2014
 */
public class PersoonDAO implements IPersoonDAO {
    
    Session session = HibernateUtil.getSessionFactory().openSession();

    /** 
     * Overridden
     * @see nl.zeeuw.dao.IPersoonDAO#findPersonByName(java.lang.String)
     */
    public Persoon findPersonById(int id) {
	session.beginTransaction();	
	Persoon p = (Persoon) session.get(Persoon.class, id);	
	session.getTransaction().commit();
	
	return p;
    }

    /** 
     * Overridden
     * @see nl.zeeuw.dao.IPersoonDAO#persistPersoon(nl.zeeuw.model.Persoon)
     */
    public void persistPersoon(Persoon persoon) {
	session.beginTransaction();	
	session.save(persoon);	
	session.getTransaction().commit();
    }

    /** 
     * Overridden
     * @see nl.zeeuw.dao.IPersoonDAO#updatePersoon(nl.zeeuw.model.Persoon)
     */
    public void updatePersoon(Persoon persoon) {
	session.beginTransaction();	
	session.saveOrUpdate(persoon);	
	session.getTransaction().commit();
    }

    /** 
     * Overridden
     * @see nl.zeeuw.dao.IPersoonDAO#deletePersoon(nl.zeeuw.model.Persoon)
     */
    public void deletePersoon(Persoon persoon) {
	session.beginTransaction();	
	session.delete(persoon);	
	session.getTransaction().commit();
    }

}
