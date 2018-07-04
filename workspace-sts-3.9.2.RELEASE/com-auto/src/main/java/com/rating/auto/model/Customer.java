package com.rating.auto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue
	private long id;
	private String fname;
	private String lname;
	private String DL;
	private String eligibility;
	
	public Customer() {
		super();
	}
	
	public Customer(long id, String fname, String lname, String d_id) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.DL = d_id;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}

	public void setf(String fname) {
		this.fname = fname;
	}

	public void setl(String lname) {
		this.lname = lname;
	}

	public void setDL(String d_id) {
		this.DL = d_id;
	}

	public long getId() {
		return id;
	}
	public String getfname() {
		return fname;
	}
	public String getlname() {
		return lname;
	}
	public String getDL() {
		return DL;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}
	

}
