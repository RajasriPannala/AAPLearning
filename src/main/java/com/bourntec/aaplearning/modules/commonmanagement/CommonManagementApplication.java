package com.bourntec.aaplearning.modules.commonmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@EntityScan("com.bourntec.aaplearning.entity")
@EnableJpaAuditing
@SpringBootApplication
@EnableScheduling
//@EnableFeignClients
@ComponentScan({"com.bourntec.aaplearning.commonmanagement","com.bourntec.aaplearning.utility"})
public class CommonManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommonManagementApplication.class, args);
	}

}
