package com.b.simple.design.model.customer;

/**
 * Available types of customers
 */
public enum ProductType {
	LOAN("LN"), KREDIT("KRD"), BANK_GUARANTEE("BG");

	private final String textValue;

	ProductType(final String textValue) {
		this.textValue = textValue;
	}

	@Override
	public String toString() {
		return textValue;
	}
}