package com.bourntec.aaplearning.modules.inventorymanagement.v1.service;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.modules.inventorymanagement.v1.request.InventoryRequestDTO;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.response.InventoryResponseDTO;


/**
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
	

}
