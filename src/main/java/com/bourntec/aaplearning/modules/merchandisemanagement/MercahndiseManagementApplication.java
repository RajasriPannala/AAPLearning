package com.bourntec.aaplearning.modules.merchandisemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("com.bourntec.aaplearning.entity")
@ComponentScan({"com.bourntec.aaplearning.modules.merchandisemanagement","com.bourntec.aaplearning.utility"})
public class MercahndiseManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercahndiseManagementApplication.class, args);
	}

}
