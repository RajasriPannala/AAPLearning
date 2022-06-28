package com.bourntec.aaplearning.aaplearningmodules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EntityScan("com.bourntec.aaplearning.entity")
@EnableJpaAuditing
@SpringBootApplication
public class AapLearningManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AapLearningManagementApplication.class, args);
	}

}
