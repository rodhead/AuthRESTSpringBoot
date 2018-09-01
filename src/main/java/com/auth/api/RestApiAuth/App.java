package com.auth.api.RestApiAuth;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.auth.api.util.HiberConnection;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan("com.auth.api")
public class App 
{
	@Autowired
	static HiberConnection con;
	
	static SessionFactory sf= null;
    public static void main( String[] args )
    {
    	
        SpringApplication.run(App.class, args);
       
    }
    
    @Bean
    public RestTemplate rest() {
    	return new RestTemplate();
    }

	
	
	public  SessionFactory runn() {
		System.out.println("=============== IN HIBER CON ============");
		
		Configuration config=new Configuration().configure("hibernate-annotation.cfg.xml");
		ServiceRegistry service= new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		
		sf=config.buildSessionFactory(service);
		return sf;
		
	}
}
