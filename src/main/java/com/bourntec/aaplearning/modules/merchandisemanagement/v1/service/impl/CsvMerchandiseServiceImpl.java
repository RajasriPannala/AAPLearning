package com.bourntec.aaplearning.modules.merchandisemanagement.v1.service.impl;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.entity.Merchandise;
import com.bourntec.aaplearning.modules.merchandisemanagement.v1.service.CsvMerchandiseService;


@Service
public class CsvMerchandiseServiceImpl implements CsvMerchandiseService{

	
	
	

	@Override
	public List<Merchandise> read(String fileName) throws Exception {
		List<Merchandise> mercandiseList=new ArrayList<Merchandise>();
		
		
		
		
		
			try {
				FileReader fileReader = new FileReader(fileName);
				Scanner scanner=new Scanner(fileReader);
				
				
				
				while(scanner.hasNextLine()) {
					String[] merchDetails=scanner.nextLine().split(",");
					Merchandise merchandise=new Merchandise();

					merchandise.setCustId(merchDetails[0].toString());
					merchandise.setItemCode(merchDetails[1].toString());
					merchandise.setQty(Integer.parseInt(merchDetails[2]));
					merchandise.setPrice(Double.parseDouble(merchDetails[3]));
					merchandise.setDiscount(Double.parseDouble(merchDetails[4]));
					// invoice.setStatus(invoiceDetails[6]);

					mercandiseList.add(merchandise);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		System.out.println(fileName);
		return mercandiseList;
	}




	@Override
	public void write(List<Merchandise> merchandiseList, String fileName) throws Exception {
		FileWriter file=null;
		try {
		file = new FileWriter(fileName);
		String heading = "Cust Id,Item Code,Quantity,Price,Discount,Purchase Date \n";
		file.write(heading);
		for (int i = 0; i < merchandiseList.size(); i++) {
		String data = convertTocsv(merchandiseList.get(i));
		file.write(data);}
		} catch (Exception e) {
		
		e.printStackTrace();
		
	}
		finally {
			file.close();
		}

}



	

}