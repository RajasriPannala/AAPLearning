package com.bourntec.aaplearning.modules.inventorymanagement.v1.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bourntec.aaplearning.entity.ImageEntity;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.response.ImageEntityDTO;
import com.bourntec.aaplearning.modules.inventorymanagement.v1.service.InventoryCustomService;



/**
 * @author Sandra Diraj
 *
 */
@RestController
@RequestMapping("/inventorycustom")
public class CustomInventoryController {
	
	
	@Autowired
	InventoryCustomService inventoryService;
	

/**
 * @param id ,this will  return a string message
 * To upload or save an image to db through postman
 * passing inventory id
 *
 */

	 @PostMapping("/upload/{id}")
	    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file,@PathVariable String id) {
	        try {
	        	
	        	inventoryService.save(file,id);

	            return ResponseEntity.status(HttpStatus.OK)
	                                 .body(String.format("File uploaded successfully: %s", file.getOriginalFilename()));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                                 .body(String.format("Could not upload the file: %s!", file.getOriginalFilename()));
	        }
	 }
	 
	 /**
	  * @param id ,this will  return a the entity class 
	  * To upload or save an image to db through postman
	  * passing inventory id
	  *
	  */
	 @PostMapping("/{id}")
	        public ImageEntity uploadFile( @RequestParam("file") MultipartFile file, @PathVariable String id) throws IOException
	        {
	        	return inventoryService.uploadFile(file,id);
				

	           
	    }
	 /**
	  * find by id method
	  * 
	  *
	  */
	
	 @GetMapping("{id}")
	    public ResponseEntity<byte[]> findById(@PathVariable String id) {
	        Optional<ImageEntity> fileEntityOptional = inventoryService.findById(id);

	        if (!fileEntityOptional.isPresent()) {
	            return ResponseEntity.notFound()
	                                 .build();
	        }

	        ImageEntity fileEntity = fileEntityOptional.get();
	        return ResponseEntity.ok()
	                             .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileEntity.getName() + "\"")
	                             .contentType(MediaType.valueOf(fileEntity.getContentType()))
	                             .body(fileEntity.getData());
	    }
/*
 * get all images
 */

	    @GetMapping
	    public List<ImageEntityDTO> list() {
	        return inventoryService.getAllFiles()
	                          .stream()
	                          .map(this::mapToFileDTO)
	                          .collect(Collectors.toList());
	    }

	    private ImageEntityDTO mapToFileDTO(ImageEntity fileEntity) {
	        String downloadURL = ServletUriComponentsBuilder.fromCurrentContextPath()
	                                                        .path("/files/")
	                                                        .path(fileEntity.getId())
	                                                        .toUriString();
	        ImageEntityDTO fileResponse = new ImageEntityDTO();
	        fileResponse.setId(fileEntity.getId());
	        fileResponse.setName(fileEntity.getName());
	        fileResponse.setContentType(fileEntity.getContentType());
	        fileResponse.setSize(fileEntity.getSize());
	        fileResponse.setUrl(downloadURL);

	        return fileResponse;
	    }
	}





 