package com.bourntec.aaplearning.modules.paymentmanagement.v1.search;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class GenericSpecification<T> implements Specification<T> {

	private SimpleDateFormat localeIta = new SimpleDateFormat("dd/MM/yyyy");
	// private List<SearchCriteria> list;
	private List<SearchCriteria> list;

	public GenericSpecification() {
		this.list = new ArrayList<>();
	}

	public GenericSpecification(SearchCriteria searchRequest) {

	}

	public void add(SearchCriteria criteria) {
		list.add(criteria);
	}

	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

		List<Predicate> predicates = new ArrayList<>();

		// add add criteria to predicates
		for (SearchCriteria criteria : list) {
			if (criteria.getOperation().equals(SearchOperations.GREATER_THAN)) {
				predicates.add(builder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
			} else if (criteria.getOperation().equals(SearchOperations.LESS_THAN)) {
				predicates.add(builder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
			} else if (criteria.getOperation().equals(SearchOperations.GREATER_THAN_EQUAL)) {
				predicates
						.add(builder.greaterThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
			} else if (criteria.getOperation().equals(SearchOperations.LESS_THAN_EQUAL)) {
				predicates.add(builder.lessThanOrEqualTo(root.get(criteria.getKey()), criteria.getValue().toString()));
			} else if (criteria.getOperation().equals(SearchOperations.NOT_EQUAL)) {
				predicates.add(builder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
			} else if (criteria.getOperation().equals(SearchOperations.EQUAL)) {
				predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
			} else if (criteria.getOperation().equals(SearchOperations.MATCH)) {
				predicates.add(builder.like(builder.lower(root.get(criteria.getKey())),
						"%" + criteria.getValue().toString().toLowerCase() + "%"));
			} else if (criteria.getOperation().equals(SearchOperations.MATCH_END)) {
				predicates.add(builder.like(builder.lower(root.get(criteria.getKey())),
						criteria.getValue().toString().toLowerCase() + "%"));
			}
			/* else if (criteria.getOperation().equals(SearchOperations.BETWEEN_DATE)) {
					predicates.add(builder.like(builder.lower(root.get(criteria.getKey())),
							criteria.getValue().toString().toLowerCase() + "%"));
		}*/
			
		}
		return builder.and(predicates.toArray(new Predicate[0]));
	}

	
	
	
	
	
	
	
	
	
	/*SearchRequest searchRequest;

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
		/*default:
			return null;
		}
	}*/


	
}
