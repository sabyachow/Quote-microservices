package com.rating.auto.model;

import java.util.List;

public class Quote {
	
	private long q_id;
	private List<Customer> customers;
	private List<Vehicle> vehicles;
	private long premium;
	
	public Quote() {}
	
	public Quote(long q_id, List<Customer> customers, List<Vehicle> vehicles, long premium) {
		this.q_id = q_id;
		this.customers = customers;
		this.vehicles = vehicles;
		this.premium = premium;
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

	public long getPremium() {
		return premium;
	}

	public void setPremium(long premium) {
		this.premium = premium;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	

}
