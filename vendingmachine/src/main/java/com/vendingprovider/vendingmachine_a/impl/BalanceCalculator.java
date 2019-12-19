package com.vendingprovider.vendingmachine_a.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.vendingprovider.vendingmachine_a.Service.BalanceService;
import com.vendingprovider.vendingmachine_a.model.Coin;

public class BalanceCalculator implements BalanceService {

	// private CoinContainer coinctr;

	
	/*
	 * @Override public void checkBalance(int total, int unitPrice) { if (total >
	 * unitPrice) { //return true; } //return false;
	 * 
	 * }
	 */

	@Override
	public int calculateCoinValues(Map<String, Integer> cqMap) {
		int total = 0;
		int quantity = 0;
		int value;
		for (Map.Entry<String, Integer> mp : cqMap.entrySet()) {
			String coinLiteral = mp.getKey().toUpperCase();
			quantity = mp.getValue();
			// value = Coin.CoinValue.literalValueOf(coinLiteral);
			value = Coin.CoinValue.valueOf(coinLiteral).getNumValue();
			total = total + value * quantity;
		}
		return total;
	}

	@Override
	public List<Map<String, Integer>> calculateBalance(Map<Coin.CoinValue, Integer> ct, int contTotal, int insertTotal,
			int unitPrice) {
		Map<String, Integer> balCoins = new HashMap<String, Integer>();
		Map<Integer, Integer> ctrValue = new HashMap<>();
		Map<String, Integer> ctUpdate = new HashMap<>();

		int balance = insertTotal - unitPrice;
		for (Map.Entry<Coin.CoinValue, Integer> mp : ct.entrySet()) {
			ctrValue.put(mp.getKey().getNumValue(), mp.getValue());
		}

		int[] v = ctrValue.values().stream().mapToInt(Integer::intValue).toArray();
		// int []
		// v=ct.keySet().stream().mapToInt(Integer::Coin.CoinValue.valueOf(CoinValue).getNumValue()).toArray();
		int n = v.length;
		for (int i = n - 1; i >= 0; i--) {
			if (balance == 0) {
				break;
			}

			while (balance >= v[i]) {
				if (ctrValue.get(v[i]) == 0) {
					break;
				}
				String s = Coin.CoinValue.getStringValue(v[i]).toString();
				balCoins.put(s, balCoins.get(s) + 1);
				if (ctrValue.get(v[i]) <= 0)
					ctrValue.put(v[i], ctrValue.get(v[i]) - 1);
				balance = balance - v[i];

			}
		}
		if (balance > 0) {
			throw new IllegalArgumentException("Insufficient balance:Sorry for the inconvenience");

		}

		for (Map.Entry<Integer, Integer> mp : ctrValue.entrySet()) {
			ctUpdate.put(Coin.CoinValue.getStringValue(mp.getKey()).toString(), mp.getValue());
		}
		List<Map<String, Integer>> retValues = new ArrayList<>(2);

		retValues.add(ctUpdate);
		retValues.add(balCoins);

		return retValues;

	}

}
