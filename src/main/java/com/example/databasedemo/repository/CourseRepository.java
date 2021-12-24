package com.example.databasedemo.repository;

import com.example.databasedemo.entity.Course;
import com.example.databasedemo.entity.Review;
import com.example.databasedemo.entity.ReviewRating;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseRepository {
  @Autowired
  EntityManager entityManager;

  public CourseRepository() {
  }

  public Course findById(Long id) {
    return (Course)this.entityManager.find(Course.class, id);
  }

  public Course insert(Course course) {
    return (Course)this.entityManager.merge(course);
  }

  public void insertCourseAndReview() {
    Course course = new Course("azure 100");
    Review review = new Review(ReviewRating.TWO, "avg");
    review.setCourse(course);
    this.entityManager.persist(review);
    Review review2 = new Review(ReviewRating.FIVE, "Good");
    review2.setCourse(course);
    this.entityManager.persist(review2);
    this.entityManager.persist(course);
  }

  public void deleteById(long id) {
    Course course = this.findById(id);
    this.entityManager.remove(course);
  }
}
