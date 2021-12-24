package com.example.databasedemo.entity;

import java.math.BigDecimal;
import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {
  BigDecimal salary;

  public FullTimeEmployee() {
  }

  public FullTimeEmployee(String name, BigDecimal salary) {
    super(name);
    this.salary = salary;
  }

  public BigDecimal getSalary() {
    return this.salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public String toString() {
    return "Full Time Employee{id=" + this.id + ", name='" + this.name + '\'' + ", salary='" + this.salary + '\'' + '}';
  }
}