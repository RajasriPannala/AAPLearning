package com.bourntec.aaplearning.modules.invoicemanagement.v1.repository;




import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

//import com.bourntec.AAPLearning.request.InvoiceRequestDTO;
//import com.bourntec.aap.response.InvoiceResponseDTO;
import com.bourntec.aaplearning.entity.Invoice;
import com.bourntec.aaplearning.entity.InvoiceItem;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.request.CustomRequestDTO;



/**
 * @author Esther Tomy
 *
 */
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Integer>,JpaSpecificationExecutor<Invoice>,PagingAndSortingRepository<Invoice, Integer>{
	// List<InvoiceItem> findAll();

	 InvoiceItem save(InvoiceItem invoice);
// InvoiceResponseDTO findById(int id);

	// Invoice save(InvoiceRequestDto invoice);

//	 void updateById(int id);
//	 InvoiceResponseDTO findAll();
	// Invoice saveInvoice(InvoiceItemRequestDto invoice);

	 Page<Invoice> pagingFilteringAndSortingInvoicesByItemCode(CustomRequestDTO customRequestDTO);
}
