package com.bourntec.aaplearning.modules.paymentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

/**
 * @author Sandra Diraj
 *
 */
@EntityScan("com.bourntec.aaplearning.entity")
@ComponentScan({"com.bourntec.aaplearning.modules.paymentmanagement","com.bourntec.aaplearning.utility"})
@SpringBootApplication
@EnableJpaAuditing         //for automatically create the created and modified date
@EnableCaching
@EnableHystrix

/**
 * @OpenAPIDefinition specifies it is swagger3
 * @param we can define the title,which will be seen in Swagger UI
 * can also specify the version our microservice using version attribute
 *
 */
@OpenAPIDefinition(info = @Info(title = "Payment API",
					description = "Payment Information", 
					version ="1.0."))


@SecurityScheme(name = "paymentapi", scheme = "bearer",bearerFormat = "JWT", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
public class PaymentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentManagementApplication.class, args);
	}

}
