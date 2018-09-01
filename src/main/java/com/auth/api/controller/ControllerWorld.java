package com.auth.api.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.auth.api.dao.FetchAccount;
import com.auth.api.model.AccountDetails;





@RestController

public class ControllerWorld {
	
	@Autowired RestTemplate restTemplate;
	@Autowired FetchAccount acc;
	
	AccountDetails ad= new AccountDetails();
	
	@GetMapping("service/hello/{id}")
		public  @ResponseBody String helloWorld(@PathVariable("id") int id) {
		System.out.println("I Am Here-------------------->"+id);
		return "hello";
	}
	
	@GetMapping("service/fetch")
	public @ResponseBody List fetch() {
		List<AccountDetails> list=acc.fetch();
		
		return list;
	}
	
	@PutMapping("update")
	public @ResponseBody AccountDetails updateMethod(@RequestBody  AccountDetails accdetails){
		
		
		ad=acc.updatemethod(accdetails);
		return ad;
		
	}
	
	
	@PostMapping("insert")
	public @ResponseBody AccountDetails insertObj(@RequestBody AccountDetails accd) {
		
		return acc.insertObj(accd);
	}
	
	@GetMapping("validateInsert")
	public String validateRequestInsert(String name, int id) {
		
		String URL="https://localhost:8082/get?id=1&name='Mary'";
		ResponseEntity<AccountDetails> getResponse =restTemplate.getForEntity(URL, AccountDetails.class);
		if(getResponse.getBody() !=null) {
			System.out.println("response=========> : "+getResponse.getBody().toString());
		}
		return null;
		
	}

}
