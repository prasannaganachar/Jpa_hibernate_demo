package com.example.databasedemo.entity;

import java.math.BigDecimal;
import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {
  BigDecimal hourlyWages;

  public PartTimeEmployee() {
  }

  public PartTimeEmployee(String name, BigDecimal hourlyWages) {
    super(name);
    this.hourlyWages = hourlyWages;
  }

  public BigDecimal getHourlyWages() {
    return this.hourlyWages;
  }

  public void setHourlyWages(BigDecimal hourlyWages) {
    this.hourlyWages = hourlyWages;
  }

  public String toString() {
    return "PartTimeEmployee{id=" + this.id + ", name='" + this.name + '\'' + ", hourlyWages='" + this.hourlyWages + '\'' + '}';
  }
}