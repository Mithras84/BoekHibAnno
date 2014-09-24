package nl.zeeuw.dao;

import nl.zeeuw.model.Boek;
import nl.zeeuw.util.HibernateUtil;

import org.hibernate.Session;

/**
 * @author Pieter
 * 
 * @date 18 sep. 2014
 */
public class BoekDAO implements IBoekDAO {
    
    //SessionFactory sessionFactory = HibernateUtil.getSessionFactory().openSession();  
    
    Session session = HibernateUtil.getSessionFactory().getCurrentSession();

    /** 
     * Overridden
     * @see nl.zeeuw.dao.IBoekDAO#findBoekByISBN(long)
     */
    public Boek findBoekByISBN(long isbn) {	
	return (Boek) session.createSQLQuery("from Boek where isbn = :isbn").setParameter ("isbn", isbn).uniqueResult();
    }

    /** 
     * Overridden
     * @see nl.zeeuw.dao.IBoekDAO#persistBoek(nl.zeeuw.model.Boek)
     */
    public void persistBoek(Boek boek) {
	//sessionFactory.getCurrentSession().persist(boek);
	session.beginTransaction();
	
	session.save(boek);
	
	session.getTransaction().commit();
    }

    /** 
     * Overridden
     * @see nl.zeeuw.dao.IBoekDAO#updateBoek(nl.zeeuw.model.Boek)
     */
    public void updateBoek(Boek boek) {
	//sessionFactory.getCurrentSession().update(boek);
    }

    /** 
     * Overridden
     * @see nl.zeeuw.dao.IBoekDAO#deleteBoek(nl.zeeuw.model.Boek)
     */
    public void deleteBoek(Boek boek) {
	//sessionFactory.getCurrentSession().delete(boek);
    }
    
    

}
