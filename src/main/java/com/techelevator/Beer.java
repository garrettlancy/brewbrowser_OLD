package com.techelevator;

import org.hibernate.validator.constraints.NotBlank;

public class Beer{

	@NotBlank(message="Name is a required field")
	private String name; 
	
	@NotBlank(message="Alcohol Percentage is a required field")
	private String alcoholPercentage;
	
	@NotBlank(message="Description is a required field")
	private String description;
	
	private long typeId;
	private long beerId;
	private String ImgUrl;
	private String type;
	private long reviews;
	private long totalRating;
	private long avgRating;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlcoholPercentage() {
		return alcoholPercentage;
	}
	public void setAlcoholPercentage(String alcoholPercentage) {
		this.alcoholPercentage = alcoholPercentage;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getTypeId() {
		return typeId;
	}
	public String getType() {
		if (this.typeId == 1) {
			this.type = "Stout";
		} else if (this.typeId == 2) {
			this.type = "Lager";
		} else if (this.typeId == 3) {
			this.type = "IPA";
		} else if (this.typeId == 4) {
			this.type = "Doppelbock";
		} else if (this.typeId == 5) {
			this.type = "Hefeweizen";
		} else if (this.typeId == 6) {
			this.type = "Blonde";
		} else if (this.typeId == 7) {
			this.type = "Pilsner";
		} else if (this.typeId == 8) {
			this.type = "Pale Ale";
		} else if (this.typeId == 9) {
			this.type = "Sour Ale";
		} else {
			this.type = "???";
		}
		return this.type;
	}
	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}
	public long getBeerId() {
		return beerId;
	}
	public void setBeerId(long beerId) {
		this.beerId = beerId;
	}
	public String getImgUrl() {
		return ImgUrl;
	}
	public void setImgUrl(String imgUrl) {
		ImgUrl = imgUrl;
	}
	public long getReviews() {
		return reviews;
	}
	public void setReviews(long reviews) {
		this.reviews = reviews;
	}
	public void setTotalRating(long totalRating) {
		this.totalRating = totalRating;
	}
	public long getAvgRating() {
		return totalRating / reviews;
	}

}