package com.polaristech.bookassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(value = "**")
@EntityScan(value = "com.polaristech.bookassignment.entity")
@SpringBootApplication
public class BookAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookAssignmentApplication.class, args);
	}

}
