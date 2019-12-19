package com.vendingprovider.vendingmachine_a.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinContainer {
	//private Map<Integer, Coin.CoinValue> coinMap = new HashMap<>();
	private Map<Coin.CoinValue, Integer> coinQuant = new HashMap<>();
	private String coinName;
	private int quantity;
	private int totalValue = 0;

	public CoinContainer(String coinName, int quantity) {
		this.coinName = coinName;
		this.quantity = quantity;
		this.coinQuant.put(Coin.CoinValue.valueOf(coinName), quantity);
		this.totalValue = totalValue + Coin.CoinValue.valueOf(coinName).getNumValue() * quantity;
	}

	/**
	 * @return the coinQuant.
	 */
	public Map<Coin.CoinValue, Integer> getCoinQuant() {
		return coinQuant;
	}

	/**
	 * @return the coinName
	 */
	public String getCoinName() {
		return coinName;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param coinQuant the coinQuant to set
	 */
	public void setCoinQuant(String coinName, int quantity) {
		Coin.CoinValue cv = Coin.CoinValue.valueOf(coinName);
		this.coinQuant.put(cv, coinQuant.get(cv) + quantity);
		this.totalValue = totalValue + Coin.CoinValue.valueOf(coinName).getNumValue() * quantity;
	}

	public static List<String> getCoins() {
		List<String> coin = new ArrayList<>();
		for (Coin.CoinValue cv : Coin.CoinValue.values()) {
			coin.add(cv.name());
		}
		return coin;
	}

	/**
	 * @return the totalValue
	 */
	public int getTotalValue() {
		return totalValue;
	}

	/*
	 * public Map<String,Integer> getCoinMap(){
	 * 
	 * 
	 * Coin.CoinValue. }
	 */
	
	

}
