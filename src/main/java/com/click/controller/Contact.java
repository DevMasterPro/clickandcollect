package com.click.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.service.Service_Contact;

@Controller
public class Contact {
	
	@Autowired
	Service_Contact contact;

	//getting Contact info from the contact page
	@RequestMapping(value = "/contact", method = RequestMethod.POST)
		public String SaveContactInfo(ModelMap model, @RequestParam String name, @RequestParam String email, @RequestParam String comments) {
			contact.SaveContactInfo(name,email,comments);
			model.put("succ", "Your query is successfully submitted.");
			return "contact";
	}
	//getting Contact info from the contact page
	@RequestMapping(value = "/logcontact", method = RequestMethod.POST)
		public String SaveContactInfoFromCutomer(ModelMap model, @RequestParam String name, @RequestParam String email, @RequestParam String comments) {
			contact.SaveContactInfo(name,email,comments);
			model.put("succ", "Your query is successfully submitted.");
			return "customer/contact";
		}
		//getting Contact info from the contact page
	@RequestMapping(value = "/selcontact", method = RequestMethod.POST)
		public String SaveContactInfoFromSeller(ModelMap model, @RequestParam String name, @RequestParam String email, @RequestParam String comments) {
			contact.SaveContactInfo(name,email,comments);
			model.put("succ", "Your query is successfully submitted.");
			return "seller/contact";
		}
	
}
