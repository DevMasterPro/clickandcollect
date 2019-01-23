package com.click.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.service.ServiceStore;

@Controller
public class Public_Controller {

	@Autowired
	ServiceStore store;
	
	//this bring homepage
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {

		store.clearData();
		store.getStore();
		model.put("allStore", store.retrieveStore());
		return "index";
	}
	
	//this method also bring homepage
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePageWithForwardSlash(ModelMap model) {
		
		store.clearData();
		store.getStore();
		model.put("allStore", store.retrieveStore());
		
		return "index";
	}

	//this controller search for product based on user input
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String showSearchResult(ModelMap model,@RequestParam String value) {
		
		if (store.getStoreCount(value) > 0) {
			store.clearData();
			store.getStoreforPostcode(value);
			model.put("allStore", store.retrieveStore());
		}
		else {
			
			model.put("nostorefound", "No match found for your search, please try again.");
		}
		
		return "index";
	}
	
	
	
	
	
	
	
	//this method shows login page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage(Model model) {

		return "login";
	}
	
	
	
	
	//this method shows user register page
	@RequestMapping(value = "/userregister", method = RequestMethod.GET)
	public String showUserRegister(Model model) {

		return "userregister";
	}
	
	//this method shows store register page
	@RequestMapping(value = "/userseller", method = RequestMethod.GET)
	public String showStoreRegisterPage(Model model) {

		return "storeregister";
	}
	
	
	//this method shows contact page
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String showContactPage(Model model) {

		
		return "contact";
	}
	
	
	
	
	//this method shows contact page
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String showAboutPage(Model model) {

		
		return "about";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
