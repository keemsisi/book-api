package com.polaristech.bookassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(value = "**")
@SpringBootApplication
public class BookassignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookassignmentApplication.class, args);
	}

}
