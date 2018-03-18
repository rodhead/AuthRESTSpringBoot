package com.auth.api.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.auth.api.RestApiAuth.App;
import com.auth.api.model.AccountDetails;

@Configuration
public class FetchAccount {
	
	@Autowired App app;
	
	
	public List<AccountDetails> fetch(){
		SessionFactory sf=app.runn();
		Session session=sf.openSession();
		session.beginTransaction();
		List<AccountDetails> list=new ArrayList<AccountDetails>();
		list=session.createSQLQuery("select * from AccountDetails").list();
		
		return list;
		
	}

}
