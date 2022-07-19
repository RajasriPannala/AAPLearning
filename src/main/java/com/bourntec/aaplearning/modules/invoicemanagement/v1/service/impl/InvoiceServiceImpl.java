package com.bourntec.aaplearning.modules.invoicemanagement.v1.service.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.entity.SortList;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.repository.InvoiceRepository;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.CustomRequestDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceDateSearchDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceRequestDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceItemResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.CsvOperationService;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.InvoiceService;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.util.Constants;

/**
 * @author Esther Tomy
 *
 */
@Service

public class InvoiceServiceImpl implements InvoiceService {
	@Value("${csv.download.path}")

	String fileName;

	@Autowired
	InvoiceRepository invoiceRepository;
	Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);

	@Autowired
	CsvOperationService csvOperationService;

	@Override
	public List<Invoice> findAll() {

		return invoiceRepository.findAll();
	}
//	

	/**
	 * delete invoice using invoice id
	 */

	@Override
	public InvoiceResponseDTO deleteById(int id) {
		InvoiceResponseDTO invoiceResponseDTO = new InvoiceResponseDTO();

		if (invoiceRepository.existsById(id) == true) {
			invoiceRepository.deleteById(id);
			invoiceResponseDTO.setResponsemessage("Deleted successfully");
			invoiceResponseDTO.setStatus("Sucess");
			logger.info("deleted");
			return invoiceResponseDTO;

		} else

			invoiceResponseDTO.setResponsemessage("Data not found");
		invoiceResponseDTO.setStatus("Failure");
		logger.error("User Not Found");
		return invoiceResponseDTO;

	}

	/**
	 * save invoice details
	 */
	@Override

	public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {
		InvoiceResponseDTO invresDTO = new InvoiceResponseDTO();

		Invoice invoice = invoiceRequestDTO.converToModel();
		invoice.setStatus(Constants.ACTIVE);
		invoice = invoiceRepository.save(invoice);
		invresDTO.setPayload(invoice);
		invresDTO.setResponsemessage(" data save sucessfully");
		invresDTO.setStatus("Sucess");
		logger.info("data saved successfully");
		return invresDTO;
	}

	/**
	 * update invoice details
	 */

	@Transactional(rollbackFor = Exception.class)
	public InvoiceResponseDTO updateById(Integer id, InvoiceRequestDTO invoiceRequestDTO) {
		// order.setId(id);
		InvoiceResponseDTO invresDTO = new InvoiceResponseDTO();
		Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
		invoiceOptional.get();
		if (invoiceOptional.isPresent()) {

			Invoice invoice = invoiceRequestDTO.converToModel();
//		Invoice existinginvoice = invoiceOptional.get();

			invoice.setInvoiceId(id);

			invoiceRepository.save(invoice);
			invresDTO.setPayload(invoice);
			invresDTO.setResponsemessage(" data save sucessfully");
			invresDTO.setStatus("Sucess");
			logger.info("data updated");
			return invresDTO;
		} else

			invresDTO.setResponsemessage(" id not present");
		invresDTO.setStatus("failed");
		logger.error("User Not Found");
		return invresDTO;

	}

	/**
	 * find invoice using id
	 */
	@Override
	public InvoiceResponseDTO findById(int id) throws Exception {

		InvoiceResponseDTO invresDTO = new InvoiceResponseDTO();
		Optional<Invoice> invoiceOptional = invoiceRepository.findById(id);
		if (invoiceOptional.isPresent()) {

			invresDTO.setPayload(invoiceOptional.get());
			invresDTO.setResponsemessage(" data got sucessfully");
			logger.info("Successfully fetched");
			invresDTO.setStatus("Sucess");
			return invresDTO;

		} else {
			invresDTO.setResponsemessage(" Given id does not exists");
			invresDTO.setStatus("failed");
			logger.error("User Not Found");
			return invresDTO;
		}
	}

	@Override
	public void downloadAsCsv() {
		try {
			csvOperationService.write(findAll(), fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * paging and sorting
	 */

	public List<Invoice> getInvoiceList(int pageNo, Integer pageSize) {

		List<Invoice> invoiceList = new ArrayList<Invoice>();
		Sort custIdsort = Sort.by("custId").descending();
		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<Invoice> pagedResult = invoiceRepository.findAll(paging);

		System.out.println("total element.... " + pagedResult.getTotalElements());
		System.out.println("total pages.... " + pagedResult.getTotalPages());
		System.out.println("current page.... " + pagedResult.getNumber());
		System.out.println("no of elements in a page.... " + pagedResult.getNumberOfElements());
		if (pagedResult.hasContent()) {
			invoiceList = pagedResult.getContent();
			return pagedResult.getContent();
		} else {
			return invoiceList;
		}
	}
	

	@Override
	public Page<Invoice> pagingFilteringAndSortingInvoicesByItemCode(CustomRequestDTO customRequestDTO) {
		List<SortList> sortList=customRequestDTO.getSort();
		List<Sort.Order> sorts= new ArrayList<>();
		for(SortList so:sortList) {

		String sort = null;
		if ((so.getOrderd()).equals("decending"))
		{
			sort=so.getField();
		   sorts.add(new Sort.Order(Sort.Direction.DESC,sort));
		} else if ((so.getOrderd()).equals("acending"))
		{
			sort =so.getField();
		  sorts.add(new Sort.Order(Sort.Direction.ASC,sort));
		}
	
			}
		System.out.println(sorts);
		Pageable requestedPage =PageRequest.of(customRequestDTO.getPage(),customRequestDTO.getSize() , Sort.by(sorts));
		return invoiceRepository.findAll(requestedPage);
	
	}

	
	@Override
	public InvoiceResponseDTO getInvoiceDetails(InvoiceDateSearchDTO invoiceDateSearchDTO) throws ParseException {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		InvoiceResponseDTO invresDTO = new InvoiceResponseDTO();
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		
		
		String from=invoiceDateSearchDTO.getStartDate();
		String to=invoiceDateSearchDTO.getEndDate();
		LocalDate date1 = LocalDate.parse(from, dtf);
		LocalDate date = LocalDate.parse(to, dtf);       
        Integer custId=invoiceDateSearchDTO.getCustId();
        List<Invoice> invoiceMasterList =
        		invoiceRepository.findAll();
     
     for(Invoice so:invoiceMasterList) {

    	 if(so.getOrderDate()!=null) 
    	 {
    	 if(so.getCustId().equals(custId) && so.getOrderDate().compareTo(date1) >= 0 && so.getOrderDate().compareTo(date) <=0)
    	 {
    		 invoiceList.add(so);
    	
   		 
    	 }
    	 }
     } 
   invresDTO.setPayload(invoiceList);
	return invresDTO;
		
	}

	




}
