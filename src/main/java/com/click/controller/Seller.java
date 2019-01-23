package com.click.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.click.service.ServiceProduct;
import com.click.service.ServiceSellerViewOrder;
import com.click.service.ServiceStore;

@Controller
public class Seller {

	@Autowired
	ServiceStore store;
	@Autowired
	ServiceProduct product;
	@Autowired
	ServiceSellerViewOrder selord;

	//this bring homepage
	@RequestMapping(value = "/selindex", method = RequestMethod.GET)
	public String showHomePage(Model model) {

		return "seller/index";
	}
	
	
	//this method shows contact page
	@RequestMapping(value = "/selcontact", method = RequestMethod.GET)
	public String showContactPage(Model model) {
		return "seller/contact";
	}
	
	//this method shows about page
	@RequestMapping(value = "/selabout", method = RequestMethod.GET)
	public String showAboutPage(Model model) {
		return "seller/about";
	}
	
	//this method shows myaccount page
	@RequestMapping(value = "/selmyaccount", method = RequestMethod.GET)
	public String showaccountPage(Model model) {

		return "seller/myaccount";
	}
	
	//this method shows logout page
	@RequestMapping(value = "/selogout", method = RequestMethod.GET)
	public String showLogoutPage(Model model,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		session.removeAttribute("sellerLogin");
		session.removeAttribute("sellerId");
		session.removeAttribute("sellerName");
		return "logout";
	}
	
	//this bring store registration page
	@RequestMapping(value = "/store", method = RequestMethod.GET)
	public String showStoreRegistrationPage(ModelMap model,HttpServletRequest request) {
		
		return "seller/store";
	}
	
	//this method gets the product creation page
	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String showProductCreationPage(ModelMap model,HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		String sellerId = (String)  session.getAttribute("sellerId");
		
		store.clearData();
		store.getStore();
		model.put("store", store.retrieveStoreBasedOnID(sellerId));
		return "seller/product";
	}
	
	
	
	// this method receive the post request from the store register view
	@RequestMapping(value = "/store", method = RequestMethod.POST)
	public String ResgisterStore(ModelMap model, @RequestParam String sname, 
			@RequestParam String email, @RequestParam String phonenum,
			@RequestParam String Add1, @RequestParam String Add2, @RequestParam String city,
			@RequestParam String postcode,HttpServletRequest request) {
	
		HttpSession session = request.getSession();
			String sellerId = (String)  session.getAttribute("sellerId");
			System.out.println(sellerId);
			store.SaveCreateStore(sname, email,phonenum, Add1,Add2,city,postcode,sellerId);
			model.put("succ", "Store Successfully Created.");
	
		return "seller/store";
	}
	
	
	
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String CreateProduct(ModelMap model, @RequestParam String storeid, 
			@RequestParam String productname, @RequestParam String productinfo,
			@RequestParam String productdesc, @RequestParam String image, @RequestParam String cost) {
		
			product.createProduct(storeid,productname,productinfo,productdesc,image,cost);
			model.put("succ", "Product Successfully Created.");
	
		return "seller/product";
	}
	
	
	//this method shows myaccount page
	@RequestMapping(value = "/reservedorder", method = RequestMethod.GET)
	public String showReservedOrder(ModelMap model,HttpServletRequest request) {

		HttpSession session = request.getSession();
		String sellerId = (String)  session.getAttribute("sellerId");
		System.out.println(sellerId);
		selord.clearData();
		selord.getSellerOrders(sellerId);
		model.put("sellorder", selord.retrieveSellerOrder());
		return "seller/reservedorder";
	}
	
	//this method updates the product status
	@RequestMapping(value = "/collected/{id}", method = RequestMethod.GET)
	public String updateProductStatus(ModelMap model,@PathVariable String id,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String sellerId = (String)  session.getAttribute("sellerId");
		selord.updateorderLine(id);
		selord.clearData();
		selord.getSellerOrders(sellerId);
		model.put("sellorder", selord.retrieveSellerOrder());
		model.put("Succ", "Successfully updated status.");
		return "seller/reservedorder";
	}
	
	
}
