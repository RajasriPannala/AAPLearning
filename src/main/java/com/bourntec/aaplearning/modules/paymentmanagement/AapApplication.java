package com.bourntec.aaplearning.modules.paymentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EntityScan("com.bourntec.aaplearning.entity")
@SpringBootApplication
@EnableJpaAuditing         //for automatically create the created and modified date
//@EnableScheduling
public class AapApplication {

	public static void main(String[] args) {
		SpringApplication.run(AapApplication.class, args);
	}

}
