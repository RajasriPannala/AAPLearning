package com.bourntec.aaplearning.modules.commonmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan("com.bourntec.aaplearning.entity")
public class CommonManagamentApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonManagamentApplication.class, args);
	}
}
