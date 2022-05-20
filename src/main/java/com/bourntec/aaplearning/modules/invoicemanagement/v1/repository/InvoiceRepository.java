package com.bourntec.aaplearning.modules.invoicemanagement.v1.repository;




import java.util.List;

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
//	 List<Invoice> findAll();

	 Invoice save(Invoice invoice);
//	 InvoiceResponseDTO findById(int id) throws Exception;

//	 void updateById(int id);
//	 InvoiceResponseDTO findAll();

}
