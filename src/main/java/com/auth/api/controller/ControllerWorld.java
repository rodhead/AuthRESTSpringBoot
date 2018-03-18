package com.auth.api.controller;

import java.awt.PageAttributes.MediaType;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.api.dao.FetchAccount;
import com.auth.api.model.AccountDetails;





@RestController

public class ControllerWorld {
	
	@Autowired FetchAccount acc;
	
	
	@GetMapping("/service/hello")
		public  @ResponseBody String helloWorld() {
		System.out.println("I Am Here-------------------->");
		return "hello";
	}
	
	@GetMapping("service/fetch")
	public @ResponseBody List fetch() {
		List<AccountDetails> list=acc.fetch();
		
		return list;
	}
	

}
