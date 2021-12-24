package com.example.databasedemo.repository;

import com.example.databasedemo.entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PersonJpaRepository {
  @PersistenceContext
  EntityManager entityManager;

  public PersonJpaRepository() {
  }

  public Person insertUpdatePerson(Person person) {
    return (Person)this.entityManager.merge(person);
  }

  public Person findById(Integer id) {
    return (Person)this.entityManager.find(Person.class, id);
  }
}
