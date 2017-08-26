package com.techelevator.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.techelevator.Beer;
import com.techelevator.Review;
import com.techelevator.model.dao.BeerDAO;
import com.techelevator.model.dao.BreweryDAO;
import com.techelevator.model.dao.ReviewDAO;
import com.techelevator.model.dao.UserDAO;


@Controller
@SessionAttributes({"email","username"})

public class BeerController {

	@Autowired
	BeerDAO beerDao;
	@Autowired
	BreweryDAO breweryDao;
	@Autowired
	ReviewDAO reviewDao;
	@Autowired
	UserDAO userDao;

	@RequestMapping(path = {"/beerDetails"}, method = RequestMethod.GET)
	public String displayBeerDetailsPage(Model modelHolder, @RequestParam long beerId){
		modelHolder.addAttribute("beer", beerDao.getBeerById(beerId));
		modelHolder.addAttribute("reviews", reviewDao.getReviewsByBeerId(beerId));
		modelHolder.addAttribute("review", new Review());
		return "beerDetails";
	}


	@RequestMapping(path="/addBeer", method=RequestMethod.GET)
	public String registerNewBrewery(Model modelHolder, @RequestParam long breweryId) {
		if(! modelHolder.containsAttribute("beer")) {
			modelHolder.addAttribute("beer", new Beer());
			modelHolder.addAttribute("breweryId", breweryId);
		}
		return "addBeer";
	}

	@RequestMapping(path="/updateBeer", method=RequestMethod.GET)
	public String showUpdateBeerPage(Model modelHolder, @RequestParam long beerId, @RequestParam long breweryId) {
		modelHolder.addAttribute("beer", beerDao.getBeerById(beerId));
		modelHolder.addAttribute("breweryId", breweryId);
		return "updateBeer";
	}
	@RequestMapping(path="/updateBeer", method=RequestMethod.POST)
	public String updateBeer(Model modelHolder, @ModelAttribute("beer") Beer beer) {
		modelHolder.addAttribute("beer", beerDao.updateBeer(beer));
		return "redirect:/breweryUpdate?breweryId="+beerDao.getBreweryIdByBeerId(beer.getBeerId());
	}
	@RequestMapping(path="/deleteBeer", method=RequestMethod.POST)
	public String deleteBeer(Model modelHolder, @RequestParam long beerId, @RequestParam long breweryId, RedirectAttributes attr) {
		beerDao.deleteBeer(beerId);
		attr.addFlashAttribute("message", "Beer has been been successfully removed.");
		return "redirect:/breweryUpdate?breweryId="+breweryId;
	}

	@RequestMapping(path="/addBeer", method=RequestMethod.POST)
	public String registerNewBreweryValidation(Model modelHolder, @RequestParam long breweryId,
			@Valid @ModelAttribute("beer") Beer beer, 
			BindingResult result,
			RedirectAttributes attr) {
		attr.addFlashAttribute("beer", beer);
		attr.addFlashAttribute("breweryId", breweryId);
		if(result.hasErrors()) {
			attr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "beer", result);
			return "redirect:/addBeer";
		}
		long beerId = beerDao.saveBeer(beer);
		breweryDao.saveBeerToBrewery(beerId, breweryId);
		attr.addFlashAttribute("message", "You have successfully added a new beer.");
		return "redirect:/brewerHome";
	}

	@RequestMapping(path="/review", method=RequestMethod.GET)
	public String displayReviewPage(Model modelHolder, @ModelAttribute Beer beer) {

		if(! modelHolder.containsAttribute("review")) {
			modelHolder.addAttribute("review", new Review());
			modelHolder.addAttribute("beer", beer);
			System.out.print(beer.getBeerId());
		}
		return "review";
	}

	@RequestMapping(path="/review", method=RequestMethod.POST)
	public String registerNewBreweryValidation(Model modelHolder, @RequestParam long beerId,
			@Valid @ModelAttribute("review") Review review, 
			BindingResult result,
			RedirectAttributes attr,
			HttpSession session) {
		attr.addFlashAttribute("review", review);
		if(session.getAttribute("username")== null) {
			attr.addFlashAttribute("message", "Please log in first.");
			modelHolder.addAttribute("email");
			return "redirect:/login";
		}		
		if(result.hasErrors()) {
			attr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "review", result);
			return "redirect:/beerDetails?beerId="+beerId;
		}
		if(review.getRating() == 0) {
			attr.addFlashAttribute("message", "Please select a rating.");
			return "redirect:/beerDetails?beerId="+beerId;
		}
		String username = (String)session.getAttribute("username");
		long userId =  userDao.getUser(username).getId();
		
		reviewDao.postReview(review, userId, username);
		attr.addFlashAttribute("beer", beerDao.getBeerById(beerId));
		attr.addFlashAttribute("message", "You have successfully submitted your review.");
		return "redirect:/beerDetails?beerId="+beerId;
	}	

}
