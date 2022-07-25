package com.bourntec.aaplearning.modules.returnmanagement.v1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.InvoiceItem;
import com.bourntec.aaplearning.entity.ReturnItem;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.CustomInvoiceItemResponseDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnListResponseDTO;

/**
 * @author Aryalekshmi
 *
 */
@Repository
public interface ReturnItemRepository extends JpaRepository<ReturnItem, Integer>, JpaSpecificationExecutor<ReturnItem> 
	{
	ReturnItem save(ReturnListResponseDTO invResponseDTO);
		
	}
