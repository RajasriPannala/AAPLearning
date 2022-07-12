package com.bourntec.aaplearning.modules.invoicemanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.Invoice;

/**
 * @author Karthika J
 *
 */


/**
 * @param customInvoiceItemRequestDTO
 * @return
 */

@Repository
public interface CustomInvoiceItemRepository extends JpaRepository<Invoice,Integer>,JpaSpecificationExecutor<Invoice>{


	Invoice save(Invoice invoice);
}
