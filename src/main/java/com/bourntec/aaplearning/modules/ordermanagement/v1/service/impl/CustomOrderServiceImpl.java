//package com.bourntec.aaplearning.modules.ordermanagement.v1.service.impl;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.bourntec.aaplearning.entity.Inventory;
//import com.bourntec.aaplearning.entity.OrderData;
//import com.bourntec.aaplearning.modules.ordermanagement.v1.repository.CustomInventoryRepository;
//import com.bourntec.aaplearning.modules.ordermanagement.v1.repository.CustomOrderRepository;
//import com.bourntec.aaplearning.modules.ordermanagement.v1.service.CustomOrderService;
//
//
//@Service
////@Primary
//public class CustomOrderServiceImpl implements CustomOrderService {
//
//	@Autowired
//	CustomOrderRepository customOrderRepository;
//
//	@Autowired
//	CustomInventoryRepository customInventoryRepository;
//
//	@Override
//	public Integer getTotalPrice(Integer orderId) {
//		Integer total = 0;
//		Optional<OrderData> orderDataList = customOrderRepository.findById(orderId);
//		List<Inventory> inventoryList = customInventoryRepository.findAll();
////		for (int i = 0; i < orderDataList.size(); i++) {
//
//			Integer currentItemCode = orderDataList.get().getItemCode();
//			Integer currentItemPrice = searchItemCodePrice(inventoryList, currentItemCode);
//
//			if (currentItemPrice > 0) {
//				total = total + currentItemPrice * orderDataList.get().getItemcount();
////			}
//		}
//		return total;
//	}
//
//	private Integer searchItemCodePrice(List<Inventory> inventoryList, Integer itemCode) {
//
//		Integer price = 0;
//
//		for (int i = 0; i < inventoryList.size(); i++) {
//
//			Inventory currentInventory = inventoryList.get(i);
//			if (itemCode == currentInventory.getItemCode()) {
//				return currentInventory.getPrice();
//			}
//		}
//		return 0;
//	}
//}
