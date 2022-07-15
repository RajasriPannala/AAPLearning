package com.bourntec.aaplearning.modules.invoicemanagement.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.InvoiceItem;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceItemRequestDTO;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.response.CustomInvoiceItemResponseDTO;
/**
 * @author Aryalekshmi
 *
 */
@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Integer>,JpaSpecificationExecutor<InvoiceItem>,PagingAndSortingRepository<InvoiceItem, Integer>
{
//List<InvoiceItemRequestDTO> findAll(InvoiceItemRequestDTO invoiceItemRequestDTO);
	InvoiceItem save(CustomInvoiceItemResponseDTO invResponseDTO);

}



