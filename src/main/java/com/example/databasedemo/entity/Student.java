package com.example.databasedemo.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {
  @Id
  @GeneratedValue
  private Long Id;
  @Column(
    nullable = false
  )
  private String name;
  @OneToOne(
    fetch = FetchType.LAZY
  )
  Passport passport;
  @ManyToMany
  @JoinTable(
    name = "STUDENT_COURSE",
    joinColumns = {@JoinColumn(
  name = "student_id"
)},
    inverseJoinColumns = {@JoinColumn(
  name = "course_id"
)}
  )
  private List<Course> courses = new ArrayList();

  public Student() {
  }

  public Student(String name) {
    this.name = name;
  }

  public Long getId() {
    return this.Id;
  }

  public void setId(Long id) {
    this.Id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Passport getPassport() {
    return this.passport;
  }

  public void setPassport(Passport passport) {
    this.passport = passport;
  }

  public List<Course> getCourses() {
    return this.courses;
  }

  public void addCourse(Course course) {
    this.courses.add(course);
  }

  public String toString() {
    return "Student{Id=" + this.Id + ", name='" + this.name + '\'' + '}';
  }
}