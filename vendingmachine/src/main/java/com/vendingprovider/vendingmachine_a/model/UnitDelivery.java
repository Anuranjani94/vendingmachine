package com.vendingprovider.vendingmachine_a.model;

import java.util.Map;

 public final class UnitDelivery {
	private final Product product;
	private final boolean isbalance;
	private final Map<String,Integer>balance;
	
	public UnitDelivery(Product product,boolean state,Map<String,Integer>balance) {
	this.product=product;
	this.balance=balance;
	this.isbalance=state;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @return the isbalance
	 */
	public boolean isIsbalance() {
		return isbalance;
	}

	/**
	 * @return the balance
	 */
	public Map<String, Integer> getBalance() {
		return balance;
	}

}
