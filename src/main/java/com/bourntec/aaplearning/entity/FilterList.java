package com.bourntec.aaplearning.entity;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.expression.spel.ast.Operator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterList {

	   private String key;

	    private Operator operator;

	    private FieldType fieldType;

	    private transient Object value;

	    private transient Object valueTo;

	    private transient List<Object> values;

}
