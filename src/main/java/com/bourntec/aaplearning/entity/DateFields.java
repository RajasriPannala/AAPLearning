package com.bourntec.aaplearning.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;

import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)


public class DateFields {
	
	    @CreatedBy
	    private String createdBy;

	    @CreatedDate
	    @Column(name="created_date",nullable = false, updatable=false)

//	    
	    @JsonSerialize(using = LocalDateTimeSerializer.class)
	    @JsonDeserialize(using = LocalDateTimeDeserializer.class)

	    @JsonFormat( pattern = "yyyy-MM-dd")
	    

	    LocalDateTime createdDate;

	    @LastModifiedBy
	    private String lastModifiedBy;

	    @LastModifiedDate
	    @JsonSerialize(using = LocalDateTimeSerializer.class)
	    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
	    LocalDateTime lastModifiedDate;
}
