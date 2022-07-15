package com.bourntec.aaplearning.modules.inventorymanagement.v1.service.impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bourntec.aaplearning.entity.ImageEntity;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.repository.CustomInventoryRepository;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.service.InventoryCustomService;

@Service
public class InventoryCustomServiceImpl implements InventoryCustomService {

	@Autowired
	CustomInventoryRepository customInventoryRepo;

	@Override
	public void save(MultipartFile file, String id) throws IOException {

		ImageEntity fileEntity = new ImageEntity();
		fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
		fileEntity.setContentType(file.getContentType());
		fileEntity.setData(file.getBytes());
		fileEntity.setInventoryId(id);
		System.out.println("Data Bytes" + file.getBytes());
		fileEntity.setSize(file.getSize());

		customInventoryRepo.save(fileEntity);

	}

	

	@Override
	public ImageEntity uploadFile(MultipartFile file, String id) throws IOException {

		ImageEntity fileEntity = new ImageEntity();
		fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
		fileEntity.setContentType(file.getContentType());
		fileEntity.setData(file.getBytes());
		fileEntity.setInventoryId(id);
		fileEntity.setSize(file.getSize());

		return customInventoryRepo.save(fileEntity);

	}



	public Optional<ImageEntity> findById(String id) {
		return customInventoryRepo.findById(id);
	}
	
	 public List<ImageEntity> getAllFiles() {
	        return customInventoryRepo.findAll();
	    }
	 
		
}
//public ImageEntity uploadFileWithHeightAndWidth(MultipartFile file, String id, Integer height, Integer width)
//throws IOException {
//
//Integer h = 140;
//Integer w = 140;
//ImageEntity fileEntity = new ImageEntity();
//fileEntity.setName(StringUtils.cleanPath(file.getOriginalFilename()));
//fileEntity.setContentType(file.getContentType());
//fileEntity.setData(file.getBytes());
//fileEntity.setInventoryId(id);
//fileEntity.setHeight(height);
//fileEntity.setWidth(width);
//fileEntity.setSize(file.getSize());
//// if(fileEntity.getHeight() && fileEntity.getWidth()
//// >fileEntity.setHeight(height) && fileEntity.setWidth(width))
//if (fileEntity.getHeight() > h && fileEntity.getWidth() > w) {
//fileEntity.setMessage("please resize the image");
//}
//return customInventoryRepo.save(fileEntity);
//
//}