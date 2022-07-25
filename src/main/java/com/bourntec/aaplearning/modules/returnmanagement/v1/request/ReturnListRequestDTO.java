package com.bourntec.aaplearning.modules.returnmanagement.v1.request;


import java.util.List;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Return;
import com.bourntec.aaplearning.entity.ReturnList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Sarath G Krishnan
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnListRequestDTO {
	private Integer returnId;
	private Integer itemCount;
	private Integer invoiceId;
	private Integer custId;
	private Integer itemCode;
	private Integer retAmt;
	private Integer qty;
	private String description;
	private String Status ;
	 private Integer total;
	 
	 private List<ReturnList> returnLst;
	
	/**
	 * @return
	 */
	public Return converToModel() {
		Return returnData = new Return();
		BeanUtils.copyProperties(this, returnData);
		return returnData;

	}
	
}
