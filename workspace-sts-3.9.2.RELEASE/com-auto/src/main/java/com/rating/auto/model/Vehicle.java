package com.rating.auto.model;

public class Vehicle {
	private String vin;
	private String make;
	private String model;
	private String year;
	
	public Vehicle() {}
	
	public Vehicle(String vin, String make, String model, String year) {
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.year = year;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getYear() {
		return year;
	}

}
