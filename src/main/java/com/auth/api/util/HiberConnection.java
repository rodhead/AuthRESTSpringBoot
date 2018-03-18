package com.auth.api.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HiberConnection {
	static SessionFactory sf= null;
	
	
	public  void runn() {
		System.out.println("=============== IN HIBER CON ============");
		
		Configuration config=new Configuration().configure("hibernate-annotation.cfg.xml");
		ServiceRegistry service= new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		
		sf=config.buildSessionFactory(service);
		
	}

}
