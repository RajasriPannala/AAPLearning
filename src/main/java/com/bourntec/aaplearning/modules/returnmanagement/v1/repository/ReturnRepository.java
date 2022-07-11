package com.bourntec.aaplearning.modules.returnmanagement.v1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.Return;

/**
 * @author Rohini P M
 *
 */
@Repository
public interface ReturnRepository extends JpaRepository<Return, Integer>, JpaSpecificationExecutor<Return> {
	
//List<Return> findAll();


Return save(Return returnManagement);



Optional<Return> findById(int id);


}
