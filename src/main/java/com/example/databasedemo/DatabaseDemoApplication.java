package com.example.databasedemo;

import com.example.databasedemo.entity.Course;
import com.example.databasedemo.entity.FullTimeEmployee;
import com.example.databasedemo.entity.PartTimeEmployee;
import com.example.databasedemo.entity.Student;
import com.example.databasedemo.repository.CourseRepository;
import com.example.databasedemo.repository.CourseSpringDataRepository;
import com.example.databasedemo.repository.EmployeeRepository;
import com.example.databasedemo.repository.PersonJpaRepository;
import com.example.databasedemo.repository.StudentRepository;
import java.math.BigDecimal;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {
	Logger logger = LoggerFactory.getLogger(DatabaseDemoApplication.class);
	@Autowired
	PersonJpaRepository repository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	CourseSpringDataRepository courseSpringDataRepository;

	public DatabaseDemoApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	public void run(String... args) throws Exception {
		this.studentOperation();
	}

	private void studentOperation() {
		this.studentRepository.insertStudentAndCourse();
		this.studentRepository.insertStudentWithPassword();
		Student student = this.studentRepository.findById(1L);
		this.logger.info("Studen --> {} ", student);
		//this.logger.info("course --> {}", student.getCourses());
	}

	private void courseOperation() {
		this.courseRepository.insertCourseAndReview();
		this.courseSpringDataRepository.save(new Course("Jpa Data"));
		this.courseSpringDataRepository.save(new Course("Transaction Data"));
		this.courseSpringDataRepository.save(new Course("Jpa Data_2"));
		this.courseSpringDataRepository.save(new Course("Transaction Data_2"));
		List<Course> customCourse = this.courseSpringDataRepository.findByName("Jpa Data_2");
		this.logger.info(" customCourse course --> {} ", customCourse);
	}

	@Transactional
	public void firstLevelCacheDemo() {
		this.courseSpringDataRepository.save(new Course("Jpa Data_2"));
		this.courseSpringDataRepository.save(new Course("Transaction Data_2"));
		List<Course> customCourse = this.courseSpringDataRepository.findByName("Jpa Data_2");
		this.logger.info(" customCourse course --> {} ", customCourse);
		List<Course> customCourse2 = this.courseSpringDataRepository.findByName("Jpa Data_2");
		this.logger.info(" customCourse course again--> {} ", customCourse2);
	}

	private void employeeOperation() {
		this.employeeRepository.insert(new PartTimeEmployee("Prasanna", new BigDecimal(20000.0D)));
		this.employeeRepository.insert(new FullTimeEmployee("Ravi", new BigDecimal(780000.0D)));
		System.out.println(this.employeeRepository.retriveAllEmplyoess());
	}
}