package com.sena.getback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) 
public class ProjectgetbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectgetbackApplication.class, args);
	}

}
