package com.click.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.service.ServiceLogin;
import com.click.service.ServiceRegister;

@Controller
public class Admin {
	@Autowired
	ServiceRegister reg;
	@Autowired
	ServiceLogin log;
	//this bring homepage
	@RequestMapping(value = "/adindex", method = RequestMethod.GET)
	public String showHomePage(Model model) {

		return "admin/index";
	}
	
	
	//this method shows contact page
	@RequestMapping(value = "/adcontact", method = RequestMethod.GET)
	public String showContactPage(Model model) {

		
		return "admin/contact";
	}
	

	
	//this method shows about page
	@RequestMapping(value = "/adabout", method = RequestMethod.GET)
	public String showAboutPage(Model model) {

		return "admin/about";
	}
	
	
	
	//this method shows myaccount page
	@RequestMapping(value = "/admyaccount", method = RequestMethod.GET)
	public String showaccountPage(Model model) {

		return "admin/myaccount";
	}
	
	
	
	
	
	//this method shows logout page
	@RequestMapping(value = "/adlogout", method = RequestMethod.GET)
	public String showLogoutPage(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("AdminLogin");
		session.removeAttribute("AdminId");
		session.removeAttribute("AdminName");
		return "logout";
	}
	
	
	//this brins admin customer register page
		@RequestMapping(value = "/admincustomer", method = RequestMethod.GET)
		public String showAdminCustomerREgisterPage(ModelMap model) {

			return "admin/admincustomer";
		}
		
		
		//this method shows admin seller page
		@RequestMapping(value = "/adminseller", method = RequestMethod.GET)
		public String showSellerRegistrationPage(ModelMap model) {
			
			
			return "admin/adminseller";
		}
		
		

		// this method receive the post request from the User register view
		@RequestMapping(value = "/aduserregister", method = RequestMethod.POST)
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
			return "admin/admincustomer";
		}
		
	
		
		
		// this method receive the post request from the seller register view
		@RequestMapping(value = "/adsellerregister", method = RequestMethod.POST)
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
			return "admin/adminseller";
		}
	
	
	
	
	
	
}
