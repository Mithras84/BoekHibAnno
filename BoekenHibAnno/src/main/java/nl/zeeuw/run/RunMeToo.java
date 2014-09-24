package nl.zeeuw.run;

import nl.zeeuw.model.Boek;
import nl.zeeuw.model.Persoon;
import nl.zeeuw.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * @author Pieter
 * 
 * @date 18 sep. 2014
 */
public class RunMeToo {

    /**
     * @param args
     */
    public static void main(String[] args) {
	System.out.println("Run me too!");
	testHib1();
	testHebAnnoPersoon();
    }
    
    public static void testHib1 () {
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	Transaction tx = session.beginTransaction();
	
	Boek b = new Boek ();
	b.setIsbn(1234567891011l);
	b.setAuteur("Henkie");
	b.setTitel("Boek 1");
	b.setPrijs(21.99);
	
	long bId = (Long) session.save(b);
	
	tx.commit();
	session.close();
	
	System.out.println("ID is " + bId);
	System.out.println("Trying to grab Boek1");
	
	Session session2 = HibernateUtil.getSessionFactory().openSession();
	
	Transaction t2 = session2.beginTransaction();
	Boek b2 = (Boek) session2.get(Boek.class, 1234567891011l);
	
	System.out.println("Titel " + b2.getTitel() + " Auteur " + b2.getAuteur());
	t2.commit();
	session2.close();
    }
    
    public static void testHebAnnoPersoon () {
	Session session = HibernateUtil.getSessionFactory().openSession();
	
	Transaction tx = session.beginTransaction();
	
	Persoon p = new Persoon ();
	p.setVoorNaam("Henkie");
	p.setAchterNaam("de Vries");
	p.setTelefoonNr("123456789");
	 
	session.save(p);
	System.out.println("Person Saved?");
	tx.commit();
	session.close();
	 /*
	Session s2 = HibernateUtil.getSessionFactory().openSession();
	
	Transaction t2 = s2.beginTransaction();
	
	Persoon p2 = (Persoon) s2.get
	
	*/
	 
    }

}
