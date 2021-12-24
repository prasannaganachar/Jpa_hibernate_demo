package com.example.databasedemo.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
  @Id
  @GeneratedValue
  Integer id;
  String name;
  String location;
  Date dateOfBirth;

  public Person() {
  }

  public Person(String name, String location, Date dateOfBirth) {
    this.name = name;
    this.location = location;
    this.dateOfBirth = dateOfBirth;
  }

  public Integer getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getLocation() {
    return this.location;
  }

  public Date getDateOfBirth() {
    return this.dateOfBirth;
  }

  public String toString() {
    return "Person{id=" + this.id + ", name='" + this.name + '\'' + ", location='" + this.location + '\'' + ", dateOfBirth=" + this.dateOfBirth + '}';
  }
}