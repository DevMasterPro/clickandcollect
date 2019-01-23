package com.click.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.click.service.ServiceLogin;
import com.click.service.ServiceOrder;
import com.click.service.ServiceOrderLines;
import com.click.service.ServiceProduct;
import com.click.service.ServiceShoppingCart;
import com.click.service.ServiceStore;

@Controller
public class Customer {

	@Autowired
	ServiceStore store;
	@Autowired
	ServiceProduct product;
	@Autowired
	ServiceShoppingCart cart;
	@Autowired
	ServiceLogin log;
	
	@Autowired
	ServiceOrder ord;
	
	@Autowired
	ServiceOrderLines oline;
	
	
	
	public int totalall =0;
	//this bring homepage
	
	
	@RequestMapping(value = "/logindex", method = RequestMethod.GET)
	public String showHomePage(ModelMap model) {
		store.clearData();
		store.getStore();
		model.put("allStore", store.retrieveStore());
		return "customer/index";
	}
	
	
	//this controller search for product based on user input
	@RequestMapping(value = "/logsearch", method = RequestMethod.POST)
	public String cusshowSearchResult(ModelMap model,@RequestParam String value) {
		
		if (store.getStoreCount(value) > 0) {
			store.clearData();
			store.getStoreforPostcode(value);
			model.put("allStore", store.retrieveStore());
		}
		else {
			
			model.put("nostorefound", "No match found for your search, please try again.");
		}
		
		return "customer/index";
	}
	
	
	
	//this method shows contact page
	@RequestMapping(value = "/logcontact", method = RequestMethod.GET)
	public String showContactPage(Model model) {

		
		return "customer/contact";
	}
	

	
	//this method shows about page
	@RequestMapping(value = "/logabout", method = RequestMethod.GET)
	public String showAboutPage(Model model) {
		
		return "customer/about";
	}
	
	
	
	//this method shows myaccount page
	@RequestMapping(value = "/myaccount", method = RequestMethod.GET)
	public String showaccountPage(Model model) {

		return "customer/myaccount";
	}
	
	
	
	
	
	//this method shows logout page
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String showLogoutPage(Model model,HttpServletRequest request ) {

		HttpSession session = request.getSession();
	
		session.removeAttribute("customerLogin");
		session.removeAttribute("customerId");
		session.removeAttribute("customerName");
		return "logout";
	}
	
	//this method gets all the products for a specified store
	@RequestMapping(value = "/logproduct/{id}", method = RequestMethod.GET)
	public String ShowProductPage(ModelMap model,@PathVariable String id,HttpServletRequest request) {
		System.out.println(id);
		HttpSession session = request.getSession();
		session.setAttribute("productid", id);
		if(product.getProductCountBasedOnID(id) > 0) {
		product.clearData();
		product.getProductBasedOnStoreID(id);
		String name = product.getStorename(id);
		model.put("storename", name);
		model.put("allproduct", product.retrieveProduct());
		}
		else {
			model.put("noproductfound","No Product found for this store.");
		}
		return "customer/displayproduct";
	}

	//this method gets  the product details for a specified product
	@RequestMapping(value = "/logproductdetails/{id}", method = RequestMethod.GET)
	public String ShowProductDetailsPage(ModelMap model,@PathVariable String id,HttpServletRequest request) {
		
	

		model.put("productdetail", product.retrieveProductBasedOnID(id));
		return "customer/productdetails";
	}
	
	
	//this method add the products to shopping cart
	@RequestMapping(value = "/logshoppingcart", method = RequestMethod.POST)
	public String AddToShoppingCart(ModelMap model, @RequestParam String name,  @RequestParam String price, 
			@RequestParam String quantity,@RequestParam String id,HttpServletRequest request ) {
			System.out.println(id);
			HttpSession session = request.getSession();
			String storeid = (String) session.getAttribute("productid");
			int priceConvertedToNumber = Integer.parseInt(price);
			int QuatityConvertedToNumber = Integer.parseInt(quantity);
			int total = priceConvertedToNumber * QuatityConvertedToNumber;
			String PriceinTotal = ""+total;
			totalall = totalall + total;
			cart.getToBasket(id, name, PriceinTotal, quantity, total,storeid);
			model.put("addedtoshopingcart","Product added to shopping Cart.");
			model.put("productdetail", product.retrieveProductBasedOnID(id));
			
			session.removeAttribute("productid");
		return "customer/productdetails";
	}
	
	//this method shows the item on the shopping basket
		@RequestMapping(value = "/logbasket", method = RequestMethod.GET)
		public String ShowBasket(ModelMap model,HttpServletRequest request) {
			
			model.put("basketofproduct", cart.retrieveShoppingcart());
			model.put("total", totalall);
			HttpSession session = request.getSession();
			session.setAttribute("checktotal", cart.getCount());
	
			return "customer/basket";
		}


		
		//this method delete item from shopping cart
		@RequestMapping(value = "/logdeleteproduct/{id}", method = RequestMethod.GET)
		public String deleteItemFromShoppingCart(ModelMap model, @PathVariable String id,HttpServletRequest request  ) {
			
			int value = cart.deleteShoppingItem(id);
			totalall = totalall - value;
			model.put("basketofproduct", cart.retrieveShoppingcart());
			model.put("total", totalall);
			HttpSession session = request.getSession();
			session.setAttribute("checktotal", cart.getCount());
			
			return "customer/basket";
		}
		
		
		//this method redirect the user to login page if they are not logged in when they click reserve
		@RequestMapping(value = "/logreserve", method = RequestMethod.GET)
		public String reserveItem(ModelMap model,HttpServletRequest request) {
			
			 return "customerlogin";
		}
	
	
		@RequestMapping(value = "/reservelogin", method = RequestMethod.POST)
		public ModelAndView confirmationpage(ModelMap model, @RequestParam String email, @RequestParam String pass,
				HttpServletRequest request) {

					
							
							String table ="customer";
							
								if(log.EmailExists(email,table) > 0) {
										String Userid = log.getUserId(email,table);
										String type ="customer";
										int num = log.Login(Userid, pass,type);
											if(num >0) {
												HttpSession session = request.getSession();
												session.setAttribute("customerLogin", "true");
												session.setAttribute("customerId", Userid);
												String customerName = log.getName(email,table);
												session.setAttribute("customerName", customerName);
												System.out.println(session.getAttribute("customerLogin"));
												System.out.println(session.getAttribute("customerId"));
												System.out.println(session.getAttribute("customerName"));
												
												return new ModelAndView ("redirect:/reserve");
											}
											else {
												model.put("errorLogin", "Invalid credentails for customer.");
												return new ModelAndView ("customerlogin");
											}
								}
								else {
									model.put("errorLogin", "Invalid credentails for customer");
									return new ModelAndView ("customerlogin");
								}
						
						
		}
		
		
		
		
		//this method shows gets all the user order 
		@RequestMapping(value = "/myorder", method = RequestMethod.GET)
		public String getmyOrder(ModelMap model,HttpServletRequest request) {
			HttpSession session = request.getSession();
			String cusId = (String) session.getAttribute("customerId");
			ord.clearData();
			String column = "customerid";
			ord.getOrder(column,cusId);
			model.put("orders", ord.retrieveOrder());
			oline.clearData();
			oline.cleardesc();
			
			return "customer/myorder";
		}
		
		
		
		//this method shows gets all the  order item based on a order id
				@RequestMapping(value = "/vieworder/{id}", method = RequestMethod.GET)
				public String getmyOrderLines(ModelMap model, @PathVariable String id ) {
				
					//oline.DeleteOrderItem();
					oline.cleardesc();
					oline.clearData();
					System.out.println("Step one");
					oline.getOrderLines(id);
					System.out.println("Step two");
					oline.retrieveSingleOrderLine();
					System.out.println("Step three");
					model.put("orderline", oline.retrieveOrderItem());
					System.out.println("Step four");
					return "customer/vieworder";
				}
				
		
		
		
			
	
}
