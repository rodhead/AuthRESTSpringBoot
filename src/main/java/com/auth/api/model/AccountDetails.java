package com.auth.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="AccountDetails")
public class AccountDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="Location")
	private String Location;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}
	
	
	
	
	
	

}
