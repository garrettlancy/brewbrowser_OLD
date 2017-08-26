package com.techelevator.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.model.dao.BeerDAO;
import com.techelevator.model.dao.BreweryDAO;

@Controller
@SessionAttributes({"email","username"})
public class BreweryController {

	@Autowired
	BreweryDAO breweryDao;
	@Autowired
	BeerDAO beerDao;

	@RequestMapping(path = {"/breweryDetails"}, method = RequestMethod.GET)
	public String displayBreweryDetailsPage(Model modelHolder, @RequestParam long breweryId) {
		modelHolder.addAttribute("brewery", breweryDao.getBreweryById(breweryId));
		modelHolder.addAttribute("beers", beerDao.getAllBeersByBrewery(breweryId));
		return "breweryDetails";
	}

	@RequestMapping(path = {"/breweryList"}, method = RequestMethod.GET)
	public String displayBreweryList(Model modelHolder) {
		modelHolder.addAttribute("breweries", breweryDao.getAllBreweryDetails());
		return "breweryList";
	}
	
	@RequestMapping(path = {"/breweryListJSON"}, method = RequestMethod.GET)
	@ResponseBody
	public List displayBreweryListJSON(Model modelHolder) { 
		return breweryDao.getAllBreweryDetails();
	}
	
//	@RequestMapping(path = {"/breweryListJSON"}, method = RequestMethod.GET)
//	@ResponseBody
//	public List displayBreweryMapsAddressesJSON(Model modelHolder) { 
//		return breweryDao.getAllBreweryMapsAddresses();
//	}

}
