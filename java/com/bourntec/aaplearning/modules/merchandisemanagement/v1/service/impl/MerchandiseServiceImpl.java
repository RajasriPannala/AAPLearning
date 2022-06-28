package com.bourntec.aaplearning.modules.merchandisemanagement.v1.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bourntec.aaplearning.entity.Merchandise;
import com.bourntec.aaplearning.modules.invoicemanagement.v1.service.CsvOperationService;
import com.bourntec.aaplearning.modules.merchandisemanagement.v1.repository.MerchandiseRepository;
import com.bourntec.aaplearning.modules.merchandisemanagement.v1.request.MerchandiseRequestDto;
import com.bourntec.aaplearning.modules.merchandisemanagement.v1.response.MerchandiseResponseDto;
import com.bourntec.aaplearning.modules.merchandisemanagement.v1.service.CsvMerchandiseService;
import com.bourntec.aaplearning.modules.merchandisemanagement.v1.service.MerchandiseService;
import com.bourntec.aaplearning.modules.merchandisemanagement.v1.util.Constant;

/**
 * @author Aryalekshmi
 *
 */

@Service
public class MerchandiseServiceImpl implements MerchandiseService {
	
	@Value("${csv.download.path}")
	String fileName;
	
	@Autowired
	CsvMerchandiseService csvMerchandiseService;
	
	@Autowired
	MerchandiseRepository merchandiseRepository;
	
	
	/**
	 * @author Aryalekshmi
	 * This API is used for delete merchandise object
	 * @param integer id
	 * @return MerchandiseResponseDto
	 *
	 */
	@Override
	public MerchandiseResponseDto deleteById(Integer id) {
		MerchandiseResponseDto resposeDto = new MerchandiseResponseDto();
		try {
			if(merchandiseRepository.existsById(id)==true) {
				merchandiseRepository.deleteById(id);
				resposeDto.setResponseMessage("successfully deleted");
				resposeDto.setStatus("Sucess");
			}else {
				resposeDto.setResponseMessage("Data not present");
				resposeDto.setStatus("Failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resposeDto;
	}
	
	
	/**
	 * @author Aryalekshmi
	 * This API is used for update merchandise object
	 * @param integer id,MerchandiseRequestDto merchandiseRequestDto
	 * @return MerchandiseResponseDto
	 *
	 */
	@Override
	public MerchandiseResponseDto updateById(Integer id, MerchandiseRequestDto merchandiseRequestDto) {
		MerchandiseResponseDto merchandiseResponseDto = new MerchandiseResponseDto(); 
		try {
			
			Optional<Merchandise> orderOptional = merchandiseRepository.findById(id);
			if (orderOptional.isPresent()) { 
				Merchandise merchandise = merchandiseRequestDto.convertToModel();
				merchandise.setId(id);
				merchandise = merchandiseRepository.save(merchandise);
				merchandiseResponseDto.setPayload(merchandise); 
				merchandiseResponseDto.setResponseMessage("Merchandise data save sucessfully");
				merchandiseResponseDto.setStatus("Sucess"); 
			} else { 
				merchandiseResponseDto.setResponseMessage("Coud not fetch data");
				merchandiseResponseDto.setStatus("Failed");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return merchandiseResponseDto;
	}


	/**
	 * @author Aryalekshmi
	 * This API is used for save merchandise object
	 * @param MerchandiseRequestDto merchandiseRequestDto
	 * @return MerchandiseResponseDto
	 *
	 */
	@Override
	public MerchandiseResponseDto save(MerchandiseRequestDto merchandiseRequestDto) {
		MerchandiseResponseDto merchandiseResponseDto = new MerchandiseResponseDto();
		try {
			Merchandise merchandise = merchandiseRequestDto.convertToModel();
			merchandise = merchandiseRepository.save(merchandise);
			merchandiseResponseDto.setPayload(merchandise);
			merchandiseResponseDto.setResponseMessage("Merchandise data save sucessfully");
			merchandiseResponseDto.setStatus("Sucess");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return merchandiseResponseDto;
	}

	/**
	 * @author Aryalekshmi
	 * This API is used for find merchandise object by id
	 * @param integer id
	 * @return MerchandiseResponseDto
	 *
	 */
	@Override
	public MerchandiseResponseDto findById(Integer id) {
		//System.out.println("id" + id);
		MerchandiseResponseDto merchandiseResponseDTO = new MerchandiseResponseDto();
		try {
			Merchandise merchandise = merchandiseRepository.findByIdAndStatus(id, Constant.ACTIVE);
			if (merchandise != null) {
				merchandiseResponseDTO.setPayload(merchandise);
				merchandiseResponseDTO.setResponseMessage("Data is present");
				merchandiseResponseDTO.setStatus("Sucess");
			} else {
				merchandiseResponseDTO.setResponseMessage("Data not found");
				merchandiseResponseDTO.setStatus("Failure");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return merchandiseResponseDTO;
	}
	
	@Override
	public List<Merchandise> findAll() {
	
		return merchandiseRepository.findAll();
	}

	
	@Override
	public void downloadAsCsv() {
		try {
			csvMerchandiseService.write(findAll(), fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
