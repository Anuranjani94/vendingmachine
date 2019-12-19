package com.vendingprovider.vendingmachine_a.model;

import java.util.HashMap;
import java.util.Map;

public class Coin {

	public enum CoinValue {
		PENNY(1), NICKEL(5), DIME(10), QUARTER(25);

		private final int numValue;
		private static Map<CoinValue,Integer> coinMap = new HashMap<>();

		static {
			for (CoinValue cv : CoinValue.values()) {
				coinMap.put(cv,cv.numValue);
			}
		}

		private CoinValue(int assignValue) {
			this.numValue = assignValue;
		}

		/*
		 * public static int literalValueOf(String value) { return coinMap.get(value); }
		 */
		
		
		/**
		 * @return the value
		 */
		

		
		public int getNumValue() {
			return this.numValue;
		}

		public static Map<CoinValue,Integer> getCoinMap() {
			return coinMap;
		}
		public static Coin.CoinValue getStringValue(int v) {
			for (Map.Entry<CoinValue,Integer> mp : Coin.CoinValue.getCoinMap().entrySet()) {
				if(v==mp.getValue()) {
					return mp.getKey();
					
				}
			}
			return null;
		}
	}
	
}
