package com.bourntec.aaplearning.modules.customermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;




@EntityScan("com.bourntec.aaplearning.entity")
@EnableJpaAuditing
@SpringBootApplication
//@EnableEurekaClient
@ComponentScan({"com.bourntec.aaplearning.modules.customermanagement","com.bourntec.aaplearning.utility"})
public class CustomerManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementApplication.class, args);
	}

}
