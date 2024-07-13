package com.springboot.restapi.restapi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int author_Id;
  private String firstName;
  private String lastName;
  private String language;

  public Author() {
  }

  public Author(int author_Id, String firstName, String lastName, String language) {
    this.author_Id = author_Id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.language = language;
  }

  public int getAuthor_Id() {
    return author_Id;
  }

  public void setAuthor_Id(int author_Id) {
    this.author_Id = author_Id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

}
