package com.bourntec.aaplearning.modules.inventorymanagement.v1.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.bourntec.aaplearning.entity.ImageEntity;

public interface InventoryCustomService {

	ImageEntity uploadFile(MultipartFile file, String id) throws IOException;

	void save(MultipartFile file, String id) throws IOException;

	Optional<ImageEntity> findById(String id);

	List<ImageEntity> getAllFiles();

}
