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
				bookDao.save(bd);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public List<BookDetails> getAllBooks() {
		ObjectMapper mapper = new ObjectMapper();
		List<BookDetailsDto> bdd = null;
		List<BookDetails> bd = (List<BookDetails>) bookDao.findAll();
		try {
			bdd = (List<BookDetailsDto>) mapper.readValue(mapper.writeValueAsString(bd), BookDetailsDto.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bd;
		
	}
	
}
