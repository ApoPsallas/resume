package com.apo;

import java.security.*;
import java.math.*;

import org.hibernate.Criteria;
import org.hibernate.HibernateException; 

import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.QueryProducer;
import org.hibernate.SessionFactory;



import java.util.List;


import com.apo.model.Admin;


/**
 *
 * @author Apostolis
 */
public class AdminMethodsImpl implements AdminMethods {
	SessionFactory sessFact = HibernateUtil.getSessionFactory();

	/* (non-Javadoc)
	 * @see com.apo.AdminMethods#close()
	 */
	@Override
	public void close(){
		sessFact.close();
	}
	//addUser
	/* (non-Javadoc)
	 * @see com.apo.AdminMethods#addUser(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addUser(String userName, String password) throws NoSuchAlgorithmException{
		Session session = sessFact.openSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		String hash = null;
		try{
			
			hash = encrypt(password);
			Admin newAdmin = new Admin();
			newAdmin.setUserName(userName);
			newAdmin.setPassword(hash);
			session.save(newAdmin);
			tr.commit();
		}catch (HibernateException e) {
			if (tr!=null) 
				tr.rollback();
			return false;
		}finally {
			session.close(); 
		}
		return true;
	}

	// authenticate
	/* (non-Javadoc)
	 * @see com.apo.AdminMethods#authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public Admin authenticate(String userName, String password) throws NoSuchAlgorithmException{
		Session session = sessFact.openSession();
			
		String hash = null;
		Admin admin;
		org.hibernate.Transaction tr = session.beginTransaction();
		System.out.println("transaction began");
		try{	
			hash = encrypt(password);
			Criteria cr = session.createCriteria(Admin.class);
			Criterion name = Restrictions.like("userName", userName);
			Criterion pass = Restrictions.like("password", hash);
			System.out.println("query sent");
			LogicalExpression andExp = Restrictions.and(name, pass);
			List qResult = cr.add( andExp ).list();
			System.out.println(qResult.size());
			if (qResult.size()>0)
				{admin = (Admin) qResult.get(0);
				
				}
			else
				{admin = null;}
			tr.commit();
		}catch (HibernateException e) {
			if (tr!=null) 
				tr.rollback();
			admin = null;
			System.out.println("exception");
			System.out.println(e.toString());
		}finally {
			session.close(); 
		}
		System.out.println("what Happened?");
		
		return admin;
	}


	

	//md5 hash

	/* (non-Javadoc)
	 * @see com.apo.AdminMethods#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String password) throws NoSuchAlgorithmException{


		MessageDigest m =MessageDigest.getInstance("MD5");
		m.update(password.getBytes(),0,password.length());
		String hash = new BigInteger(1,m.digest()).toString(16);
		System.out.println(hash);
		return hash;
	}



}