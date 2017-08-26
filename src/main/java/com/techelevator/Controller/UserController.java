package com.techelevator.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.techelevator.User;
import com.techelevator.model.dao.BreweryDAO;
import com.techelevator.model.dao.UserDAO;

@Controller
@SessionAttributes({"email","username"})
public class UserController {

	@Autowired
	UserDAO userDao;

	@Autowired
	BreweryDAO breweryDao;

	@RequestMapping(path="/register", method=RequestMethod.GET)
	public String inputNewUser(Model modelHolder) {
		if(! modelHolder.containsAttribute("user")) {
			modelHolder.addAttribute("user", new User());
		}
		return "register";
	}

	@RequestMapping(path="/register", method=RequestMethod.POST)
	public String registerNewUser(Model modelHolder,
			@Valid @ModelAttribute("user") User user, 
			BindingResult result,
			RedirectAttributes attr) {
		attr.addFlashAttribute("user", user);
		if(result.hasErrors()) {
			attr.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "user", result);
			return "redirect:/register";
		}
		if(userDao.getUserByEmail(user.getEmail()) != null) {
			attr.addFlashAttribute("message", "An account with that email address already exists. Please use a different email.");
			return "redirect:/register";
		} else if (userDao.getUser(user.getUsername()) != null) {
			attr.addFlashAttribute("message", "That username is already being used. Please select a different username.");
			return "redirect:/register";
		}

		userDao.saveUser(user);
		attr.addFlashAttribute("message", "You have successfully registered your account. Please log in to confirm.");
		return "redirect:/login";
	}

	@RequestMapping(path={"/login"}, method=RequestMethod.GET)
	public String inputLogin() {
		return "login";
	}

	@RequestMapping(path="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam String username, @RequestParam String password, ModelMap model,
			RedirectAttributes attr, HttpSession session) {            
		User user = userDao.getUser(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				model.addAttribute("username", user.getUsername());
				model.addAttribute("email", user.getEmail());
				session.setAttribute("username", user.getUsername());
				session.setAttribute("email", user.getEmail());

				return "redirect:/";
			}
		}
		attr.addFlashAttribute("message", "Your username or password is incorrect.");
		return "redirect:/login";
	}

	@RequestMapping(path="/logout")
	public String logout(HttpSession session, ModelMap model) {
		session.invalidate();
		model.remove("email");
		model.remove("username");
		return "redirect:/";
	}
	
	

}
