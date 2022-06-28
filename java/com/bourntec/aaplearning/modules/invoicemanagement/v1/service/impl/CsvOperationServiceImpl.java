package com.bourntec.aaplearning.modules.invoicemanagement.v1.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.InvoiceResponseDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.CsvOperationService;


@Service
public class CsvOperationServiceImpl implements CsvOperationService{

	@Override
	public List<Invoice> read(String fileName) throws Exception {
		List<Invoice> invoiceList=new ArrayList<Invoice>();
		try {
		FileReader fileReader = new FileReader(fileName);
		Scanner scanner=new Scanner(fileReader); 
		while(scanner.hasNextLine()) {
		String[] invoiceDetails=scanner.nextLine().split(",");
		Invoice invoice=new Invoice();
		
//		invoice.setInvoiceId(Integer.parseInt(invoiceDetails[0]));
		invoice.setCustId(Integer.parseInt(invoiceDetails[0]));
		invoice.setOrderId(Integer.parseInt(invoiceDetails[1]));
		invoice.setItemCode(Integer.parseInt(invoiceDetails[2]));
		invoice.setInvAmnt(Integer.parseInt(invoiceDetails[3]));
		invoice.setPaidAmnt(Integer.parseInt(invoiceDetails[4]));
		invoice.setRetAmnt(Integer.parseInt(invoiceDetails[5]));
//		invoice.setStatus(invoiceDetails[6]);
		
		
		
		
		invoiceList.add(invoice);

		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(fileName);
		return invoiceList;
	}

	

	@Override
	public void write(List<Invoice> invoiceList, String fileName) throws Exception {
		FileWriter file=null;
		try {
		file = new FileWriter(fileName);
		for (int i = 0; i < invoiceList.size(); i++) {
		String data = convertTocsv(invoiceList.get(i));
		file.write(data);}
		} catch (Exception e) {
		
		e.printStackTrace();
		
	}
		finally {
			file.close();
		}

}

}



	
	
