package com.bourntec.aaplearning.modules.inventorymanagement.v1.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntityDTO {
	
	
	private String id;
    private String name;
    private Long size;
    private String url;
    private String contentType;

}
