package com.techelevator;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

public class Brewery {
	
	private long breweryId;
	
	@NotBlank(message="Name is a required field")
	@Size(max=50, message="Brewery name must be less than 50 characters")
	private String name;
	
	
	
	private String password;
	
	
	private String confirmPassword;
	
	private boolean passwordMatching; 
	@AssertTrue(message="Passwords must match")
	
	public boolean isPasswordMatching() {
		if(password != null) {
			return password.equals(confirmPassword);
		} else {
			return false;
		}
	}
	
	@NotBlank(message="Address is a required field")
	private String address;
	
	private String address2;
	
	@NotBlank(message="City is a required field")
	private String city;
	
	@NotBlank(message="You must select a State")
	private String state;
	
	@NotBlank(message="Zip Code is a required field")
	private String zipCode;
	
	private boolean hasFood;
	
	private String description;
	private String imgUrl;
	
	@NotBlank(message="Website is a required field")
	private String website;
	
	@NotBlank(message="Phone Number is a required field")
	private String phoneNumber;
	
	private String sundayHours;
	private String mondayHours;
	private String tuesdayHours;
	private String wednesdayHours;
	private String thursdayHours;
	private String fridayHours;
	private String saturdayHours;
	private String mapsAddress;
	private double lat;
	private double lng;
	
	public long getBreweryId() {
		return breweryId;
	}
	public void setBreweryId(long breweryId) {
		this.breweryId = breweryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public void setPasswordMatching(boolean passwordMatching) {
		this.passwordMatching = passwordMatching;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public boolean isHasFood() {
		return hasFood;
	}
	public void setHasFood(boolean hasFood) {
		this.hasFood = hasFood;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSundayHours() {
		return sundayHours;
	}
	public void setSundayHours(String sundayHours) {
		this.sundayHours = sundayHours;
	}
	public String getMondayHours() {
		return mondayHours;
	}
	public void setMondayHours(String mondayHours) {
		this.mondayHours = mondayHours;
	}
	public String getTuesdayHours() {
		return tuesdayHours;
	}
	public void setTuesdayHours(String tuesdayHours) {
		this.tuesdayHours = tuesdayHours;
	}
	public String getWednesdayHours() {
		return wednesdayHours;
	}
	public void setWednesdayHours(String wednesdayHours) {
		this.wednesdayHours = wednesdayHours;
	}
	public String getThursdayHours() {
		return thursdayHours;
	}
	public void setThursdayHours(String thursdayHours) {
		this.thursdayHours = thursdayHours;
	}
	public String getFridayHours() {
		return fridayHours;
	}
	public void setFridayHours(String fridayHours) {
		this.fridayHours = fridayHours;
	}
	public String getSaturdayHours() {
		return saturdayHours;
	}
	public void setSaturdayHours(String saturdayHours) {
		this.saturdayHours = saturdayHours;
	}
	public String getMapsAddress() {
		if(address2 == null) {
			mapsAddress = address + ", " + city + ", " + state + ", " + zipCode;
		} else {
			mapsAddress = address + ", " + address2 + ", " + city + ", " + state + ", " + zipCode;
		}
		return mapsAddress;
	}
	
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}

}
