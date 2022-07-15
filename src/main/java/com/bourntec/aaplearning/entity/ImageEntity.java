package com.bourntec.aaplearning.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageEntity {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	private String id;

    private String name;

    private String contentType;

    private Long size;

    @Lob
    private byte[] data;//oid (refr to image of another table)
    
    private String inventoryId;
    
  
    
//   @JoinColumn(name = "inventory_id")
//	@ManyToOne(fetch = FetchType.EAGER)
//	private Inventory inventoryid;
    
    

}
