package com.bourntec.aaplearning.entity;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class DateFields {
	
	
	    @CreatedBy
	    private String createdBy;

	    @CreatedDate
	    //@Temporal(TIMESTAMP)
	    LocalDateTime createdDate;

	    @LastModifiedBy
	    private String lastModifiedBy;

	    @LastModifiedDate
	    //@Temporal(TIMESTAMP)
	    LocalDateTime lastModifiedDate;
}
