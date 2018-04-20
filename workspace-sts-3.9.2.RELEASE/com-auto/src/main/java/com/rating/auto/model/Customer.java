package com.rating.auto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
	private long id;
	private String firstname;
	private String lastname;
	private String DL;
	private String eligibility;
	
    @Override
    public String toString() {
        return "Value{" +
                "id=" + id + 
                ", fname=" + firstname + ", lname=" + lastname + ", DL=" + DL +
                '}';
    }
	
	
	public void setId(long id) {
		this.id = id;
	}

	public void setfirstname(String fname) {
		this.firstname = fname;
	}

	public void setlastname(String lname) {
		this.lastname = lname;
	}

	public void setDL(String d_id) {
		this.DL = d_id;
	}

	public long getId() {
		return id;
	}
	public String getfirstname() {
		return firstname;
	}
	public String getlastname() {
		return lastname;
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
