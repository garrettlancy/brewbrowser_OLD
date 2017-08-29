package com.techelevator.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"email","username"})
public class HomeController {

	@RequestMapping("/")
	public String displayHomePage() {
		return "homePage";
	}
	
	@RequestMapping("/about")
	public String displayAboutPage() {
		return "about";
	}

}
