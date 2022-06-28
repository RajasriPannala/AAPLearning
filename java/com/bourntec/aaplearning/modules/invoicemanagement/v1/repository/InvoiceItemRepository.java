package com.bourntec.aaplearning.modules.invoicemanagement.v1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.entity.InvoiceItem;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.InvoiceItemRequestDto;

/**
 * @author Jeena Thomas
 *
 */
@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Integer>,JpaSpecificationExecutor<InvoiceItem>,PagingAndSortingRepository<InvoiceItem, Integer> {

	InvoiceItem save(List<InvoiceItem> invoiceItemList);

	

	Optional<InvoiceItem> findById(Integer Id);


}
