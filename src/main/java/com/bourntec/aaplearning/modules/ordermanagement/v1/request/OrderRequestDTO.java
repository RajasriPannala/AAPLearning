package com.bourntec.aaplearning.modules.ordermanagement.v1.request;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.OrderData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Karthika J
 *
 */


@Data
//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
	
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)


//	private Integer orderId;
	private Integer custId;
	private Integer itemCode;
	private String address;
	private Integer itemcount;
	private LocalDate orderDate;
	private Integer trackingId;
	
	private String orderStatus;
	
	  public OrderData convertToModel() {
			
		 OrderData order=new OrderData();

			BeanUtils.copyProperties(this, order);
			return order;

}
}
