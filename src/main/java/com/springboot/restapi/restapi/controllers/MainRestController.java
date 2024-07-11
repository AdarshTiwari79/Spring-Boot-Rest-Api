package com.springboot.restapi.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.restapi.entities.Book;
import com.springboot.restapi.restapi.services.RestService;




@RestController
public class MainRestController {
  
  @Autowired
  private RestService restService;

  @GetMapping("/books") 
  public List<Book> getAll()
  {
    List<Book> books = this.restService.getAllBooks();
    return books;
  }

  @GetMapping("/book/{id}")
  public Book getSingleBook(@PathVariable("id") int bookId) {
      
    Book book = restService.getBookById(bookId);  
    return book;
  }

  @PostMapping("/book")
  public Book addBook(@RequestBody Book b)
  {
    Book book = this.restService.addBooks(b);
    return book;
  }
  
  
  
}
