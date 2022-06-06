package com.bourntec.aaplearning.modules.jwtsecurity.v1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bourntec.aaplearning.entity.ERole;
import com.bourntec.aaplearning.entity.Role;


/**
 * @author Jeena Thomas
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
  Optional<Role> findByName(ERole name);
}