package com.techelevator.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import com.techelevator.Brewery;
import com.techelevator.model.dao.BreweryDAO;

@Component
public class JdbcBreweryDAO<breweryId> implements BreweryDAO{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcBreweryDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	@Override
	public List<Brewery> getAllBreweryDetails() {
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM breweries");

		List<Brewery> breweries = new ArrayList<>();
		while (results.next()) {
			breweries.add(mapRowToBrewery(results));
		}

		return breweries;
	}
	
	@Override
	public List<String> getAllBreweryMapsAddresses() {
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM breweries");

		List<String> addresses = new ArrayList<>();
		while (results.next()) {
			addresses.add(mapRowToBrewery(results).getMapsAddress());
		}
		return addresses;
	}

	@Override
	public Brewery getBrewery(String name) {
		Brewery brewery = null;
		String sqlSelectBrewery = "SELECT * FROM breweries WHERE name = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectBrewery, name);
		if(results.next()) {
			brewery = mapRowToBrewery(results);
		}
		return brewery;
	}

	@Override
	public Brewery getBreweryById(long breweryId) {
		SqlRowSet result = jdbcTemplate.queryForRowSet("SELECT * FROM breweries WHERE brewery_id=?", breweryId);
		if (result.next()) {
			Brewery breweryDetails = mapRowToBrewery(result);
			return breweryDetails;
		} else {
			return null;
		}
	}
	@Override
	public List<Brewery> getBreweriesByBrewerEmail(String email) {
		List<Brewery> breweries= new ArrayList<>();

		SqlRowSet result = jdbcTemplate.queryForRowSet("SELECT * FROM breweries JOIN breweries_users ON breweries_users.brewery_id = breweries.brewery_id WHERE breweries_users.user_id = (SELECT id FROM users WHERE users.email=?)", email);
		while (result.next()) {
			breweries.add(mapRowToBrewery(result));
		}
		return breweries; 
	}
	public Brewery mapRowToBrewery(SqlRowSet results) {
		Brewery details = new Brewery();
		details.setBreweryId(results.getLong("brewery_id"));
		details.setName(results.getString("name"));
		details.setAddress(results.getString("address"));
		details.setAddress2(results.getString("address2"));
		details.setCity(results.getString("city"));
		details.setState(results.getString("state"));
		details.setZipCode(results.getString("zip_code"));
		details.setHasFood(results.getBoolean("has_food"));
		details.setDescription(results.getString("description"));
		details.setImgUrl(results.getString("img_url"));
		details.setWebsite(results.getString("website"));
		details.setPhoneNumber(results.getString("phone_number"));
		details.setSundayHours(results.getString("sunday_hours"));
		details.setMondayHours(results.getString("monday_hours"));
		details.setTuesdayHours(results.getString("tuesday_hours"));
		details.setWednesdayHours(results.getString("wednesday_hours"));
		details.setThursdayHours(results.getString("thursday_hours"));
		details.setFridayHours(results.getString("friday_hours"));
		details.setSaturdayHours(results.getString("saturday_hours"));
		details.setLat(results.getDouble("lat"));
		details.setLng(results.getDouble("lng"));
	
		return details;
	}

	@Override
	public void deleteBrewery(long breweryId) {
		jdbcTemplate.update("DELETE FROM breweries_users WHERE brewery_id = ?", breweryId);
		jdbcTemplate.update("DELETE FROM breweries_beers WHERE brewery_id = ?", breweryId);
		jdbcTemplate.update("DELETE FROM breweries WHERE brewery_id = ?", breweryId);
	}

	@Override
	public long saveBrewery(Brewery brewery) {
		String sqlSaveBrewery = "INSERT INTO breweries(name, password, address, address2, city, state, zip_code, has_food, description, website, phone_number, sunday_hours, monday_hours, tuesday_hours, wednesday_hours, thursday_hours, friday_hours, saturday_hours) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING brewery_id";
		Long breweryId = (long) jdbcTemplate.queryForObject(sqlSaveBrewery, Long.class, brewery.getName(), brewery.getPassword(), brewery.getAddress(), brewery.getAddress2(), brewery.getCity(), brewery.getState(), brewery.getZipCode(), brewery.isHasFood(), brewery.getDescription(), brewery.getWebsite(), brewery.getPhoneNumber(), brewery.getSundayHours(), brewery.getMondayHours(), brewery.getTuesdayHours(), brewery.getWednesdayHours(), brewery.getThursdayHours(), brewery.getFridayHours(), brewery.getSaturdayHours());

		return breweryId;

	}

	@Override
	public void updateBrewery(Brewery brewery) {
		jdbcTemplate.update("UPDATE breweries SET name=?, address=?, address2=?, city=?, state=?, zip_code=?, has_food=?, description=?, website=?, phone_number=?, sunday_hours=?, monday_hours=?, tuesday_hours=?, wednesday_hours=?, thursday_hours=?, friday_hours=?, saturday_hours=? WHERE brewery_id=?", brewery.getName(), brewery.getAddress(), brewery.getAddress2(), brewery.getCity(), brewery.getState(), brewery.getZipCode(), brewery.isHasFood(), brewery.getDescription(), brewery.getWebsite(), brewery.getPhoneNumber(), brewery.getSundayHours(), brewery.getMondayHours(), brewery.getTuesdayHours(), brewery.getWednesdayHours(), brewery.getThursdayHours(), brewery.getFridayHours(), brewery.getSaturdayHours(), brewery.getBreweryId());

	}
	
	@Override
    public void saveBeerToBrewery(long beerId, long breweryId) {
		String sqlSaveBeerToBrewery = "INSERT INTO breweries_beers(beer_id, brewery_id) VALUES(?, ?)";
		jdbcTemplate.update(sqlSaveBeerToBrewery, beerId, (int)breweryId);
    }

}
