package com.springboot.restapi.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.restapi.restapi.dao.BookRepository;
import com.springboot.restapi.restapi.entities.Book;

@Service
public class RestService {

  /* This is a fake survice before the connection with database */
  /*
   * private static List<Book> books = new ArrayList<>();
   * 
   * static {
   * initializeBook();
   * }
   * 
   * private static void initializeBook() {
   * books.add(new Book(1, "Learn java", "java", "Ganesh"));
   * books.add(new Book(2, "Spring Boot", "Spring", "Adarsh"));
   * books.add(new Book(3, "JSTL", "jsp", "Saurav"));
   * }
   */

  @Autowired
  private BookRepository bookRepository;

  // Selecting multiple books
  public List<Book> getAllBooks() {

    List<Book> books = (List<Book>) this.bookRepository.findAll();
    return books;
  }

  // Selecting single book
  public Book getBookById(int id) {

    Book bookById = null;
    try {
      bookById = this.bookRepository.findBookById(id);

      // This code works when we are using fake survice
      // bookById = books.stream().filter(book -> book.getId() ==
      // id).findFirst().get();
    } catch (Exception e) {
      System.out.println(e);
    }
    return bookById;
  }

  // Inserting a book
  public void addBooks(Book book) {
    this.bookRepository.save(book);

    // This code is for fake service
    // books.add(book);
    // return book;
  }

  public void deleteBook(int bId) {

    this.bookRepository.deleteById(bId);
    // This code is for fake service
    // books = books.stream().filter(book -> book.getId() !=
    // bId).collect(Collectors.toList());
    // books.removeIf(book -> book.getId() == bId);
  }

  public void updateBook(int bId, Book book) {

    book.setId(bId);
    this.bookRepository.save(book);

    // books = books.stream().map(e -> {
    // if (e.getId() == bId) {
    // e.setBook_author(book.getBook_author());
    // e.setBook_name(book.getBook_name());
    // e.setBook_title(book.getBook_title());
    // }
    // return e;
    // }).collect(Collectors.toList());
    // return book;
  }
}
