package com.example.databasedemo.repository;

import com.example.databasedemo.entity.Course;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
  path = "courses"
)
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
  List<Course> findByName(String name);

  List<Course> countByName(String name);

  List<Course> deleteByName(String name);

  @Query("select c from Course c where c.name like '%jpa'")
  List<Course> courseWithJPa();
}