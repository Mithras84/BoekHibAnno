package nl.zeeuw.dao;

import org.hibernate.Session;

import nl.zeeuw.model.Boek;
import nl.zeeuw.model.Persoon;
import nl.zeeuw.util.HibernateUtil;

/**
 * @author Pieter
 * 
 * @date 24 sep. 2014
 */
public class PersoonDAO implements IPersoonDAO {
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    /** 
     * Overridden
     * @see nl.zeeuw.dao.IPersoonDAO#findPersonByName(java.lang.String)
     */
    public Persoon findPersonByName(String name) {
	return (Persoon) session.createSQLQuery("from Persoon where name = :name").setParameter ("name", name).uniqueResult();
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
    }

    /** 
     * Overridden
     * @see nl.zeeuw.dao.IPersoonDAO#deletePersoon(nl.zeeuw.model.Persoon)
     */
    public void deletePersoon(Persoon persoon) {
    }

}
