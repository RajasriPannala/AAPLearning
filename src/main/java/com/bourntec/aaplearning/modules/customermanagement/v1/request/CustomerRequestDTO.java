package com.bourntec.aaplearning.modules.customermanagement.v1.request;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.bourntec.aaplearning.entity.Customer;
import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
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
//@JsonFilter("customerDetails")
public class CustomerRequestDTO {
	private Integer customerId;
	@NotNull(message = " this field can not be null")
	private String name;
	@NotBlank(message = " this field can not be blank")
	private String address;
	private Integer pinCode;
	private Long phoneNumber;
	@Email
	private String email;
	@Size(min = 4, message = "password should have at least 4 characters")
	private String password;
	@Column(length = 1)
	private String status;

	public Customer convertToModel() {
		Customer customer = new Customer();
		BeanUtils.copyProperties(this, customer);
		return customer;
	}

	public Customer convertToModel(Customer customer) {
		BeanUtils.copyProperties(this, customer, getNullPropertyNames(this));
		return customer;
	}

	public static String[] getNullPropertyNames(Object source) {
		final BeanWrapper src = new BeanWrapperImpl(source);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
		Set<String> emptyNames = new HashSet<>();
		for (java.beans.PropertyDescriptor pd : pds) {
			Object srcValue = src.getPropertyValue(pd.getName());
			if (srcValue == null)
				emptyNames.add(pd.getName());
		}
		String[] result = new String[emptyNames.size()];
		return emptyNames.toArray(result);
	}

}
