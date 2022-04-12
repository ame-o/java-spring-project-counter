package com.example.demo.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/your_server")
public class CounterControllers {
	@RequestMapping("")
	public String index(HttpSession session) {

		// If the count is not already in session
		if (session.getAttribute("count") == null) {
			// Use setAttribute to initialize the count in session
			session.setAttribute("count", 0);
			return "yourserver.jsp";
		} else {
			Integer currentCount = (Integer) session.getAttribute("count");
			currentCount++;
			session.setAttribute("count",currentCount);
			return "yourserver.jsp";
			// increment the count by 1 using getAttribute and setAttribute
		}
	}

	@RequestMapping("/counter")
	public String showCount(HttpSession session) {
		return "showcount.jsp";
	}
	

}
