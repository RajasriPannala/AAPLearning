package com.bourntec.aaplearning.modules.merchandisemanagement.v1.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Merchandise;
import com.bourntec.aaplearning.modules.merchandisemanagement.v1.request.MerchandiseRequestDto;
import com.bourntec.aaplearning.modules.merchandisemanagement.v1.response.MerchandiseResponseDto;

/**
 * @author Aryalekshmi
 *
 */

@Service
public interface MerchandiseService {

	MerchandiseResponseDto deleteById(Integer id);
	MerchandiseResponseDto save(MerchandiseRequestDto merchandiseRequestDto);
	MerchandiseResponseDto updateById(Integer id,MerchandiseRequestDto merchandiseRequestDto) throws Exception;
	//List<MerchandiseResponseDto> findAll();
	MerchandiseResponseDto findById(Integer id);
	void downloadAsCsv();
	List<Merchandise> findAll();
}
