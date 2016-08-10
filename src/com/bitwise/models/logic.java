package com.bitwise.models;

import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

public class logic {

	@Autowired
	ServletContext sc;

	@Autowired
	HttpSession session;

	public int gettotal() {

		HashMap<String, Integer> shoppingbag = (HashMap<String, Integer>) session.getAttribute("shoppnbag");

		HashMap<String, Integer> prod = (HashMap<String, Integer>) sc.getAttribute("products");

		int total = 0;
		for (String string : shoppingbag.keySet()) {
			total += prod.get(string) * shoppingbag.get(string);
		}

		System.out.println(total);

		session.setAttribute("totalamount", total);
		return total;

	}

}
