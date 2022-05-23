package com.bourntec.aaplearning.modules.paymentmanagement.v1.search;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecification<T> implements Specification<T> {

	SearchRequest searchRequest;

	public GenericSpecification(SearchRequest searchRequest) {
		this.searchRequest = searchRequest;

	}

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		switch (searchRequest.getOperation()) {

		case EQUALS:
			return criteriaBuilder.equal(root.get(searchRequest.getField()), searchRequest.getValue());

		case GREATER_THAN:
			return criteriaBuilder.greaterThan(root.get(searchRequest.getField()), searchRequest.getValue());

		case LESS_THAN:
			return criteriaBuilder.lessThan(root.get(searchRequest.getField()), searchRequest.getValue());

		case GREATER_THAN_OR_EQUALS:
			return criteriaBuilder.greaterThanOrEqualTo(root.get(searchRequest.getField()), searchRequest.getValue());

		case LESS_THAN_OR_EQUALS:
			return criteriaBuilder.lessThanOrEqualTo(root.get(searchRequest.getField()), searchRequest.getValue());

		case LIKE:
			return criteriaBuilder.like(root.get(searchRequest.getField()),"%" + searchRequest.getValue() + "%");
			
		/*case MAX:
			return criteriaBuilder.maximum(root.get(searchRequest.getField()));
*/
		default:
			return null;
		}
	}


	
}
