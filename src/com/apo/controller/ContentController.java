package com.apo.controller;
import com.apo.model.Text;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.apo.TextMethods;
import com.apo.TextMethodsImpl;
@Controller
public class ContentController {
	// INDEX
	private TextMethods textMethods = new TextMethodsImpl();
	@RequestMapping(value = "/editIndex", method = RequestMethod.GET)
		public String editIndex(Model model){
			String text = textMethods.retrieveText("index").getText();
			model.addAttribute("text", text);
			return "forms/editIndex";
		}
	@RequestMapping(value = "/editIndex", method = RequestMethod.POST)
	public String indexSubmitTextChange (@RequestParam String text){
		Text editedText = new Text();
		editedText.setId("index");
		editedText.setText(text);;
		textMethods.editText(editedText);
		
		return "redirect:/";
	}
	// EDUCATION
	@RequestMapping(value = "/editEducation", method = RequestMethod.GET)
	public String editEducation(Model model){
		String text = textMethods.retrieveText("education").getText();
		model.addAttribute("text", text);
		return "forms/editEducation";
	}
@RequestMapping(value = "/editEducation", method = RequestMethod.POST)
public String educationSubmitTextChange (@RequestParam String text){
	Text editedText = new Text();
	editedText.setId("education");
	editedText.setText(text);;
	textMethods.editText(editedText);
	
	return "redirect:/education";
}
// EXPERIENCE
@RequestMapping(value = "/editExperience", method = RequestMethod.GET)
public String editExperience(Model model){
	String text = textMethods.retrieveText("experience").getText();
	model.addAttribute("text", text);
	return "forms/editExperience";
}
@RequestMapping(value = "/editExperience", method = RequestMethod.POST)
public String experienceSubmitTextChange (@RequestParam String text){
Text editedText = new Text();
editedText.setId("experience");
editedText.setText(text);;
textMethods.editText(editedText);

return "redirect:/experience";
}
// PERSONAL INFO
@RequestMapping(value = "/editPersonalInfo", method = RequestMethod.GET)
public String editPersonalInfo(Model model){
	String text = textMethods.retrieveText("personalInfo").getText();
	model.addAttribute("text", text);
	return "forms/editPersonalInfo";
}
@RequestMapping(value = "/editPersonalInfo", method = RequestMethod.POST)
public String personalInfoSubmitTextChange (@RequestParam String text){
Text editedText = new Text();
editedText.setId("personalInfo");
editedText.setText(text);;
textMethods.editText(editedText);

return "redirect:/personalInfo";
}
// INTERESTS
@RequestMapping(value = "/editInterests", method = RequestMethod.GET)
public String editInterests(Model model){
	String text = textMethods.retrieveText("interests").getText();
	model.addAttribute("text", text);
	return "forms/editInterests";
}
@RequestMapping(value = "/editInterests", method = RequestMethod.POST)
public String interestsSubmitTextChange (@RequestParam String text){
Text editedText = new Text();
editedText.setId("interests");
editedText.setText(text);;
textMethods.editText(editedText);

return "redirect:/interests";
}
//  CONTACT
@RequestMapping(value = "/editContact", method = RequestMethod.GET)
public String editContact(Model model){
	String text = textMethods.retrieveText("contact").getText();
	model.addAttribute("text", text);
	return "forms/editContact";
}
@RequestMapping(value = "/editContact", method = RequestMethod.POST)
public String contactSubmitTextChange (@RequestParam String text){
Text editedText = new Text();
editedText.setId("contact");
editedText.setText(text);;
textMethods.editText(editedText);

return "redirect:/contact";
}
}
