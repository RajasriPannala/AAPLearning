package com.bourntec.aaplearning.modules.inventorymanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Inventory;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.repository.InventoryRepository;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.request.InventoryRequestDTO;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.response.InventoryResponseDTO;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.service.InventoryService;

/**
 * @author Allan George
 *
 */
@Service
public class InventoryServiceImpl implements InventoryService {

	
	@Autowired
	InventoryRepository inventoryRepository;

	
	@Override
	public InventoryResponseDTO findById(Integer id) {




	InventoryResponseDTO inventoryResponseDTO = new InventoryResponseDTO();
	Optional<Inventory> inventory = inventoryRepository.findById(id);
	if (inventory != null) {



	inventoryResponseDTO.setPaylod(inventory);
	inventoryResponseDTO.setResponseMessage("Data is present");
	inventoryResponseDTO.setStatus("Sucess");



	
	} else {
		inventoryResponseDTO.setResponseMessage("Data not found");
		inventoryResponseDTO.setStatus("Failure");



	}
	return inventoryResponseDTO;
	}

	/* (non-Javadoc)
	 * @see com.bourntec.aap.service.InventoryService#save(com.bourntec.aap.request.InventoryRequestDTO)
	 */
	@Override
	public InventoryResponseDTO save(InventoryRequestDTO inventoryRequestDTO) {
		
		InventoryResponseDTO invresDTO=new InventoryResponseDTO();
		
		Inventory inventory = inventoryRequestDTO.convertToModel();
		inventory = inventoryRepository.save(inventory);
		invresDTO.setPaylod(inventory);
		invresDTO.setResponseMessage("Payment data save sucessfully");
		invresDTO.setStatus("Success");
		return invresDTO;
	}

	/* (non-Javadoc)
	 * @see com.bourntec.aap.service.InventoryService#deleteById(java.lang.Integer)
	 */
	@Override
	public InventoryResponseDTO deleteById(Integer id) {
		
		InventoryResponseDTO inventoryResponseDTO = new InventoryResponseDTO();



		if (inventoryRepository.existsById(id) == true) {
		inventoryRepository.deleteById(id);
		inventoryResponseDTO.setResponseMessage("Deleted successfully");



		inventoryResponseDTO.setStatus("Sucess");
		return inventoryResponseDTO;



		} else



			inventoryResponseDTO.setResponseMessage("Data not found");
		inventoryResponseDTO.setStatus("Failure");
		return inventoryResponseDTO;
	}

	
	@Override
	public InventoryResponseDTO updateById(Integer id, InventoryRequestDTO inventoryRequestDTO) {
		
		InventoryResponseDTO invresDTO = new InventoryResponseDTO();



		Optional<Inventory> inventoryOptional = inventoryRepository.findById(id);
		if (inventoryOptional.isPresent()) {



			Inventory inventory = inventoryRequestDTO.convertToModel();
			inventory.setId(id);
			inventory = inventoryRepository.save(inventory);
		invresDTO.setPaylod(inventory);



		invresDTO.setResponseMessage("Fetched data successfully");
		invresDTO.setStatus("Sucess");



		return invresDTO;



		} else {



			invresDTO.setResponseMessage("Coud not fetch data");
			invresDTO.setStatus("Failed");
		return invresDTO;
	}

	
		

	
	}

	@Override
	public List<Inventory> findAll() {
		
		
		return inventoryRepository.findAll();
	}
}