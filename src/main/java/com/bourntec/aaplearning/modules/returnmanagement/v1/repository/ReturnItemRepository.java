package com.bourntec.aaplearning.modules.returnmanagement.v1.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.ReturnItem;

/**
 * @author Aryalekshmi
 *
 */
@Repository
public interface ReturnItemRepository extends JpaRepository<ReturnItem, Integer>, JpaSpecificationExecutor<ReturnItem> 
	{
		
	}
