package com.example.databasedemo.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(
  strategy = InheritanceType.SINGLE_TABLE
)
@DiscriminatorColumn(
  name = "employee_type"
)
public abstract class Employee {
  @Id
  @GeneratedValue
  Integer id;
  String name;

  public Employee() {
  }

  public Employee(String name) {
    this.name = name;
  }

  public Integer getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String toString() {
    return "Person{id=" + this.id + ", name='" + this.name + '\'' + '}';
  }
}