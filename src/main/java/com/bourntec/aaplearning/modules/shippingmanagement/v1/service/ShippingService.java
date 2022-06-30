package com.bourntec.aaplearning.modules.shippingmanagement.v1.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Shipping;
import com.bourntec.aaplearning.modules.shippingmanagement.v1.dto.request.ShippingRequestDTO;
import com.bourntec.aaplearning.modules.shippingmanagement.v1.dto.response.ShippingResponseDTO;

import net.sf.jasperreports.engine.JRException;

@Service( "ShippingService") 
public interface ShippingService {

	ShippingResponseDTO findById(int shippingId);

	ShippingResponseDTO updateById(int shippingId, ShippingRequestDTO shippingRequestDTO);

	ShippingResponseDTO deleteById(int shippingId);

	ShippingResponseDTO save(ShippingRequestDTO shippingRequestDTO);

	List<Shipping> findAll();

	String generatePdf() throws JRException, IOException;

	//void generatePdf();


//	ShippingResponseDTO findAll();


}
