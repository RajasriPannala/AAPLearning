package com.bourntec.aaplearning.modules.invoicemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


/**
 * @author Esther Tomy
 *
 */
@EntityScan("com.bourntec.aaplearning.entity")
@SpringBootApplication
@EnableJpaAuditing
//@ComponentScan({"com.bourntec.aaplearning.entity"})

public class InvoiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}

}
