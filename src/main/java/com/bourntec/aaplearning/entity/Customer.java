package com.bourntec.aaplearning.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

/**
 * @author Sarath G Krishnan
 *
 */
@Data
@Getter
@Setter
@Entity
@Table(name = "aapcustomer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	private String name;
	private String address;
	private Integer pinCode;
	private Long phoneNumber;
	private String email;
	private String password;
	@Column(length = 1)
	private String status;
	@Column(length = 1)
	private String recordStatus;
}
