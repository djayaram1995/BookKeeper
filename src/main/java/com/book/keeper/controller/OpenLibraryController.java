package com.book.keeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.keeper.model.BookDetails;
import com.book.keeper.model.BookList;
import com.book.keeper.service.OpenLibraryService;

@RestController
public class OpenLibraryController {
	
	
	@Autowired
	OpenLibraryService openLibraryService;
	
	@RequestMapping({ "/getBooks/{searchString}" })
	
	public BookList getBooks(@PathVariable String searchString) {
		
		return openLibraryService.getBooks(searchString);
	}
	
	@RequestMapping({ "/getBook/{bookId}" })
	
	public BookDetails getBook(@PathVariable String bookId) {
		
		return openLibraryService.getSelectedBook(bookId);
	}

}