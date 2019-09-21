package com.book.keeper.model;

import java.util.List;

public class doc {
	private String title;
	private List<String> edition_key;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getEdition_key() {
		return edition_key;
	}
	public void setEdition_key(List<String> edition_key) {
		this.edition_key = edition_key;
	}
}
