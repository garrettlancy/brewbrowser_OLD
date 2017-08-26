package com.techelevator;

public class Review {

	private int rating;
	private String reviewText;
	private long reviewId;
	private long userId;
	private long beerId;
	private String username;
	
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getBeerId() {
		return beerId;
	}
	public void setBeerId(long beerId) {
		this.beerId = beerId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
