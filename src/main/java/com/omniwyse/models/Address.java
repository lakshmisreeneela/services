package com.omniwyse.models;

import java.util.Date;

import javax.persistence.Table;

@Table(name = "useraddress")
public class Address {
	 private Long id;
	  private String doornumber; 
	  private String street; 
	  private String city; 
	  private String state; 
	  private String country;
	  private Long pin;
	  private Date createdOn;
	  public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDoornumber() {
		return doornumber;
	}
	public void setDoornumber(String doornumber) {
		this.doornumber = doornumber;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getPin() {
		return pin;
	}
	public void setPin(Long pin) {
		this.pin = pin;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	private Date modifiedOn;
}
