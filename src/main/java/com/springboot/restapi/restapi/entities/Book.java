package com.springboot.restapi.restapi.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String book_title;
  private String book_name;

  @OneToOne(cascade = CascadeType.ALL)
  private Author author;

  public Book() {
  }

  public Book(Author author, String book_name, String book_title, int id) {
    this.author = author;
    this.book_name = book_name;
    this.book_title = book_title;
    this.id = id;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
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

  public int getId() {
    return id;
  }

  public String getBook_title() {
    return book_title;
  }

  public String getBook_name() {
    return book_name;
  }

}
