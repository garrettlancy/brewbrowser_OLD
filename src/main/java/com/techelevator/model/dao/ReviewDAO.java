package com.techelevator.model.dao;

import java.util.List;

import com.techelevator.Review;

public interface ReviewDAO {

	public List<Review> getReviewsByBeerId(long beerId);
	public List<Review> getReviewsByUserId(long userId);
	void postReview(Review review, long userId, String username);
}
