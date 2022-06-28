package com.bourntec.aaplearning.modules.customermanagement.v1.request;

import javax.persistence.Column;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Sarath G Krishnan
 *
 */
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {
	private String customerName;
	private String address;
	private Integer pinCode;
	private Long phoneNumber;
	private String email;
	private String password;
	@Column(length = 1)
	private String status;
	
	public Customer convertToModel() {
		Customer customer=new Customer();
		BeanUtils.copyProperties(this, customer);
		return customer;
}
}
