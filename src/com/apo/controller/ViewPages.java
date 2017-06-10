package com.apo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apo.TextMethods;
import com.apo.TextMethodsImpl;
import com.apo.model.Text;
@Controller
public class ViewPages {
	private TextMethods textMethods = new TextMethodsImpl();
	
	@RequestMapping(value= {"/index","/"}, method = RequestMethod.GET)
	public String index(Model model) {
		String text = textMethods.retrieveText("index").getText();
		model.addAttribute("text", text);
		return "index";
	}
	
	
	@RequestMapping(value="/education", method = RequestMethod.GET)
	public String education(Model model) {
		String text = textMethods.retrieveText("education").getText();
		model.addAttribute("text", text);
		return "education";
	}
	
	@RequestMapping(value="/interests", method = RequestMethod.GET)
	public String interests(Model model) {
		String text = textMethods.retrieveText("interests").getText();
		model.addAttribute("text", text);
		return "interests";
	}
	
	@RequestMapping(value="/experience", method = RequestMethod.GET)
	public String experience(Model model) {
		String text = textMethods.retrieveText("experience").getText();
		model.addAttribute("text", text);
		return "experience";
	}
	
	@RequestMapping(value="/personalInfo", method = RequestMethod.GET)
	public String personalInfo(Model model) {
		String text = textMethods.retrieveText("personalInfo").getText();
		model.addAttribute("text", text);
		return "personalInfo";
	}
	
	@RequestMapping(value="/contact", method = RequestMethod.GET)
	public String contact(Model model) {
		String text = textMethods.retrieveText("contact").getText();
		model.addAttribute("text", text);
		return "contact";
	}
}
