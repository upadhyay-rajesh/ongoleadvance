package com.facebookweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.facebookweb.entity.FacebookUser;

public class FacebookDAO implements FacebookDAOInterface {

	public int createProfileDAO(FacebookUser fb) {
		int i = 0;
		/*
		 * try { Class.forName("oracle.jdbc.driver.OracleDriver"); Connection
		 * con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
		 * "system","rajesh"); PreparedStatement
		 * ps=con.prepareStatement("insert into facebookweb values(?,?,?,?)");
		 * ps.setString(1, fb.getName()); ps.setString(2, fb.getPassword());
		 * ps.setString(3,fb.getEmail() ); ps.setString(4, fb.getAddress());
		 * i=ps.executeUpdate(); } catch(Exception e) { e.printStackTrace(); }
		 */

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.save(fb); // s.load() select, s.delete(), s.update();

		EntityTransaction et = s.getTransaction();
		et.begin();
		et.commit();
		i = 1;
		return i;
	}

	public int loginProfileDAO(FacebookUser fb) {
		int i = 0;
		/*
		 * try { Class.forName("oracle.jdbc.driver.OracleDriver"); Connection
		 * con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
		 * "system","rajesh"); PreparedStatement ps=con.
		 * prepareStatement("select * from facebookweb where name=? and password=?");
		 * ps.setString(1, fb.getName()); ps.setString(2, fb.getPassword());
		 * 
		 * ResultSet res=ps.executeQuery(); if(res.next()) { i=1; } } catch(Exception e)
		 * { e.printStackTrace(); }
		 */

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Query q = s.createQuery("from com.facebookweb.entity.FacebookUser f where f.name=:n and f.password=:p");
		q.setParameter("n", fb.getName());
		q.setParameter("p", fb.getPassword());
		List<FacebookUser> fl = q.getResultList();

		return fl.size();
	}

	public FacebookUser viewProfileDAO(FacebookUser fb) {
		FacebookUser fs = null;
		/*
		 * try { Class.forName("oracle.jdbc.driver.OracleDriver"); Connection
		 * con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
		 * "system","rajesh"); PreparedStatement
		 * ps=con.prepareStatement("select * from facebookweb where name=? ");
		 * ps.setString(1, fb.getName());
		 * 
		 * ResultSet res=ps.executeQuery(); if(res.next()) { fs=new FacebookUser();
		 * fs.setName(res.getString(1)); fs.setPassword(res.getString(2));
		 * fs.setEmail(res.getString(3)); fs.setAddress(res.getString(4)); } }
		 * catch(Exception e) { e.printStackTrace(); }
		 */
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Query q = s.createQuery("from com.facebookweb.entity.FacebookUser f where f.name=:n ");
		q.setParameter("n", fb.getName());
		fs = (FacebookUser) q.getSingleResult();
		return fs;
	}

	public int deleteProfile(FacebookUser fb) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Query q = s.createQuery("delete from com.facebookweb.entity.FacebookUser f where f.name=:n ");
		q.setParameter("n", fb.getName());
		int i=q.executeUpdate();
		EntityTransaction et = s.getTransaction();
		et.begin();
		et.commit();
		return i;
	}

	public int updateProfile(FacebookUser fb) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Query q = s.createQuery("update com.facebookweb.entity.FacebookUser set f.address=:a f where f.name=:n ");
		q.setParameter("n", fb.getName());
		q.setParameter("a", fb.getAddress());
		int i=q.executeUpdate();
		EntityTransaction et = s.getTransaction();
		et.begin();
		et.commit();
		return i;
	}

	public List<FacebookUser> viewAllProfile() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();

		Query q = s.createQuery("from com.facebookweb.entity.FacebookUser f ");
		return q.getResultList();
	}

}






