package com.vendingprovider.vendingmachine_a.model;

import java.util.HashMap;
import java.util.Map;

public class ProductContainerImpl {
	private Product pdt;
	private Map<Product, Integer> pdtConMap = new HashMap<>();
	private Map<String, Integer> products = new HashMap<String, Integer>();

	public ProductContainerImpl(int pdtId, String pdtName, int price, int quantity) {
		this.pdt = new Product(pdtId, pdtName, price);
		//this.quantity = quantity;
		this.pdtConMap.put(pdt,quantity);
		this.products.put(pdtName,price);
	}


	/**
	 * @return the products
	 */
	public Map<String, Integer> getProducts() {
		
		return products;
	}
	


	/**
	 * @return the pdtConMap
	 */
	public Map<Product, Integer> getPdtConMap() {
		return pdtConMap;
	}

	

}
