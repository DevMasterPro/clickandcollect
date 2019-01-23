package com.click.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.click.service.ServiceProduct;
import com.click.service.ServiceShoppingCart;

@Controller
public class Product {
	@Autowired
	ServiceProduct product;
	@Autowired
	ServiceShoppingCart cart;
	
	
	//this method gets all the products for a specified store
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String ShowProductPage(ModelMap model,@PathVariable String id,HttpServletRequest request) {
		System.out.println(id);
		HttpSession session = request.getSession();
		//product id is actually store id it was written there accidently
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
		return "displayproduct";
	}

	//this method gets  the product details for a specified product
	@RequestMapping(value = "/productdetails/{id}", method = RequestMethod.GET)
	public String ShowProductDetailsPage(ModelMap model,@PathVariable String id,HttpServletRequest request) {
		
	

		model.put("productdetail", product.retrieveProductBasedOnID(id));
	
		
		return "productdetails";
	}
	
	
	//this method add the products to shopping cart
	@RequestMapping(value = "/shoppingcart", method = RequestMethod.POST)
	public String AddToShoppingCart(ModelMap model, @RequestParam String name,  @RequestParam String price, @RequestParam String quantity,@RequestParam String id,HttpServletRequest request ) {
			HttpSession session = request.getSession();
			String storeid = (String) session.getAttribute("productid");
			int priceConvertedToNumber = Integer.parseInt(price);
			int QuatityConvertedToNumber = Integer.parseInt(quantity);
			int total = priceConvertedToNumber * QuatityConvertedToNumber;
			String PriceinTotal = ""+total;
			cart.getToBasket(id, name, PriceinTotal, quantity, total,storeid);
			model.put("addedtoshopingcart","Product added to shopping Cart.");
			model.put("productdetail", product.retrieveProductBasedOnID(id));
			//session.removeAttribute("productid");
			
		return "productdetails";
	}
	
	
	//this method shows the item on the shopping basket
		@RequestMapping(value = "/basket", method = RequestMethod.GET)
		public String ShowBasket(ModelMap model,HttpServletRequest request ) {
			
			model.put("basketofproduct", cart.retrieveShoppingcart());
	
		
			 model.put("total", cart.getTotal());
			 HttpSession session = request.getSession();
			 session.setAttribute("checktotal", cart.getCount());
			 

			 
			return "basket";
		}

		
		
		//this method delete item from shopping cart
		@RequestMapping(value = "/deleteproduct/{id}", method = RequestMethod.GET)
		public String deleteItemFromShoppingCart(ModelMap model, @PathVariable String id,HttpServletRequest request ) {
			
			int value = cart.deleteShoppingItem(id);
	
			model.put("basketofproduct", cart.retrieveShoppingcart());
			
			model.put("total", cart.getTotal());
			 HttpSession session = request.getSession();
			 session.setAttribute("checktotal", cart.getCount());
		
			return "basket";
		}
		
		
		//this method delete item from shopping cart
		@RequestMapping(value = "/reserve", method = RequestMethod.GET)
		public String reserveItem(ModelMap model,HttpServletRequest request) {
			 HttpSession session = request.getSession();
			 
			 
			 
			 if(session.getAttribute("customerLogin") == null) {
				 
					
				 
				 return "customerlogin";
			 }
			 else {
				 
				model.put("confirm", cart.retrieveShoppingcart());
				model.put("total", cart.getTotal());
			
				 return "customer/confirmation";
			 }
		
				
		
		}
		
		//this method delete item from shopping cart
				@RequestMapping(value = "/order", method = RequestMethod.GET)
				public String submitOreder(ModelMap model,HttpServletRequest request ) {
					 HttpSession session = request.getSession();
					 String id = (String) session.getAttribute("customerId");
					 cart.submitorder(id);
					 String Orderid = cart.getOrderID(id);
					 cart.submitorderLine(Orderid,id);
					return "customer/thankyou";
				}
		
		
		
		
	

}
