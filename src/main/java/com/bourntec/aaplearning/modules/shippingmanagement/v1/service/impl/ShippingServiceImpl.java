package com.bourntec.aaplearning.modules.shippingmanagement.v1.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Shipping;
import com.bourntec.aaplearning.modules.shippingmanagement.v1.dto.request.ShippingRequestDTO;
import com.bourntec.aaplearning.modules.shippingmanagement.v1.dto.response.ShippingResponseDTO;
import com.bourntec.aaplearning.modules.shippingmanagement.v1.repository.ShippingRepository;
import com.bourntec.aaplearning.modules.shippingmanagement.v1.service.ShippingService;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service("ShippingService")
public class ShippingServiceImpl implements ShippingService {
	Logger logger = LoggerFactory.getLogger(ShippingServiceImpl.class);

	@Autowired
	ShippingRepository shippingRepository;

	@Override
	public ShippingResponseDTO updateById(int shippingId, ShippingRequestDTO shippingRequestDTO) {
		// TODO Auto-generated method stub
		ShippingResponseDTO shippingResponseDTO = new ShippingResponseDTO();
		Optional<Shipping> shippingOptional = shippingRepository.findById(shippingId);
		if (shippingOptional.isPresent()) {

			Shipping shipping = shippingRequestDTO.convertToModel();
			shipping.setShippingId(shippingId);
			shipping = shippingRepository.save(shipping);
			shippingResponseDTO.setPaylod(shipping);

			shippingResponseDTO.setResponseMessage("Fetched data successfully");
			shippingResponseDTO.setStatus("Sucess");
			logger.info("Sucess");
			return shippingResponseDTO;

		} else {

			shippingResponseDTO.setResponseMessage("Coud not fetch data");
			logger.error("Failed");
			shippingResponseDTO.setStatus("Failed");
			return shippingResponseDTO;
		}

	}

	@Override
	public ShippingResponseDTO deleteById(int shippingId) {
		// TODO Auto-generated method stub
		ShippingResponseDTO shippingResponseDTO = new ShippingResponseDTO();

		if (shippingRepository.existsById(shippingId) == true) {
			shippingRepository.deleteById(shippingId);
			shippingResponseDTO.setResponseMessage("Deleted successfully");
			logger.info("deleted");
			shippingResponseDTO.setStatus("Sucess");
			return shippingResponseDTO;

		} else

			shippingResponseDTO.setResponseMessage("Data not found");
		logger.error("Failure");
		shippingResponseDTO.setStatus("Failure");

		return shippingResponseDTO;
	}

	@Override
	public ShippingResponseDTO save(ShippingRequestDTO shippingRequestDTO) {
		// TODO Auto-generated method stub

		ShippingResponseDTO shippingsDTO = new ShippingResponseDTO();
		Shipping shipping = shippingRequestDTO.convertToModel();

		// shipping = new Shipping();
//		shipping.setShippingId(shippingRequestDTO.getShippingId());
//		shipping.setCustId(shippingRequestDTO.getCustId());
//		shipping.setInvoiceId(shippingRequestDTO.getInvoiceId());
//		shipping.setShipStatus(Constants.OPEN);
		// shipping.setDeliveryStatus(Constants.CONFIRMED);
		// shipping.setDeliveryStatus(shippingRequestDTO.getDeliveryStatus());
		shipping = shippingRepository.save(shipping);
		shippingsDTO.setPaylod(shipping);
		shippingsDTO.setResponseMessage("shipping data save sucessfully");
		logger.info("Sucess");
		shippingsDTO.setStatus("Sucess");
				return shippingsDTO;
	}

	@Override
	public ShippingResponseDTO findById(int shippingId) {
		// TODO Auto-generated method stub
		ShippingResponseDTO shippingResponseDTO = new ShippingResponseDTO();
		
		try {
			Optional<Shipping> shipping = shippingRepository.findById(shippingId);
			if (shipping.isPresent()) {

				shippingResponseDTO.setPaylod(shipping.get());
				shippingResponseDTO.setResponseMessage("Data is present");
				logger.info("Successfully fetched");
				shippingResponseDTO.setStatus("Sucess");
				

			} else {
				shippingResponseDTO.setResponseMessage("Data not found");
				logger.error("not found");
				shippingResponseDTO.setStatus("Failure");
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   return shippingResponseDTO;   
	}

	@Override
	public List<Shipping> findAll() {
		// TODO Auto-generated method stub
		return shippingRepository.findAll();

	}

	@Override
	public String generatePdf() throws JRException, IOException {
		// TODO Auto-generated method stub
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(shippingRepository.findAll());
		JasperReport compileReport=JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Shipping.jrxml"));
		HashMap<String, Object> map = new HashMap<>();
		JasperPrint report  =  JasperFillManager.fillReport(compileReport, map,beanCollectionDataSource);
		JasperExportManager.exportReportToPdfFile(report,"shipping.pdf");

		logger.info("shipping pdf generated");
		return "generated";
	}

	
	


}
	
	

