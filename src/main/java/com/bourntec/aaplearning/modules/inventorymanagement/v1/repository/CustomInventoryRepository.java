package com.bourntec.aaplearning.modules.inventorymanagement.v1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bourntec.aaplearning.entity.ImageEntity;

public interface CustomInventoryRepository  extends JpaRepository<ImageEntity, String>{

	Optional<ImageEntity> findById(String id);
	
}