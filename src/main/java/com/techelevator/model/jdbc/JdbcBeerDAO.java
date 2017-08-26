package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.Beer;
import com.techelevator.Brewery;
import com.techelevator.model.dao.BeerDAO;


@Component
public class JdbcBeerDAO implements BeerDAO{
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcBeerDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}

	@Override
	public List<Beer> getAllBeers() {
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM beers");
		List<Beer> beers = new ArrayList<>();
		while (results.next()){
			beers.add(mapRowToBeer(results));
		}
		return beers;
	}

	@Override
	public List<Beer> getAllBeersByBrewery(long breweryId) {
	List<Beer> beer= new ArrayList<>();
		
		SqlRowSet result = jdbcTemplate.queryForRowSet("SELECT * FROM beers JOIN breweries_beers ON beers.beer_id = breweries_beers.beer_id WHERE breweries_beers.brewery_id = ?", breweryId);
		while (result.next()) {
			beer.add(mapRowToBeer(result));
		}
		return beer; 
	}

	@Override
	public List<Beer> getAllBeersByType(long typeId) {
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM beers WHERE type_id=?",typeId);
		List<Beer> beers = new ArrayList<>();
		while (results.next()){
			beers.add(mapRowToBeer(results));
		}
		return beers;
	}

	@Override
	public Beer getBeerById(long beerId) {
		Beer beer = new Beer();
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM beers WHERE beer_id=?", beerId);
		if (results.next()){
		beer = mapRowToBeer(results);
	}
		return beer;

	}
	public Beer mapRowToBeer(SqlRowSet results) {
		Beer details = new Beer();
		details.setAlcoholPercentage(results.getString("alcohol_percentage"));
		details.setDescription(results.getString("description"));
		details.setName(results.getString("name"));
		details.setTypeId(results.getLong("type_id"));
		details.setBeerId(results.getLong("beer_id"));
		details.setImgUrl(results.getString("beer_img_url"));
		details.setReviews(results.getLong("reviews"));
		details.setTotalRating(results.getLong("total_rating"));
	
	
		return details;
	}
	
	@Override
	public void deleteBeer(long beerId) {
		jdbcTemplate.update("DELETE FROM reviews WHERE beer_id = ?", beerId);
		jdbcTemplate.update("DELETE FROM breweries_beers WHERE beer_id = ?", beerId);
		jdbcTemplate.update("DELETE FROM beers WHERE beer_id = ?", beerId);
	}

	@Override
	public long saveBeer(Beer beer) {
		String sqlSaveBeer = "INSERT INTO beers(name, alcohol_percentage, description, type_id) VALUES(?, ?, ?, ?) RETURNING beer_id";
		Long beerId = (long) jdbcTemplate.queryForObject(sqlSaveBeer, Long.class, beer.getName(), beer.getAlcoholPercentage(), beer.getDescription(), beer.getTypeId());

		return beerId;

	}
	@Override
	public long updateBeer(Beer beer) {
		String sqlSaveBeer = "UPDATE beers SET name=?, alcohol_percentage=?, description=?, type_id=? WHERE beer_id=?";
		jdbcTemplate.update(sqlSaveBeer, beer.getName(), beer.getAlcoholPercentage(), beer.getDescription(), beer.getTypeId(), beer.getBeerId());

		return beer.getBeerId();
	}

	@Override
	public long getBreweryIdByBeerId(long beerId) {
		String sqlGetBreweryId = "SELECT brewery_id FROM breweries_beers WHERE beer_id=?";
		long breweryId = jdbcTemplate.queryForObject(sqlGetBreweryId, Long.class,  beerId);
		return breweryId;
	}
}