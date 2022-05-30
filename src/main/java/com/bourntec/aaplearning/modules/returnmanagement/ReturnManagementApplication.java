package com.bourntec.aaplearning.modules.returnmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan("com.bourntec.aaplearning.entity")
//@ComponentScan("com.bourntec.aaplearning.entity")
public class ReturnManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReturnManagementApplication.class, args);
	}

}
