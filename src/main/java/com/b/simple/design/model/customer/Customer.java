package com.b.simple.design.model.customer;

import java.math.BigDecimal;
import java.util.List;

/**
 * Client Model API.
 */
public interface Customer {

	long getId();

	String getName();

	Enum<?> getType();

	List<Collateral> getCollaterals();

	List<Product> getProducts();

	void setProductAmount(BigDecimal productAmount);

	BigDecimal getProductAmount();

}
