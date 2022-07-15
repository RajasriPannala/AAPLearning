
package com.bourntec.aaplearning.modules.merchandisemanagement.v1.service;

import java.util.List;

import com.bourntec.aaplearning.entity.Merchandise;

/**
 * @author Aryalekshmi
 *
 */
public interface CsvMerchandiseService {

List<Merchandise> read(String fileName) throws Exception;
	
	void write(List<Merchandise> merchandiseList, String fileName) throws Exception;
	default String convertTocsv(Merchandise merchandise) {



		return new StringBuffer (merchandise.getCustId()).append(",")
		.append(merchandise.getItemCode()).append(",").append(merchandise.getQty()).append(",").append(merchandise.getPrice()).append(",")
		.append(merchandise.getDiscount()).append(merchandise.getPurchaseDate()).append("\n").toString();



		}

}
