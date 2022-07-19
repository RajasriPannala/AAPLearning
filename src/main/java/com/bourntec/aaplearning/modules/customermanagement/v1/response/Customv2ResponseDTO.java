package com.bourntec.aaplearning.modules.customermanagement.v1.response;

import java.util.List;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.entity.OrderData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
	@Setter
	@Getter
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class Customv2ResponseDTO {

	
		
		List<OrderData> orders ;
		
		List<Invoice> invoices;
		

		}

