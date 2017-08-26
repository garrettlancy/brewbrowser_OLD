package com.techelevator.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.techelevator.Brewery;
import com.techelevator.model.dao.BeerDAO;
import com.techelevator.model.dao.BreweryDAO;
import com.techelevator.model.dao.UserDAO;

@Controller
@SessionAttributes({"email","username"})
public class BrewerController {

	@Autowired
	BreweryDAO breweryDao;
	@Autowired
	BeerDAO beerDao;
	@Autowired
	UserDAO userDao;

	@RequestMapping(path="/brewerHome", method=RequestMethod.GET)
	public String displayBrewerHome(Model modelHolder){
		List<Brewery> breweries = breweryDao.getBreweriesByBrewerEmail((String) modelHolder.asMap().get("email"));
		modelHolder.addAttribute("breweries", breweries);
		return "brewerHome";
	}

	@RequestMapping(path="/deleteBrewery", method=RequestMethod.POST)
	public String deleteBrewery(@RequestParam long breweryId,
			RedirectAttributes attr) {
		breweryDao.deleteBrewery(breweryId);
		attr.addFlashAttribute("message", "Brewery successfully deleted.");
		return "redirect:/brewerHome";
	}

	@RequestMapping(path="/breweryRegister", method=RequestMethod.GET)
	public String registerNewBrewery(Model modelHolder) {
		if(! modelHolder.containsAttribute("brewery")) {
			modelHolder.addAttribute("brewery", new Brewery());
		}
		return "breweryRegister";
	}

	@RequestMapping(path="/breweryRegister", method=RequestMethod.POST)
	public String registerNewBreweryValidation(Model modelHolder,
			@Valid @ModelAttribute("brewery") Brewery brewery, 
			BindingResult result,
			RedirectAttributes attr) {
		attr.addFlashAttribute("brewery", brewery);
		if((String) modelHolder.asMap().get("username") == null) {
			attr.addFlashAttribute("message", "Please log in first");
			return "redirect:/breweryRegister";
		}
		if(result.hasErrors()) {
			attr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "brewery", result);
			return "redirect:/breweryRegister";
		}
		if(breweryDao.getBrewery(brewery.getName()) != null) {
			attr.addFlashAttribute("message", "A Brewery with that name already exists. Please use a different name.");
			return "redirect:/breweryRegister";
		}

		long breweryId = breweryDao.saveBrewery(brewery);
		long userId = userDao.getUser((String) modelHolder.asMap().get("username")).getId();
		userDao.saveUserToBrewery(userId, breweryId);
		attr.addFlashAttribute("message", "You have successfully registered your brewery.");
		return "redirect:/brewerHome";
	}

	@RequestMapping(path="/breweryUpdate", method=RequestMethod.GET)
	public String updateBrewery(Model modelHolder, @RequestParam long breweryId) {
		if(!modelHolder.containsAttribute("brewery")) {
			modelHolder.addAttribute("brewery", breweryDao.getBreweryById(breweryId));

		}
		modelHolder.addAttribute("beers", beerDao.getAllBeersByBrewery(breweryId));
		return "breweryUpdate";
	}

	@RequestMapping(path="/breweryUpdate", method=RequestMethod.POST)
	public String updateBreweryValidation(Model modelHolder,
			@Valid @ModelAttribute("brewery") Brewery brewery, 
			BindingResult result,
			RedirectAttributes attr) {

		attr.addFlashAttribute("brewery", brewery);

		if((String) modelHolder.asMap().get("username") == null) {
			attr.addFlashAttribute("message", "Please log in first");
			return "redirect:/breweryUpdate?breweryId=" + brewery.getBreweryId();
		}

		if (!((String) modelHolder.asMap().get("email")).equals(userDao.checkBreweryPermissions(brewery.getBreweryId()))) {
			attr.addFlashAttribute("message", "You do not have access to edit this brewery.");
			return "redirect:/breweryUpdate?breweryId=" + brewery.getBreweryId();
		}

		if(result.hasErrors()) {

			attr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "brewery", result);
			return "redirect:/breweryUpdate?breweryId=" + brewery.getBreweryId();
		} 
		breweryDao.updateBrewery(brewery);
		attr.addFlashAttribute("message", "You have successfully updated your brewery.");
		return "redirect:/brewerHome";
	}

}
