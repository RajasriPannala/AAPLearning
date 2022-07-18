package com.bourntec.aaplearning.modules.returnmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;



@SpringBootApplication
@EnableJpaAuditing
@EntityScan("com.bourntec.aaplearning.entity")
@ComponentScan({"com.bourntec.aaplearning.modules.returnmanagement","com.bourntec.aaplearning.utility"})
//@ComponentScan("com.bourntec.aaplearning.entity")


/**
 * @OpenAPIDefinition specifies it is swagger3
 * @param we can define the title,which will be seen in Swagger UI
 * can also specify the version our microservice using version attribute
 *
 */


@OpenAPIDefinition(info = @Info(title = "Return API",
description = "Return Information",
version ="1.0."))


@SecurityScheme(name = "returnapi", scheme = "bearer",bearerFormat = "JWT", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)




public class ReturnManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReturnManagementApplication.class, args);
	}

}
