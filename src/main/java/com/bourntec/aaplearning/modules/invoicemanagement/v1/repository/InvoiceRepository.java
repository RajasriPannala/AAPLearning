package com.bourntec.aaplearning.modules.invoicemanagement.v1.repository;




import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

//import com.bourntec.AAPLearning.request.InvoiceRequestDTO;
//import com.bourntec.aap.response.InvoiceResponseDTO;
import com.bourntec.aaplearning.entity.Invoice;



/**
 * @author Esther Tomy
 *
 */
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer>,JpaSpecificationExecutor<Invoice>,PagingAndSortingRepository<Invoice, Integer>{

	 Invoice save(Invoice invoice);
	 
	 Page<Invoice> findAll(Pageable requestedPage);
 


}
