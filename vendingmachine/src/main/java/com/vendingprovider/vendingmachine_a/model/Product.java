package com.vendingprovider.vendingmachine_a.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author EmpID
 *
 */
public class Product {
	private int productId;
	private String productName;
	private int quantity;
	private int productPrice;
	private Map<Integer,String>pIdNameMap=new HashMap<>();
	private Map<Map<Integer,String>,Integer>productDetList=new HashMap<>();
	
	
	public Product(int productId,String productName,int price) {
			this.productId=productId;
		this.productName=productName;
		this.productPrice=price;
		
		  this.pIdNameMap.put(productId,productName);
		  this.productDetList.put(pIdNameMap,price);
		 
	}


	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	public Map<Map<Integer, String>, Integer> getProductDetList() {
		return productDetList;
	}

	/**
	 * @param allProducts the allProducts to set
	 */

	public Map<Integer, String> getAllProducts() {
		return pIdNameMap;
	}

	/**
	 * @return the productPrice
	 */
	public int getProductPrice() {
		return productPrice;
	}
	

}
