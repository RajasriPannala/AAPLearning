package com.bourntec.aaplearning.modules.promocode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
@SpringBootApplication
@EntityScan("com.bourntec.aaplearning.entity")
@ComponentScan({"com.bourntec.aaplearning.modules.promocode","com.bourntec.aaplearning.utility"})
@EnableJpaAuditing    
public class PromocodeManagamentApplication {
	public static void main(String[] args) {
		SpringApplication.run(PromocodeManagamentApplication.class, args);
	}
}
