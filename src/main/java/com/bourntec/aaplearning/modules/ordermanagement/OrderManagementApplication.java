package com.bourntec.aaplearning.modules.ordermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



/**
 * @author Karthika J
 *
 */
@EntityScan("com.bourntec.aaplearning.entity")
@ComponentScan({"com.bourntec.aaplearning.modules.ordermanagement","com.bourntec.aaplearning.utility"})
@SpringBootApplication
@EnableJpaAuditing

public class OrderManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApplication.class, args);
	}

}
