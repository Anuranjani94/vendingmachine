package com.vendingprovider.vendingmachine_a.Service;

import java.util.Map;

import com.vendingprovider.vendingmachine_a.model.ProductContainer;

public interface ProductService {
	void loadProducts(ProductContainer pdt);
	Map<String,Float> showProducts();
	int getproductPrice(String product);
	boolean checkProductAvailability(String product,int quantity);
	String showAllProducts();

}
