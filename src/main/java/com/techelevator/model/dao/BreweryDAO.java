package com.techelevator.model.dao;

import java.util.List;

import com.techelevator.Brewery;

public interface BreweryDAO {
	
	public List<Brewery> getAllBreweryDetails();

	public Brewery getBreweryById(long breweryId);

	public List<Brewery> getBreweriesByBrewerEmail(String email);
	
	public void deleteBrewery(long breweryId);

	public Brewery getBrewery(String name);

	public long saveBrewery(Brewery brewery);

	public void updateBrewery(Brewery brewery);

	public void saveBeerToBrewery(long beerId, long breweryId);

	List<String> getAllBreweryMapsAddresses();

}
