package com.springboot.restapi.restapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.restapi.restapi.entities.Book;
import com.springboot.restapi.restapi.services.RestService;

@RestController
public class MainRestController {

  @Autowired
  private RestService restService;

  @GetMapping("/books")
  public ResponseEntity<List<Book>> getAll() {
    List<Book> books = this.restService.getAllBooks();
    if (books.size() <= 0) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(books));
  }

  @GetMapping("/book/{id}")
  public ResponseEntity<Book> getSingleBook(@PathVariable("id") int bookId) {

    Book book = restService.getBookById(bookId);
    if (book == null) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.status(HttpStatus.OK).body(book);
  }

  @PostMapping("/book")
  public ResponseEntity<Book> addBook(@RequestBody Book b) {
    Book book;
    try {
      book = this.restService.addBooks(b);
      return ResponseEntity.status(HttpStatus.CREATED).body(book);
    } catch (Exception e) {
      System.out.println(e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @DeleteMapping("/book/{id}")
  public ResponseEntity<Void> deleteBook(@PathVariable("id") int bookId) {
    try {
      this.restService.deleteBook(bookId);
      return ResponseEntity.status(HttpStatus.OK).build();
    } catch (Exception e) {
      System.out.println(e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

  @PutMapping("book/{id}")
  public ResponseEntity<Book> updateBook(@PathVariable("id") int id, @RequestBody Book book) {

    Book updatedBook;
    try {
      updatedBook = this.restService.updateBook(id, book);
      return ResponseEntity.status(HttpStatus.OK).body(updatedBook);
    } catch (Exception e) {
      System.out.println(e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }

}
