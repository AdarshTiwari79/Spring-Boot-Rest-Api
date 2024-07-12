package com.springboot.restapi.restapi.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.restapi.restapi.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

  // creating a custom finder method
  public Book findBookById(int id);

}
