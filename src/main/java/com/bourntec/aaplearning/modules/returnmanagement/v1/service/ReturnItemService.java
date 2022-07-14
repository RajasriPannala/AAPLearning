/**
 * 
 */
package com.bourntec.aaplearning.modules.returnmanagement.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.ReturnItem;
import com.bourntec.aaplearning.modules.returnmanagement.v1.request.ReturnItemRequestDTO;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnItemResponseDTO;

/**
 * @author Aryalekshmi
 *
 */
@Service
public interface ReturnItemService {List<ReturnItem> findAll();
	ReturnItemResponseDTO  deleteById(int id);
	ReturnItemResponseDTO updateById(Integer id ,ReturnItemRequestDTO returnItemRequestDTO);
	ReturnItemResponseDTO save(ReturnItemRequestDTO returnItemRequestDTO);
	ReturnItemResponseDTO findById(int id) throws Exception;
	List<ReturnItem> getReturnItemList(int i, Integer j);
}
