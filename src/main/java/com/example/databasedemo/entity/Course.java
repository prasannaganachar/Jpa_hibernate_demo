package com.example.databasedemo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(
  name = "course"
)
@Cacheable
public class Course {
  @Id
  @GeneratedValue
  private Long Id;
  private String name;
  @CreationTimestamp
  private LocalDateTime createdAt;
  @UpdateTimestamp
  private LocalDateTime updatedAt;
  @ManyToMany(
    mappedBy = "courses"
  )
  private List<Student> students = new ArrayList();
  @OneToMany(
    mappedBy = "course"
  )
  public List<Review> reviews = new ArrayList();

  public Course() {
  }

  public Course(String name) {
    this.name = name;
  }

  public Long getId() {
    return this.Id;
  }

  public void setId(Long Id) {
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Review> getReviews() {
    return this.reviews;
  }

  public void setReviews(List<Review> reviews) {
    this.reviews = reviews;
  }

  public void addReview(Review review) {
    this.reviews.add(review);
  }

  public void removeReview(Review review) {
    this.reviews.remove(review);
  }

  public List<Student> getStudents() {
    return this.students;
  }

  public void addStudent(Student student) {
    this.students.add(student);
  }

  public String toString() {
    return "Course{Id=" + this.Id + ", name='" + this.name + '\'' + '}';
  }
}