package phamvanthanh.example.shopappwithspringboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import phamvanthanh.example.shopappwithspringboot.model.ShoppingCart;
import phamvanthanh.example.shopappwithspringboot.model.WishList;
import phamvanthanh.example.shopappwithspringboot.service.ProductService;
import phamvanthanh.example.shopappwithspringboot.service.ShoppingCartService;
import phamvanthanh.example.shopappwithspringboot.service.WishListService;


@ControllerAdvice
public class GeneralController {
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private ProductService productService;
	@Autowired
	private WishListService wishlistService;
	
	@ModelAttribute
	public void populateModel(Model model, HttpServletRequest request) {
		String sessionToken = (String) request.getSession(true).getAttribute("sessiontToken");
	  String sessionTokenwishList = (String) request.getSession(true).getAttribute("sessiontTokenWishList");
		if(sessionToken == null) {
			model.addAttribute("shoppingCart", new ShoppingCart());
			
		}
		else {
			model.addAttribute("shoppingCart", shoppingCartService.getShoppingCartBySessionTokent(sessionToken));
			
		}
		
		if(sessionTokenwishList == null) {
			model.addAttribute("whishList", new WishList());
			
		}
		else {
			model.addAttribute("whishList", wishlistService.getWishListBySessionTokent(sessionTokenwishList));
		}
		model.addAttribute("categories",productService.getAllCategories());
		
		model.addAttribute("brands",productService.getAllBrands());
		model.addAttribute("featured",productService.getProductWithBigestDiscount());
	}
	

}
