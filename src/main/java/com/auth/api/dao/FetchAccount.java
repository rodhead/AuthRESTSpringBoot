package com.auth.api.dao;

import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.auth.api.RestApiAuth.App;
import com.auth.api.model.AccountDetails;

@Configuration
public class FetchAccount {

	@Autowired
	App app;

	Session session = null;
	SessionFactory sf = null;
	Transaction tx=null;

	@SuppressWarnings("unchecked")
	public List<AccountDetails> fetch() {
		List<AccountDetails> list = new ArrayList<AccountDetails>();
		try {
			sf = app.runn();
			session = sf.openSession();
			session.beginTransaction();

			Query query = session.createQuery("from AccountDetails");
			list = query.list();

		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		finally {
			session.close();
			sf.close();
		}

		return list;
	}
	
	public AccountDetails updatemethod(AccountDetails accDetails) {
		
		AccountDetails accd= new AccountDetails();
		try {
		sf=app.runn();
		session = sf.openSession();
		tx= session.beginTransaction();
		 
		  session.update(accDetails);
		 tx.commit();
		 
		  
		  
		}
		catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			session.close();
			sf.close();
			
		}
		return accDetails;
	}
	
	public AccountDetails insertObj(AccountDetails accd) {
		try {
			int id= getId();
			sf=app.runn();
			session = sf.openSession();
			tx= session.beginTransaction();
			
			if(!(id==0)) {
				accd.setId(id+1);
			  session.save(accd);
			 tx.commit();
			}
			
			  
			  
			}
			catch(Exception e) {
				tx.rollback();
				e.printStackTrace();
			}
			finally {
				session.close();
				sf.close();
				
			}
		
		return accd;
	}

	@SuppressWarnings("unchecked")
	private int getId() {
		List<AccountDetails> list=new ArrayList<AccountDetails>();
		int id=0;
		try {
		 sf=app.runn();
		session =sf.openSession();
		session.beginTransaction();
		
		list=session.createQuery("from AccountDetails").list();
		for(AccountDetails acc: list) {
			id=acc.getId();
		}
		}
		catch(Exception e) {
			e.getMessage();
		}
		finally{
			session.close();
			sf.close();
		}
		return id;
	}

	public String validateName(String name, int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
