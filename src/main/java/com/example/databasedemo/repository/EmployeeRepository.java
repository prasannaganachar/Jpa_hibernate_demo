package com.example.databasedemo.repository;

import com.example.databasedemo.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class EmployeeRepository {
  @Autowired
  EntityManager entityManager;

  public EmployeeRepository() {
  }

  public List<Employee> retriveAllEmplyoess() {
    return this.entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
  }

  public void insert(Employee employee) {
    this.entityManager.persist(employee);
  }
}
