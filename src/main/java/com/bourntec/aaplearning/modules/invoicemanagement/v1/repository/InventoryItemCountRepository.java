package com.bourntec.aaplearning.modules.invoicemanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.bourntec.aaplearning.entity.Inventory;
/**
 * @author Esther Tomy
 *
 */
public interface InventoryItemCountRepository  extends JpaRepository<Inventory,Integer>,JpaSpecificationExecutor<Inventory> {

}
