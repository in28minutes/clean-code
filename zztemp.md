
```java
package com.b.simple.design.business.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.b.simple.design.business.customer.CustomerBO;
import com.b.simple.design.business.customer.CustomerBOImplRefactored;
import com.b.simple.design.business.exception.DifferentCurrenciesException;
import com.b.simple.design.model.customer.Amount;
import com.b.simple.design.model.customer.AmountImpl;
import com.b.simple.design.model.customer.Currency;
import com.b.simple.design.model.customer.Product;
import com.b.simple.design.model.customer.ProductImpl;
import com.b.simple.design.model.customer.ProductType;

public class CustomerBOTestRefactored {

	private CustomerBO clientBO = new CustomerBOImplRefactored();

	@Test
	public void testCustomerProductSum_AllProductsSameCurrency()
			throws DifferentCurrenciesException {

		Amount[] amounts = {
				new AmountImpl(new BigDecimal("5.0"), Currency.EURO),
				new AmountImpl(new BigDecimal("6.0"), Currency.EURO) };

		Amount expected = new AmountImpl(new BigDecimal("11.0"), Currency.EURO);
		
		List<Product> products = createProductListWithAmounts(amounts);

		Amount actual = clientBO.getCustomerProductsSum(products);

		assertAmount(actual, expected);
	}

	@Test
	public void testCustomerProductSum_DifferentCurrencies_ThrowsException()
			throws DifferentCurrenciesException {

		Amount[] amounts = {
				new AmountImpl(new BigDecimal("5.0"), Currency.EURO),
				new AmountImpl(new BigDecimal("6.0"), Currency.INDIAN_RUPEE) };

		List<Product> products = createProductListWithAmounts(amounts);
		
		Assertions.assertThrows(DifferentCurrenciesException.class, () -> {
			@SuppressWarnings("unused")
			Amount actual = clientBO.getCustomerProductsSum(products);
		});
	}

	@Test
	public void testCustomerProductSum_NoProducts()
			throws DifferentCurrenciesException {

		Amount[] amounts = {};
		Amount expected = new AmountImpl(BigDecimal.ZERO, Currency.EURO);

		List<Product> products = createProductListWithAmounts(amounts);

		Amount actual = clientBO.getCustomerProductsSum(products);


		assertAmount(actual, expected);
	}

	private void assertAmount(Amount actual, Amount expected) {
		assertEquals(expected.getCurrency(), actual.getCurrency());
		assertEquals(expected.getValue(), actual.getValue());
	}

	private List<Product> createProductListWithAmounts(Amount[] amounts) {
		List<Product> products = new ArrayList<Product>();
		for (Amount amount : amounts) {
			products.add(new ProductImpl(100, "Product 15",
					ProductType.BANK_GUARANTEE, amount));
		}
		return products;
	}

}
```