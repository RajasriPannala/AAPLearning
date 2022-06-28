package com.bourntec.aaplearning.modules.returnmanagement.v1.request;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Return;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Rohini P M
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnRequestDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer returnId;
	private Integer invoiceId;
	private Integer custId;
	private Integer itemCode;
	private Integer retAmt;
	private Integer qty;
	private String description;
	
	public Return convertToModel() {
		Return returnManagement = new Return();



		BeanUtils.copyProperties(this, returnManagement);



		return returnManagement;
		}
}
