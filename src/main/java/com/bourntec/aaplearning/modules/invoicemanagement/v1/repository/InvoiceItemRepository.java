package com.bourntec.aaplearning.modules.invoicemanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.InvoiceItem;

/**
 * @author Aryalekshmi
 *
 */
@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem,Integer>,JpaSpecificationExecutor<InvoiceItem>,PagingAndSortingRepository<InvoiceItem, Integer>
{

}



