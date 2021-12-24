package com.example.databasedemo.repository;

import com.example.databasedemo.entity.Course;
import com.example.databasedemo.entity.Passport;
import com.example.databasedemo.entity.Student;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StudentRepository {
  @Autowired
  EntityManager entityManager;

  public StudentRepository() {
  }

  public Student findById(Long id) {
    return (Student)this.entityManager.find(Student.class, id);
  }

  public Student insert(Student student) {
    return (Student)this.entityManager.merge(student);
  }

  public void insertStudentWithPassword() {
    Passport passport = new Passport("ESD123AS");
    Student student = new Student("Rithvik");
    this.entityManager.persist(passport);
    student.setPassport(passport);
    this.entityManager.persist(student);
  }

  public void insertStudentAndCourse() {
    Course course = new Course("MS Patter");
    Student student = new Student("GNP");
    course.addStudent(student);
    student.addCourse(course);
    this.entityManager.persist(student);
    this.entityManager.persist(course);
  }

  public void deleteById(long id) {
    Student student = this.findById(id);
    this.entityManager.remove(student);
  }
}