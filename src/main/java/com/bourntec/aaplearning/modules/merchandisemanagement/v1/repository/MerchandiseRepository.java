package com.bourntec.aaplearning.modules.merchandisemanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.Merchandise;



/**
 * 
 * @author Aryalekshmi
 *
 */

@Repository
public interface MerchandiseRepository extends JpaRepository<Merchandise, Integer>, JpaSpecificationExecutor<Merchandise>{
	Merchandise findByIdAndStatus(Integer id, String status);

}
