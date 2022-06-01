package com.bourntec.aaplearning.modules.commonmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EnableEurekaClient
@EntityScan("com.bourntec.aaplearning.entity")
public class CommonManagamentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonManagamentApplication.class, args);
	}
}
