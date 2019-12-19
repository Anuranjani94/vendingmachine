package com.vendingprovider.vendingmachine_a.impl;

import com.vendingprovider.vendingmachine_a.model.Product;
import com.vendingprovider.vendingmachine_a.model.ProductContainer;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.vendingprovider.vendingmachine_a.Service.ProductService;

public class ProductStorageImpl implements ProductService{

	
	private ProductContainer pdt;
	
	
	public String showAllProducts() {
		Map<String, Integer> product=new HashMap<>();
		product=pdt.getProducts();
		StringBuilder pdtDisplay=new StringBuilder();
		for(Entry<String, Integer> mp:product.entrySet()) {
			pdtDisplay=pdtDisplay.append(mp.getKey()+" : "+mp.getValue()+"\n");
		}
		return pdtDisplay.toString();
	}
	
	@Override
	public Map<String, Float> showProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getproductPrice(String product) {
		
		return 0;
	}

	@Override
	public boolean checkProductAvailability(String product, int quantity) {
		Map<Product,Integer>pdMap=new HashMap<>();
				pdMap=pdt.getPdtConMap();
		Set<Product> pd=pdMap.keySet();
		int availQuan=0;
		for(Product p:pd) {
			if(p.getProductName().equalsIgnoreCase(product)) {
			availQuan=pdMap.get(p);
			}
		}
		if(quantity<=availQuan) {
			return true;
		}
		return false;
	}
	
	public void loadProducts(ProductContainer pd) {
		
		this.pdt=pd;
	}

}
