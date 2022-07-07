package com.bourntec.aaplearning.modules.inventorymanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.aaplearning.entity.Inventory;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.request.InventoryRequestDTO;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.response.InventoryResponseDTO;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.service.InventoryService;

/**
 * @author Allan George
 *
 */
@RestController
@RequestMapping("/inventory")  
public class InventoryController {
	
	@Autowired
	InventoryService inventoryService;
	
@GetMapping("/findall")
	public List<Inventory> findAll()
	{
		return inventoryService.findAll();
	}
	
	
	/**
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<InventoryResponseDTO> findByInventoryId(@PathVariable Integer id) {
		InventoryResponseDTO inversDTO = inventoryService.findById(id);
		return ResponseEntity.ok(inversDTO);
		}



	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<InventoryResponseDTO> deleteById(@PathVariable Integer id) {

		InventoryResponseDTO inversDTO = inventoryService.deleteById(id);
		return ResponseEntity.ok(inversDTO);

		}


	
	
	
	/**
	 * @param inventoryReqDTO
	 * @return
	 */
	@PostMapping
	public ResponseEntity<InventoryResponseDTO> save(@RequestBody InventoryRequestDTO inventoryReqDTO) 
	{
		
		InventoryResponseDTO invResponseDTO= inventoryService.save(inventoryReqDTO);
		return ResponseEntity.ok(invResponseDTO);
	}
	/**
	 * @param id
	 * @param inventoryRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<InventoryResponseDTO> updateById(@PathVariable Integer id, @RequestBody InventoryRequestDTO inventoryRequestDTO) throws Exception {

		InventoryResponseDTO inversDTO= inventoryService.updateById(id,inventoryRequestDTO);

	    return ResponseEntity.ok(inversDTO);



	}
}
