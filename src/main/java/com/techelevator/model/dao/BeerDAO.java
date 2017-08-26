package com.techelevator.model.dao;

import java.util.List;

import com.techelevator.Beer;

public interface BeerDAO {

	public List<Beer> getAllBeers();
	public List<Beer> getAllBeersByBrewery(long breweryId);
	public List<Beer> getAllBeersByType(long typeId);
	public Beer getBeerById(long beerId);
	public long saveBeer(Beer beer);
	public void deleteBeer(long beerId);
	public long getBreweryIdByBeerId(long beerId);
	public long updateBeer(Beer beer);


}
