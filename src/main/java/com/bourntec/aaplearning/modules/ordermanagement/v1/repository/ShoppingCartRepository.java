package com.bourntec.aaplearning.modules.ordermanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.ShoppingCart;

/**
 * @author Aryalekshmi
 *
 */
@Repository

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>, JpaSpecificationExecutor<ShoppingCart> {

		
}
