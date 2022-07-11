package com.bourntec.aaplearning.modules.promocode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
/**
 * @author Jeena Thomas
 *
 */
@SpringBootApplication
@EntityScan("com.bourntec.aaplearning.entity")
@ComponentScan({"com.bourntec.aaplearning.modules.promocode","com.bourntec.aaplearning.utility"})
@EnableJpaAuditing  
@OpenAPIDefinition(info = @Info(title = "Promocode API",
description = "Promocode Information", 
version ="1.0."))
@SecurityScheme(name = "promocodeapi", scheme = "bearer",bearerFormat = "JWT", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class PromocodeManagamentApplication {
	public static void main(String[] args) {
		SpringApplication.run(PromocodeManagamentApplication.class, args);
	}
}
