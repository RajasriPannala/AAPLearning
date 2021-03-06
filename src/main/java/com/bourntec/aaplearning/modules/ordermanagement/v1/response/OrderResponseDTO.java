package com.bourntec.aaplearning.modules.ordermanagement.v1.response;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.OrderData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Karthika J
 *
 */

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

/**
 * @param OrderRequestDTO : order
 */
public class OrderResponseDTO {

	String responseMessage;
	Object payload;
	String status;

	/**
	 * @param order : order
	 */
	public void OrderResponseDto(OrderData order) {

		BeanUtils.copyProperties(order, this);
	}

}
