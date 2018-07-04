package com.rating.auto.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quotes")
public class Quote {
	
	@Id
	private long q_id;
	
	private String type;
	private List<Customer> customers;
	private List<Vehicle> vehicles;
	private double m_premium;
	private double y_premium;
	
	public Quote() {}
	
	public Quote(long q_id, String type, List<Customer> customers, List<Vehicle> vehicles, double m_premium, double y_premium) {
		this.q_id = q_id;
		this.type = type;
		this.customers = customers;
		this.vehicles = vehicles;
		this.m_premium = m_premium;
		this.y_premium = y_premium;

	}
	
	public double getM_premium() {
		return m_premium;
	}

	public void setM_premium(double m_premium) {
		this.m_premium = m_premium;
	}

	public double getY_premium() {
		return y_premium;
	}

	public void setY_premium(double y_premium) {
		this.y_premium = y_premium;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public long getQ_id() {
		return q_id;
	}

	public void setQ_id(long q_id) {
		this.q_id = q_id;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	

}
