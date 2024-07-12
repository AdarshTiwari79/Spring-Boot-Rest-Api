package com.springboot.restapi.restapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String book_title;
  private String book_name;
  private String book_author;

  public Book() {
  }

  public Book(int id, String book_title, String book_name, String book_author) {
    this.id = id;
    this.book_title = book_title;
    this.book_name = book_name;
    this.book_author = book_author;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setBook_title(String book_title) {
    this.book_title = book_title;
  }

  public void setBook_name(String book_name) {
    this.book_name = book_name;
  }

  public void setBook_author(String book_author) {
    this.book_author = book_author;
  }

  public int getId() {
    return id;
  }

  public String getBook_title() {
    return book_title;
  }

  public String getBook_name() {
    return book_name;
  }

  public String getBook_author() {
    return book_author;
  }

}
