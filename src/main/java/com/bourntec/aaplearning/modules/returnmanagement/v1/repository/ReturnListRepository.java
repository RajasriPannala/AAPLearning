package com.bourntec.aaplearning.modules.returnmanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.ReturnList;
import com.bourntec.aaplearning.modules.returnmanagement.v1.response.ReturnListResponseDTO;


/**
 * @author Sarath G Krishnan
 *
 */
@Repository
public interface ReturnListRepository extends JpaRepository<ReturnList,Integer>,JpaSpecificationExecutor<ReturnList> {

	/**
	 * @param returnDTO
	 * @return
	 */
	ReturnList  save(ReturnListResponseDTO returnDTO);
}
