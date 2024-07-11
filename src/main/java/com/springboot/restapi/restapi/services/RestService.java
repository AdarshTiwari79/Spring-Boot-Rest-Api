package com.springboot.restapi.restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.restapi.restapi.entities.Book;

@Service
public class RestService {

  static final List<Book> books = new ArrayList<>();
  static {
    books.add(new Book(1, "Learn java", "java", "Ganesh"));
    books.add(new Book(2, "Spring Boot", "Spring", "Adarsh"));
    books.add(new Book(3, "JSTL", "jsp", "Saurav"));
  }

  public List<Book> getAllBooks() {
    return books;
  }

  public Book getBookById(int id) {

    Book bookById = books.stream().filter(book -> book.getId() == id).findFirst().get();
    return bookById;
  }

  public Book addBooks(Book book) {
    books.add(book);
    return book;
  }

  public void deleteBook(int bId) {
    books.stream().filter(book -> book.getId() != bId).collect(Collectors.toList());
  }

}
