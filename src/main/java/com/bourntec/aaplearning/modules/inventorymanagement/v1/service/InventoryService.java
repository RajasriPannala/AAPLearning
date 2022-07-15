package com.bourntec.aaplearning.modules.inventorymanagement.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Inventory;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.request.InventoryRequestDTO;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.response.InventoryResponseDTO;


/**
 * 
 * @author Allan George
 *
 */
@Service
public interface InventoryService {
	
	InventoryResponseDTO deleteById(Integer id);
	
	//Inventory findByRecordStatus(String recordStatus);
	
	InventoryResponseDTO save(InventoryRequestDTO inventoryRequestDTO);
	
	InventoryResponseDTO findById(Integer id);
	
	InventoryResponseDTO updateById(Integer id,InventoryRequestDTO inventoryRequestDTO);

	List<Inventory> findAll();
	

	Page<Inventory> sortingAndFilteringInventoryDetails(CustomRequestDTO customRequestDTO);
}
