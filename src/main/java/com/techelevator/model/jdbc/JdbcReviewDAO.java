package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.Review;
import com.techelevator.model.dao.ReviewDAO;

@Component
public class JdbcReviewDAO implements ReviewDAO {
	
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcReviewDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public List<Review> getReviewsByBeerId(long beerId) {
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM reviews WHERE beer_id=?", beerId);

		List<Review> reviews = new ArrayList<>();
		while (results.next()) {
			reviews.add(mapRowToReview(results));
		}

		return reviews;
	}
	

	@Override
	public List<Review> getReviewsByUserId(long userId) {
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM reviews WHERE user_id=?", userId);

		List<Review> reviews = new ArrayList<>();
		while (results.next()) {
			reviews.add(mapRowToReview(results));
		}

		return reviews;
		
	}
	
	public Review mapRowToReview(SqlRowSet results) {
		Review details = new Review();
		details.setReviewId(results.getLong("id"));
		details.setReviewText(results.getString("review_text"));
		details.setRating(results.getInt("rating"));
		details.setUserId(results.getLong("user_id"));
		details.setBeerId(results.getLong("beer_id"));
		details.setUsername(results.getString("username"));

		return details;
	}

	@Override
	public void postReview(Review review, long userId, String username) {
		jdbcTemplate.update("INSERT INTO reviews (rating, review_text, user_id, beer_id, username) VALUES (?,?,?,?,?)", review.getRating(), review.getReviewText(), userId, review.getBeerId(), username);
	}

}
