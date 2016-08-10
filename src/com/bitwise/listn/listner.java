package com.bitwise.listn;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class listner
 *
 */
@WebListener
public class listner implements ServletContextListener, ServletContextAttributeListener {

	/**
	 * Default constructor.
	 */
	public listner() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void attributeAdded(ServletContextAttributeEvent arg0) {

		HashMap<String, Integer> prod = new HashMap<String, Integer>();
		ServletContext sc = arg0.getServletContext();

		prod.put("Bag", 25);
		prod.put("belt", 125);
		prod.put("pen", 250);
		prod.put("shirt", 2);

		sc.setAttribute("products", prod);

	}

	public void attributeReplaced(ServletContextAttributeEvent arg0) {

	}

	public void attributeRemoved(ServletContextAttributeEvent arg0) {

	}

	public void contextDestroyed(ServletContextEvent arg0) {

	}

}
