package com.apo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.apo.model.Text;

public class TextMethodsImpl implements TextMethods{

	SessionFactory sessFact = HibernateUtil.getSessionFactory();
	
	public void close(){
		sessFact.close();
	}
	// add new text
	@Override
	public void addText(String id, String text){
		Session session = sessFact.openSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		
		try{
			Text newText = new Text();
			newText.setId(id);
			newText.setText(text);
			session.save(newText);
			tr.commit();
		}catch (HibernateException e) {
			if (tr!=null) 
				tr.rollback();
			
		}finally {
			session.close(); 
		}
			
	}
	// edit text
	@Override
	public void editText(Text text){
		Session session = sessFact.openSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		System.out.println("transaction began");
		
		try{	
			session.saveOrUpdate(text);
			System.out.println("query sent");
			tr.commit();
		}catch (HibernateException e) {
			if (tr!=null) 
				tr.rollback();
			System.out.println("exception");
			System.out.println(e.toString());
		}finally {
			session.close(); 
		}
			
	}
	// retrieve text
	@Override
	public Text retrieveText(String id){
		Session session = sessFact.openSession();
		org.hibernate.Transaction tr = session.beginTransaction();
		System.out.println("transaction began");
		Text newText = new Text();
		try{	
			
			Text retrievedText = session.get(Text.class, id);
			System.out.println("query sent");
			if(retrievedText == null){
				newText.setId("n/a");
				newText.setText("Failed");
				System.out.println("It Failed!");
			}
			else{
				System.out.println("It Worked!");
				newText.setId(retrievedText.getId());
				newText.setText(retrievedText.getText());
			}
			
			tr.commit();
		}catch (HibernateException e) {
			if (tr!=null) 
				tr.rollback();
			System.out.println("exception");
			System.out.println(e.toString());
		}finally {
			session.close(); 
		}
		System.out.println("return");
		return newText;	
	}
	
	
}
