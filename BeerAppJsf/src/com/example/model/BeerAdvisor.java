package com.example.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.hibernate.HibernateUtil;

public class BeerAdvisor {
	
	@SuppressWarnings("unchecked")
	public List<Beer> getBeers(String color) {
		
		List<Beer> beers;		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();		
		if(color.equals("Dark")) {
			beers = session.createQuery("select a from Beer a, BeerType b  where a.type = b.id and b.type='Dark'").list();
		}
		else if(color.equals("Brown")) {
			beers = session.createQuery("select a from Beer a, BeerType b  where a.type = b.id and b.type='Brown'").list();
		}
		else if(color.equals("Amber")) {
			beers = session.createQuery("select a from Beer a, BeerType b  where a.type = b.id and b.type='Amber'").list();
		}
		else {
			beers = session.createQuery("select a from Beer a, BeerType b  where a.type = b.id and b.type='Light'").list();
		}
		tx.commit();
		//session.close();
		// Shutting down the application
		//HibernateUtil.shutdown();		
		return beers;				
		
	}

}
