package com.apo;

import com.apo.model.Text;

public interface TextMethods {
	// add new text
	void addText(String id, String text);
	// edit text
	void editText(Text text);
	//retrieve text
	Text retrieveText(String id);
	
	
}
