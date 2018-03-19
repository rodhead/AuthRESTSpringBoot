package com.auth.api.dao;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.auth.api.RestApiAuth.App;
import com.auth.api.model.AccountDetails;

@Configuration
public class FetchAccount {

	@Autowired
	App app;

	Session session = null;
	SessionFactory sf = null;

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

}
