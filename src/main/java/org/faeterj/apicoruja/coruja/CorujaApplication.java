package org.faeterj.apicoruja.coruja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//
// @EntityScan(basePackages={ "org.faeterj.apicoruja.coruja.model.entity" })
// @EnableJpaRepositories(
//   basePackages={ "org.faeterj.apicoruja.coruja.model.repository" }
// )
@SpringBootApplication
public class CorujaApplication {

	public static void main (String[ ] args) {
		SpringApplication.run (CorujaApplication.class, args);
	}

}

// OK
