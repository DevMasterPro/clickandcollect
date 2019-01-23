package com.click.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.click.service.ServiceLogin;

@Controller
public class Login {
	
	@Autowired
	ServiceLogin log;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView showWelcomePage(ModelMap model, @RequestParam String email, @RequestParam String pass, @RequestParam String type,
			HttpServletRequest request) {

					if (type.contains("customer")) {
						
						String table ="customer";
						
							if(log.EmailExists(email,table) > 0) {
									String Userid = log.getUserId(email,table);
									int num = log.Login(Userid, pass,type);
										if(num >0) {
											HttpSession session = request.getSession();
											session.setAttribute("customerLogin", "true");
											session.setAttribute("customerId", Userid);
											String customerName = log.getName(email,table);
											session.setAttribute("customerName",customerName );
											System.out.println(session.getAttribute("customerLogin"));
											System.out.println(session.getAttribute("customerId"));
											System.out.println(session.getAttribute("customerName"));
											
											return new ModelAndView ("redirect:/logindex");
										}
										else {
											model.put("errorLogin", "Invalid credentails for customer.");
											return new ModelAndView ("login");
										}
							}
							else {
								model.put("errorLogin", "Invalid credentails for customer");
								return new ModelAndView ("login");
							}
						
						
					}
					if (type.contains("seller")) {
						String table ="seller";
						
						if(log.EmailExists(email,table) > 0) {
								String Userid = log.getUserId(email,table);
								int num = log.Login(Userid, pass,type);
									if(num >0) {
										HttpSession session = request.getSession();
										session.setAttribute("sellerLogin", "true");
										session.setAttribute("sellerId", Userid);
										String customerName = log.getName(email,table);
										session.setAttribute("sellerName", customerName);
										return new ModelAndView ("redirect:/selindex");
										
									}
									else {
										model.put("errorLogin", "Invalid credentails for Seller.");
										return new ModelAndView("login");
									}
						}
						else {
							model.put("errorLogin", "Invalid credentails for Seller");
							return new ModelAndView("login");
						}
					
						
					}
					if (type.contains("admin")) {
						String table ="Admin";
						
						if(log.EmailExists(email,table) > 0) {
							System.out.println("Step1");
								String Userid = log.getUserId(email,table);
								int num = log.Login(Userid, pass,type);
									if(num >0) {
										System.out.println("Step2");
										HttpSession session = request.getSession();
										session.setAttribute("AdminLogin", "true");
										session.setAttribute("AdminId", Userid);
										String customerName = log.getName(email,table);
										session.setAttribute("AdminName", customerName);
										return new ModelAndView ("redirect:/adindex");
									}
									else {
										model.put("errorLogin", "Invalid credentails for Admin.");
									
										System.out.println("Step3");
										return new ModelAndView("login");
									}
						}
						else {
							model.put("errorLogin", "Invalid credentails for Admin");
							System.out.println("Step4");
							return new ModelAndView("login");
						}
					
						
					}
					return new ModelAndView("login");
		
	
	}
	
	
	
	
	
	
	
	
	
	

}
