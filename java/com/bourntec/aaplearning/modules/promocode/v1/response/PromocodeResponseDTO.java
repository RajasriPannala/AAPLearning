package com.bourntec.aaplearning.modules.promocode.v1.response;

import org.springframework.beans.BeanUtils;

import com.bourntec.aaplearning.entity.Promocode;
import com.bourntec.aaplearning.modules.promocode.v1.request.PromocodeRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromocodeResponseDTO {
	

String responsemessage;
Object payload;
String Status;
private double totalAmount;
private double amountToPay;
public PromocodeResponseDTO(Promocode promocode) {

//payload=promocode.converToModel();

	BeanUtils.copyProperties(promocode,this);

}	 
}