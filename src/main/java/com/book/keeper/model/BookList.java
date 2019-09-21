package com.book.keeper.model;

import java.util.List;

public class BookList {
	private String start;
	private String numFound;
	private List<doc> docs;
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getNumFound() {
		return numFound;
	}
	public void setNumFound(String numFound) {
		this.numFound = numFound;
	}
	public List<doc> getDocs() {
		return docs;
	}
	public void setDocs(List<doc> docs) {
		this.docs = docs;
	}
}
