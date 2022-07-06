package com.bourntec.aaplearning.modules.promocode.v1.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.Promocode;
import com.bourntec.aaplearning.modules.promocode.v1.request.PromocodeRequestDTO;

@Repository
public interface PromocodeRepository extends JpaRepository<Promocode,Integer>,JpaSpecificationExecutor<Promocode>,PagingAndSortingRepository<Promocode, Integer>{

	Promocode save(Promocode promocode);
	 
	//@Query(value="select p.* from promocode as p where p.promo_code= :promoCode and p.expiry_date= :expiryDate", nativeQuery = true)
	//List<Promocode> findByPromoCodeAndDate(Integer promoCode, LocalDate expiryDate);

	//List<Promocode> findByPromoCodeAndExpiryDate(Integer promoCode, Instant expiryDate);
	//List<Promocode> findByPromoCode(Integer promoCode);
	//List<Promocode> findByPromoCodeAndExpiryDate(Integer promoCode, LocalDate expiryDate);
	//select * from promocode where promo_code=1 and status='valid' and total_amount > min_amount;
	//@Query(value="select p.* from promocode as p  where p.promo_code= :promoCode and :totalAmount > p.min_amount", nativeQuery = true)
	Promocode findByPromoCode(Integer promoCode);
	//List<Promocode> findByPromoCodeAndTotalAmount(Integer promoCode, Integer totalAmount);
	//select p.* from promocode as p  where p.promo_code= :promoCode and p.status='V' and  :totalAmount > p.min_amount

	//PromocodeRequestDTO findByPromoCodeAndTotalAmount(PromocodeRequestDTO promocodeRequestDTO);
}
