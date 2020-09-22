package com.b.simple.design.business.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.Amount;
import com.b.simple.design.model.customer.AmountImpl;
import com.b.simple.design.model.customer.Currency;
import com.b.simple.design.model.customer.Product;
import com.b.simple.design.model.customer.ProductImpl;
import com.b.simple.design.model.customer.ProductType;

public class CustomerBOTest {

	private CustomerBO customerBO = new CustomerBOImpl();

	@Test
	public void testCustomerProductSum_TwoProductsSameCurrencies()
			throws DifferentCurrenciesException {

		List<Product> products = new ArrayList<Product>();

		products.add(
				new ProductImpl(100, "Product 15", ProductType.BANK_GUARANTEE,
						new AmountImpl(new BigDecimal("5.0"), Currency.EURO)));

		products.add(
				new ProductImpl(120, "Product 20", ProductType.BANK_GUARANTEE,
						new AmountImpl(new BigDecimal("6.0"), Currency.EURO)));

		Amount temp = customerBO.getCustomerProductsSum(products);

		assertEquals(Currency.EURO, temp.getCurrency());
		assertEquals(new BigDecimal("11.0"), temp.getValue());
	}

	@Test
	public void testCustomerProductSum1() {

		List<Product> products = new ArrayList<Product>();

		products.add(new ProductImpl(100, "Product 15",
				ProductType.BANK_GUARANTEE,
				new AmountImpl(new BigDecimal("5.0"), Currency.INDIAN_RUPEE)));

		products.add(
				new ProductImpl(120, "Product 20", ProductType.BANK_GUARANTEE,
						new AmountImpl(new BigDecimal("6.0"), Currency.EURO)));

		@SuppressWarnings("unused")
		Amount temp = null;

		try {
			temp = customerBO.getCustomerProductsSum(products);
			fail("DifferentCurrenciesException is expected");
		} catch (DifferentCurrenciesException e) {
		}
	}

	@Test
	public void testCustomerProductSum2() {

		List<Product> products = new ArrayList<Product>();

		Amount temp = null;

		try {
			temp = customerBO.getCustomerProductsSum(products);
		} catch (DifferentCurrenciesException e) {
		}
		assertEquals(Currency.EURO, temp.getCurrency());
		assertEquals(BigDecimal.ZERO, temp.getValue());
	}

}