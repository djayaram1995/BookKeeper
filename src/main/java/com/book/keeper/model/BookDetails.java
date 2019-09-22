package com.book.keeper.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "book_details")
public class BookDetails implements Serializable {
	
	private static final long serialVersionUID = -2648969757919112609L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JsonProperty("subtitle")
	private String subtitle;
	@JsonProperty("title")
	private String title;
	@JsonProperty("url")
	private String url;
	@JsonProperty("notes")
	private String notes;
	@JsonProperty("publish_date")
	private String publishDate;

	@JsonProperty("subtitle")
	public String getSubtitle() {
		return subtitle;
	}

	@JsonProperty("subtitle")
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("notes")
	public String getNotes() {
		return notes;
	}

	@JsonProperty("notes")
	public void setNotes(String notes) {
		this.notes = notes;
	}

	@JsonProperty("publish_date")
	public String getPublishDate() {
		return publishDate;
	}

	@JsonProperty("publish_date")
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
}
