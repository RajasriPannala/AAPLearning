package com.bourntec.aaplearning.modules.returnmanagement.v1.request;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

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
	public Return convertToModel(Return returnManagement ) {




		BeanUtils.copyProperties(this, returnManagement,getNullPropertyNames(this));



		return returnManagement;
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
