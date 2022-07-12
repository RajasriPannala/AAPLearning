package com.bourntec.aaplearning.modules.customermanagement.v1.response;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Sarath G Krishnan
 *
 */
@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {

	String responseMessage;
	Object payLoad;
	String status;

	/**
	 * @param customer
	 */
	public CustomerResponseDTO(Customer customer) {
		BeanUtils.copyProperties(customer, this);

	}
}
