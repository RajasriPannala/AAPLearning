package com.bourntec.aaplearning.modules.promocode.v1.serviceimpl;

import java.math.BigInteger;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Customer;
import com.bourntec.aaplearning.entity.Promocode;
import com.bourntec.aaplearning.modules.paymentmanagement.v1.util.Constant;
import com.bourntec.aaplearning.modules.promocode.v1.repository.PromocodeRepository;
import com.bourntec.aaplearning.modules.promocode.v1.request.PromocodeRequestDTO;
import com.bourntec.aaplearning.modules.promocode.v1.response.PromocodeResponseDTO;
import com.bourntec.aaplearning.modules.promocode.v1.service.PromocodeService;
//import com.bourntec.aaplearning.modules.promocode.v1.util.Constants;
/**
 * @author Jeena Thomas
 *
 */
@Service
public class PromocodeServiceImpl implements PromocodeService{
	@Autowired
	PromocodeRepository promocodeRepository;
	

	@Override
	public PromocodeResponseDTO save(PromocodeRequestDTO promocodeRequestDTO) {
		// TODO Auto-generated method stub
		PromocodeResponseDTO promoDTO=new PromocodeResponseDTO();
		
		Promocode promocode = promocodeRequestDTO.converToModel();
		promocode = promocodeRepository.save(promocode);
		promoDTO.setPayload(promocode);
		promoDTO.setResponsemessage("data save sucessfully");
		promoDTO.setStatus("Success");
		return promoDTO;
	}
	@Override
	public PromocodeResponseDTO findByPromoCode(Integer promoCode) {
		// TODO Auto-generated method stub9
		 PromocodeResponseDTO promoDTO=new PromocodeResponseDTO();
		 Promocode promocode = promocodeRepository.findByPromoCode(promoCode);
		//Instant expiryDate=promocodeDTO.getExpiryDate();
		LocalDate date=promocode.getExpiryDate();
		 if (LocalDate.now(ZoneOffset.UTC).isAfter(date)) {
			 promoDTO.setResponsemessage("date is expired");  
			 promoDTO.setStatus("fail");
	        }
		 else {
			    promoDTO.setPayload(promocode);
				promoDTO.setResponsemessage("sucessfully");
				promoDTO.setStatus("Success");
		 }
		return promoDTO;
	}


//	@Override
//	public List<Promocode> findByPromoCodeAndExpiryDate(Integer promoCode, Instant expiryDate) {
//		// TODO Auto-generated method stub
//		
//		LocalDate date= expiryDate.atZone(ZoneOffset.UTC).toLocalDate();
//		return promocodeRepository. findByPromoCodeAndExpiryDate(promoCode,date);
//	}


//	@Override
//	public List<Promocode> findByPromoCodeAndTotalAmount(PromocodeRequestDTO promocodeRequestDTO) {
//		// TODO Auto-generated method stub
//		return promocodeRepository. findByPromoCodeAndTotalAmount( promocodeRequestDTO.getPromoCode(),promocodeRequestDTO.getTotalAmount());
//	}

	@Override
	public PromocodeResponseDTO findByPromoCodeAndTotalAmount(PromocodeRequestDTO promocodeRequestDTO) {
		// TODO Auto-generated method stub
        PromocodeResponseDTO promoDTO=new PromocodeResponseDTO();
        double amountToPay=0.0;
        		double totalAmount=promocodeRequestDTO.getTotalAmount();
		Promocode promocode = promocodeRequestDTO.converToModel();
		promocode= promocodeRepository. findByPromoCode( promocodeRequestDTO.getPromoCode());
	//	promocode.setStatus(Constants.VALID);
		LocalDate date=promocode.getExpiryDate();
	if((promocode.getStatus().equals("valid")) && (LocalDate.now(ZoneOffset.UTC).isBefore(date)))
	{
		if((promocodeRequestDTO.getTotalAmount() > promocode.getMinAmount()) )
    {
        amountToPay=promocodeRequestDTO.getTotalAmount() -  promocode.getDiscount();
        totalAmount=promocodeRequestDTO.getTotalAmount();
        promoDTO.setAmountToPay(amountToPay);
        promoDTO.setTotalAmount(totalAmount);
		promoDTO.setPayload(promocode);
		promoDTO.setResponsemessage("sucessfully");
		promoDTO.setStatus("Success");
}else {
//	promoDTO.setTotalAmount(totalAmount);
//	promoDTO.setPayload(promocode);
	
	promoDTO.setResponsemessage("total amount is not greater than minimum amount");
	promoDTO.setStatus("fail");
	}
	}
	else {
		promoDTO.setResponsemessage(" not valid");
		promoDTO.setStatus("fail");

	}
		return promoDTO;
	}
}
