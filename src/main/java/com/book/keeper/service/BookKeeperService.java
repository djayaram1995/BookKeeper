package com.book.keeper.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.keeper.dao.BookDao;
import com.book.keeper.model.BookDetails;
import com.book.keeper.model.BookDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BookKeeperService {

	@Autowired
	private BookDao bookDao;
	
	public void saveBook(BookDetailsDto bdd) {
		ObjectMapper mapper = new ObjectMapper();
			try {
				System.out.println("bdd"+bdd);
				BookDetails bd = mapper.readValue(mapper.writeValueAsString(bdd), BookDetails.class);
				System.out.println(bd);
				BookDetails bdExist = bookDao.findByUrl(bd.getUrl());
				if(bdExist == null) {
					bookDao.save(bd);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public List<BookDetails> getAllBooks() {
		List<BookDetails> bd = (List<BookDetails>) bookDao.findAll();
		return bd;
		
	}
	public String deleteBook(String url) {
		BookDetails bd = bookDao.findByUrl(url);
		bookDao.delete(bd);
		return "deleted";
	}
	
}
