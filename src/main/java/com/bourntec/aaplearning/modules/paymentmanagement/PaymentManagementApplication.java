package com.bourntec.aaplearning.modules.paymentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EntityScan("com.bourntec.aaplearning.entity")
@ComponentScan({"com.bourntec.aaplearning.modules.paymentmanagement","com.bourntec.aaplearning.utility"})
@SpringBootApplication
@EnableJpaAuditing         //for automatically create the created and modified date
//@EnableScheduling
//@ComponentScan({"com.bourntec.aaplearning.entity"})
public class PaymentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentManagementApplication.class, args);
	}

}
