package com.bourntec.aaplearning.modules.paymentmanagement.v1.request;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.bourntec.aaplearning.entity.Payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Sandra Diraj
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {
	
	
	private Integer paymentId;
	private Integer customerId;
	private Integer invoiceId;
	private Integer paidAmount;
	private String status;
	private String paymentType;
	LocalDate paymentDate;

	public Payment convertToModel() {
		Payment payment = new Payment();

		
		BeanUtils.copyProperties(this, payment);

		return payment;
	}
	
	public Payment convertToModel(Payment payment ) {
		

		
		BeanUtils.copyProperties(this, payment,getNullPropertyNames(this));

		return payment;
	}
	public static String[] getNullPropertyNames (Object source) {
	    final BeanWrapper src = new BeanWrapperImpl(source);
	    java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

	    Set<String> emptyNames = new HashSet<>();
	    for(java.beans.PropertyDescriptor pd : pds) {
	        Object srcValue = src.getPropertyValue(pd.getName());
	        if (srcValue == null) emptyNames.add(pd.getName());
	    }

	    String[] result = new String[emptyNames.size()];
	    return emptyNames.toArray(result);
	}
	

	}

