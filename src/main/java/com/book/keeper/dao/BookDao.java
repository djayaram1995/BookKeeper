package com.book.keeper.dao;

import org.springframework.data.repository.CrudRepository;

import com.book.keeper.model.BookDetails;

public interface BookDao extends CrudRepository<BookDetails, Integer> {

}
