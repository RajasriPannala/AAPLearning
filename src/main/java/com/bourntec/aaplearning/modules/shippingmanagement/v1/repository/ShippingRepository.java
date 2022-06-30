package com.bourntec.aaplearning.modules.shippingmanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.Shipping;

@Repository

public interface ShippingRepository extends JpaRepository<Shipping, Integer>, JpaSpecificationExecutor<Shipping> {

//	ShippingResponseDTO save(ShippingRequestDTO shippingRequestDTO);
//
//	Shipping findByShippingIdAndShipStatus(Integer shippingId, String Active);

}