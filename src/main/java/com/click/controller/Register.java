package com.click.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.service.ServiceLogin;
import com.click.service.ServiceRegister;

@Controller
public class Register {

	@Autowired
	ServiceRegister reg;
	@Autowired
	ServiceLogin log;

	// this method receive the post request from the User register view
	@RequestMapping(value = "/userregister", method = RequestMethod.POST)
	public String ResgisterUser(ModelMap model, @RequestParam String fname, @RequestParam String sname,
			@RequestParam String email, @RequestParam String pass, @RequestParam String phonenum,
			@RequestParam String Add1, @RequestParam String Add2, @RequestParam String City,
			@RequestParam String postcode) {
		String table ="customer";
		if (log.getEmail(email,table) > 0) {
			model.put("emailexists", "An user with this email exists in the system.");
		} else {
			reg.SaveUserRegister(fname, sname, email, phonenum, Add1, Add2, City, postcode);
			String Userid = log.getUserId(email,table);
			String type = "customer";
			log.SaveLogin(Userid, pass, type);
			model.put("succ", "User Successfully Created.");
		}
		return "userregister";
	}
	

	
	// this method receive the post request from the seller register view
		@RequestMapping(value = "/storeregister", method = RequestMethod.POST)
		public String ResgisterSeller(ModelMap model, @RequestParam String fname, @RequestParam String sname,
				@RequestParam String email, @RequestParam String pass, @RequestParam String phonenum,
				@RequestParam String Add1, @RequestParam String Add2, @RequestParam String City,
				@RequestParam String postcode) {
			String table ="Seller";
			if (log.getEmail(email,table) > 0) {
				model.put("emailexists", "An user with this email exists in the system.");
			} else {
				reg.SaveSellerRegister(fname, sname, email, phonenum, Add1, Add2, City, postcode);
				String Userid = log.getUserId(email,table);
				String type = "seller";
				log.SaveLogin(Userid, pass, type);
				model.put("succ", "User Successfully Created.");
			}
			return "storeregister";
		}
	
	
	
	
	
	
	
	
	
	

}
