

package com.bourntec.aaplearning.entity;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.Data;


/**
 * @author Aryalekshmi
 *
 */
@Entity
@Table(name="returnitem")
@EntityListeners(AuditingEntityListener.class)
@Data
public class ReturnItem 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private Integer returnId;
	private Integer itemCode;
	private Integer returnPrice;
}
