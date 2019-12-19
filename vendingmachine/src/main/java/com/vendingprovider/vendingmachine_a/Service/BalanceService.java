package com.vendingprovider.vendingmachine_a.Service;

import java.util.List;
import java.util.Map;

import com.vendingprovider.vendingmachine_a.model.Coin;

public interface BalanceService {

	List<Map<String,Integer>> calculateBalance(Map<Coin.CoinValue, Integer> ct,int contTotal,int insertTotal,int unitPrice);
	int calculateCoinValues(Map<String,Integer>mp);
	
}
