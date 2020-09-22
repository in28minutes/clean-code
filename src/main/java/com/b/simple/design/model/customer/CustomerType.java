package com.b.simple.design.model.customer;

import java.util.Arrays;
import java.util.List;

/**
 * Available types of customers
 */
public enum CustomerType {
	/**
     * 
     */
	PRIVATE("P"),
	/**
     * 
     */
	BUSINESS("Z");

	private final String textValue;

	/**
	 * List of natural person types.
	 */
	public static final List<String> NATURAL_PERSON_TYPES = Arrays
			.asList(CustomerType.PRIVATE.toString());

	/**
	 * List of corporate types.
	 */
	public static final List<String> CORPORATE_TYPES = Arrays
			.asList(CustomerType.BUSINESS.toString());

	CustomerType(final String textValue) {
		this.textValue = textValue;
	}

	@Override
	public String toString() {
		return textValue;
	}
}
