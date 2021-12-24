package com.example.databasedemo.entity;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
  @Id
  @GeneratedValue
  public Long Id;
  @Enumerated
  public ReviewRating rating;
  public String description;
  @ManyToOne
  public Course course;

  public Course getCourse() {
    return this.course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public Review() {
  }

  public Review(ReviewRating rating, String description) {
    this.rating = rating;
    this.description = description;
  }

  public Long getId() {
    return this.Id;
  }

  public void setId(Long id) {
    this.Id = id;
  }

  public ReviewRating getRating() {
    return this.rating;
  }

  public void setRating(ReviewRating rating) {
    this.rating = rating;
  }

  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String toString() {
    return "Review{Id=" + this.Id + ", name='" + this.rating + '\'' + ", description='" + this.description + '\'' + '}';
  }
}