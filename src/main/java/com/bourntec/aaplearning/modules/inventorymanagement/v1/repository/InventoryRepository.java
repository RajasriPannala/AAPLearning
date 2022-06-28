package com.bourntec.aaplearning.modules.inventorymanagement.v1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.Inventory;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.request.InventoryRequestDTO;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.response.InventoryResponseDTO;

/**
 * @author Allan George
 *
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer>,JpaSpecificationExecutor<Inventory> {

	//List<Inventory> findAll();
	
	//Inventory findByRecordStatus(String recordStatus);
	
//	InventoryResponseDTO save(InventoryRequestDTO inventoryRequestDTO);
	
	//void deleteById(Integer id);
	
	//Optional<Inventory> findById(Integer id);
	
	
}
