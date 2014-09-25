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
    
    Session session = HibernateUtil.getSessionFactory().openSession();

    /** 
     * Overridden
     * @see nl.zeeuw.dao.IBoekDAO#findBoekByISBN(long)
     */
    public Boek findBoekByISBN(long isbn) {
	session.beginTransaction();
	Boek b = (Boek) session.get(Boek.class, isbn);
	session.getTransaction().commit();
	return b;
    }

    /** 
     * Overridden
     * @see nl.zeeuw.dao.IBoekDAO#persistBoek(nl.zeeuw.model.Boek)
     */
    public void persistBoek(Boek boek) {
	session.beginTransaction();
	session.save(boek);
	session.getTransaction().commit();
    }

    /** 
     * Overridden
     * @see nl.zeeuw.dao.IBoekDAO#updateBoek(nl.zeeuw.model.Boek)
     */
    public void updateBoek(Boek boek) {
	session.beginTransaction();
	session.saveOrUpdate(boek);
	session.getTransaction().commit();
    }

    /** 
     * Overridden
     * @see nl.zeeuw.dao.IBoekDAO#deleteBoek(nl.zeeuw.model.Boek)
     */
    public void deleteBoek(Boek boek) {
	session.beginTransaction();
	session.delete(boek);
	session.getTransaction().commit();
    }
    
    

}
