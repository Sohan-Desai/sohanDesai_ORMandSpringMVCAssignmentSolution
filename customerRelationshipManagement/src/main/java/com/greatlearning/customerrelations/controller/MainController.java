package com.greatlearning.customerrelations.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	/*
	 * this page gets loaded when our application is booted
	 * url: "/customerRelationshipManagement/"
	 * returns viewname "main-page"
	 */
	@RequestMapping("/")
	public String showMainPage() {
		
		return "main-page";
	}
}
