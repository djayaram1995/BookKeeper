package com.book.keeper.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.book.keeper.model.BookDetailsDto;
import com.book.keeper.model.BookList;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OpenLibraryService {
	
	
	public BookList getBooks(String searchString) {
		String url="https://openlibrary.org/search.json?q="+searchString;
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		BookList books = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			String bookSearch = restTemplate.getForObject(url, String.class);
			System.out.println(bookSearch);
			books = mapper.readValue(bookSearch, BookList.class);
			System.out.println(books);
		} catch (RestClientException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}
	
	public BookDetailsDto getSelectedBook(String bookId) {
		String url="https://openlibrary.org/api/books?bibkeys=OLID:"+bookId+"&jscmd=data&format=json";
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.UNWRAP_ROOT_VALUE, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		BookDetailsDto books = null;
		RestTemplate restTemplate = new RestTemplate();
		try {
			String bookSearch = restTemplate.getForObject(url, String.class);
			bookSearch = bookSearch.substring(bookSearch.indexOf(":", bookSearch.indexOf(":") + 1)+1, bookSearch.length()-1);
			System.out.println(bookSearch);
			books = mapper.readValue(bookSearch, BookDetailsDto.class);
			System.out.println(books);
		} catch (RestClientException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return books;
	}

}
