package com.apo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "text")
public class Text {
	@Id
	@Column(name="text_id")
	private String id;
	@Column(name="text")
	private String text;
	
	public Text(){};
	
	public Text(String id, String text){
		this.id = id;
		this.text = text;
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
