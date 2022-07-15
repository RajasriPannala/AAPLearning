package com.bourntec.aaplearning.modules.merchandisemanagement.v1.request;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Merchandise;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Aryalekshmi
 *
 */

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MerchandiseRequestDto {
	
	private Integer id;
	private String custId;
	@NotEmpty
	private String itemCode;
	@NotNull
	private Integer qty;
	private Double price;
	private Double discount;
	private LocalDate purchaseDate;
	private String status;
	
	public Merchandise convertToModel() {
		Merchandise merchandiseManagement = new Merchandise();
		BeanUtils.copyProperties(this, merchandiseManagement);
		return merchandiseManagement;
	}

}
