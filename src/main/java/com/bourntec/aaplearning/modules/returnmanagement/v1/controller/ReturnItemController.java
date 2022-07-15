package com.bourntec.aaplearning.modules.returnmanagement.v1.controller;
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

import com.bourntec.aaplearning.entity.ReturnItem;
import com.bourntec.aaplearning.modules.returnmanagement.v1.request.ReturnItemRequestDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnItemResponseDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.service.ReturnItemService;

/**
 * @author Aryalekshmi
 *
 */
@RestController 
@RequestMapping("/returnitem")
public class ReturnItemController 
{
		@Autowired
		ReturnItemService returnItemService;
		/**
		 * @return
		 */
		@GetMapping
		public List<ReturnItem> getAll(){
			return  returnItemService.findAll();
		}
		/**
		 * @param returnId
		 */
		@DeleteMapping("/{id}")
		public ReturnItemResponseDTO delete(@PathVariable int id) {
			return returnItemService.deleteById(id);
		}
		/**
		 * @param id
		 * @param return
		 * @throws Exception
		 */
		@PutMapping("/{returnitemId}")
		public ReturnItemResponseDTO updateById(@PathVariable Integer returnitemId, @RequestBody ReturnItemRequestDTO returnitemRequestDTO) throws Exception {
			return returnItemService.updateById(returnitemId,returnitemRequestDTO);
		}
		/**
		 * @param return
		 * @return
		 */
		@PostMapping
		public ResponseEntity<ReturnItemResponseDTO> save(@RequestBody ReturnItemRequestDTO returnitemRequestDTO){
			ReturnItemResponseDTO returnitemResDTO=returnItemService.save(returnitemRequestDTO);
			return ResponseEntity.ok(returnitemResDTO);
		}
		/**
		 * @param id
		 * @return
		 * @throws Exception
		 */
		@GetMapping("/{id}")
		public ReturnItemResponseDTO get(@PathVariable int id) throws Exception {
			return returnItemService.findById(id);
		}
		/**
		 * @param pageNo
		 * @param pageSize
		 * @return
		 */
		@GetMapping("/returnitem/{pageNo}")
		public List<ReturnItem> getReturnItemList(@PathVariable("pageNo")int pageNo, Integer pageSize)	{
			pageSize=5;
			List<ReturnItem> returnitem = returnItemService.getReturnItemList(pageNo-1,pageSize);
			return returnitem;

		}
}