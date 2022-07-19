package com.bourntec.aaplearning.modules.invoicemanagement.v1.request;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bourntec.aaplearning.entity.Invoice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDateSearchDTO {
	 private String startDate;

	    private String endDate;
	    private Integer custId;
		public Invoice converToModel() {
			// TODO Auto-generated method stub
			return null;
		}
		

}
