package com.example.databasedemo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
  @Id
  @GeneratedValue
  public Long Id;
  public String number;
  @OneToOne(
    fetch = FetchType.LAZY,
    mappedBy = "passport"
  )
  Student student;

  public Passport() {
  }

  public Passport(String name) {
    this.number = name;
  }

  public Long getId() {
    return this.Id;
  }

  public void setId(Long id) {
    this.Id = id;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(String name) {
    this.number = name;
  }

  public String toString() {
    return "Passport{Id=" + this.Id + ", name='" + this.number + '\'' + '}';
  }
}