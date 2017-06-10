package com.apo.controller;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

import com.apo.AdminMethods;
import com.apo.AdminMethodsImpl;
import com.apo.model.Admin;
@Controller
public class AdminController {

	private AdminMethods adminMethod = new AdminMethodsImpl();

	@RequestMapping(value = "/sign_in", method = RequestMethod.GET)
	public String admin() {
		return "forms/loginform";
	}

	@RequestMapping(value = "/sign_in", method = RequestMethod.POST)
	public String logAdmin(@RequestParam String userName, @RequestParam String password,HttpSession session) throws NoSuchAlgorithmException {
		Admin isAdmin = adminMethod.authenticate(userName,password);
		if (isAdmin ==null)
		{	
			String error = "username or password is incorrect! <br> Click <a href=\"/sign_in\">here</a> to try again.";
			return "redirect:/sign_in";
		}


		else 
		{
			session.setAttribute("loggedInUser", isAdmin);
			return "redirect:/";
		} 

	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String addAdmin() {
		return "forms/add";
	}

	@RequestMapping(value = "/added", method = RequestMethod.POST)
	public String newAdmin(@RequestParam String userName, @RequestParam String password) throws NoSuchAlgorithmException {
		boolean Admin = false;

		Admin = adminMethod.addUser(userName,password);

		if (Admin == true)
		{return "redirect:index";} 
		else 
		{return "redirect:add";}

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpSession session) {
		session.removeAttribute("loggedInUser");

		return "redirect:index"; 

	}


}
