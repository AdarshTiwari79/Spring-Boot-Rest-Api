package com.springboot.restapi.restapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.restapi.restapi.entities.Book;

@Service
public class RestService {

  private static List<Book> books = new ArrayList<>();

  static {
    initializeBook();
  }

  private static void initializeBook() {
    books.add(new Book(1, "Learn java", "java", "Ganesh"));
    books.add(new Book(2, "Spring Boot", "Spring", "Adarsh"));
    books.add(new Book(3, "JSTL", "jsp", "Saurav"));
  }

  public List<Book> getAllBooks() {
    return books;
  }

  public Book getBookById(int id) {

    Book bookById = null;
    try {
      bookById = books.stream().filter(book -> book.getId() == id).findFirst().get();
    } catch (Exception e) {
      System.out.println(e);
    }
    return bookById;
  }

  public Book addBooks(Book book) {
    books.add(book);
    return book;
  }

  public void deleteBook(int bId) {
    books = books.stream().filter(book -> book.getId() != bId).collect(Collectors.toList());
    // books.removeIf(book -> book.getId() == bId);
  }

  public Book updateBook(int bId, Book book) {
    books = books.stream().map(e -> {
      if (e.getId() == bId) {
        e.setBook_author(book.getBook_author());
        e.setBook_name(book.getBook_name());
        e.setBook_title(book.getBook_title());
      }
      return e;
    }).collect(Collectors.toList());
    return book;
  }
}
