package com.bitwise.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.validator.CartValidator;
import com.bitwise.validator.DetailsValidator;
import com.bitwise.validator.LoginUserValidator;
import com.bitwise.validator.productsValidator;

@Controller
public class LoginController {

	List<String> cartprd = new ArrayList<String>();
	HashMap<String, Integer> shoppingbag = new HashMap<String, Integer>();

	@RequestMapping(value = "/Login")
	public String redirectToLogin(Model model) {
		model.addAttribute("LoginUser", new LoginUser());
		return "Login";
	}

	@RequestMapping(value = "/logout")
	public String redirectToLogout(Model model) {
		model.addAttribute("LoginUser", new LoginUser());
		return "Logout";
	}

	@RequestMapping(value = "/product")
	public String redirectToproduct(Model model) {
		model.addAttribute("Products", new Products());
		return "Product";
	}

	@Autowired
	logic lc;

	@RequestMapping(value = "/Placeorder")
	public String redirectToplaceorder(Model model) {

		System.out.println(lc.gettotal());

		model.addAttribute("PlaceOder", new PlaceOrder());
		return "PlaceOrder";
	}

	@Autowired
	LoginUserValidator loginUserValidator;

	@InitBinder("LoginUser")
	public void setValidatorLogin(WebDataBinder binder) {
		binder.setValidator(loginUserValidator);
	}

	@RequestMapping(value = "/auth.login", method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("LoginUser") @Validated LoginUser loginUser, BindingResult result,
			HttpSession session, Model model) {

		if (result.hasErrors())
			return "Login";

		session.setAttribute("username", loginUser.getUserName());
		model.addAttribute("Products", new Products());
		return "Product";
	}

	@Autowired
	productsValidator ProductsValidator;

	@InitBinder("Products")
	public void setValidatorproducts(WebDataBinder binder) {
		binder.setValidator(ProductsValidator);
	}

	@RequestMapping(value = "/show.detail", method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("Products") @Validated Products products, BindingResult result,
			HttpSession session, Model model) {

		if (result.hasErrors())
			return "Product";

		session.setAttribute("selectedProducts", products.getAllproducts());
		model.addAttribute("Details", new Details());
		return "detail";
	}

	@Autowired
	DetailsValidator detailsValidator;

	@InitBinder("Details")
	public void setValidatorproductsdetail(WebDataBinder binder) {
		binder.setValidator(detailsValidator);
	}

	@RequestMapping(value = "/addcart", method = RequestMethod.POST)
	public String checkCart(@ModelAttribute("Details") @Validated Details details, BindingResult result,
			HttpSession session, Model model) {

		if (result.hasErrors())
			return "detail";

		if (session.getAttribute("shoppnbag") == null) {
			for (String string : details.getAddtocartproducts()) {
				shoppingbag.put(string, Collections.frequency(details.getAddtocartproducts(), string));
			}
		} else {

			for (String string : details.getAddtocartproducts()) {
				if (shoppingbag.containsKey(string)) {
					int count = shoppingbag.get(string) + 1;
					shoppingbag.put(string, count);

				} else
					shoppingbag.put(string, Collections.frequency(details.getAddtocartproducts(), string));
			}
		}
		session.setAttribute("shoppnbag", shoppingbag);
		model.addAttribute("Cart", new Cart());
		return "AddToCart";

	}

	@Autowired
	CartValidator cartValidator;

	@InitBinder("Cart")
	public void setValidatorcartdel(WebDataBinder binder) {
		binder.setValidator(cartValidator);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/delcart", method = RequestMethod.POST)
	public String checkCartfordelete(@ModelAttribute("Cart") @Validated Cart cart, BindingResult result,
			HttpSession session, Model model) {

		if (result.hasErrors())
			return "AddToCart";

		cartprd = (List<String>) session.getAttribute("addToCartProducts");

		shoppingbag = (HashMap<String, Integer>) session.getAttribute("shoppnbag");
		for (String string : cart.getDELtocartproducts()) {
			if (shoppingbag.containsKey(string)) {
				if (shoppingbag.get(string) > 1) {
					int count = shoppingbag.get(string) - 1;
					shoppingbag.put(string, count);

				} else
					shoppingbag.remove(string);
			}
		}

		session.setAttribute("shoppnbag", shoppingbag);
		model.addAttribute("Cart", new Cart());
		return "AddToCart";
	}

}
