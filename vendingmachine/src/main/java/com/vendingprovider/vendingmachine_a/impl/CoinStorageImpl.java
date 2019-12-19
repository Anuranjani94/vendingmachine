package com.vendingprovider.vendingmachine_a.impl;

import java.util.List;
import java.util.Map;

import com.vendingprovider.vendingmachine_a.Service.CoinService;
import com.vendingprovider.vendingmachine_a.model.CoinContainer;

/**
 * @author classic
 *
 */

/**
 * @author classic
 *
 */
public  class CoinStorageImpl implements CoinService {

	//private List<Integer> validCoins = new ArrayList<>(Arrays.asList(new Integer[] { 1, 5, 10, 25 }));

	private CoinContainer coinCont;
	private BalanceCalculator bal;
	
	@Override
	public boolean checkDenomination(String coinNm) {
		List<String>coinType=CoinContainer.getCoins();
		if(coinType.contains(coinNm))
			return true;

		else
			return false;
	}

	/**
	 * Store coins during product transaction
	 */
	@Override
	public Map<String,Integer> storeCoin(int unitPrice,Map<String,Integer> cqMap) {
		//String coinNm=coinCont.getCoinName();
		for(Map.Entry<String,Integer> entrycqMap:cqMap.entrySet()) {
		if(checkDenomination(entrycqMap.getKey())) {
			continue;
		}
		else
		
			throw new IllegalArgumentException("Invalid Coin:"+entrycqMap.getKey());
		
		}
		int totalValue=bal.calculateCoinValues(cqMap);
				int containerTotal=coinCont.getTotalValue();
				if(totalValue>=unitPrice) {
						
					for(Map.Entry<String,Integer> entrycqMap:cqMap.entrySet()) {
						
					this.coinCont.setCoinQuant(entrycqMap.getKey(), entrycqMap.getValue());
					}
					try {
					List<Map<String,Integer>>result=bal.calculateBalance(coinCont.getCoinQuant(),containerTotal,totalValue,unitPrice);
					updateCoinContainer(result.get(0));
					return result.get(1);
					}
					catch(Exception e) {
						throw e;
					}
				}
		
		else {
			throw new IllegalArgumentException("Invalid Transaction: Total value of Coins received is less than product price");
		}
	}
	/**
	 *Initial loading of coins
	 */
	@Override
	public void loadCoin(CoinContainer coin) {
		this.coinCont=coin;
	}
	/**
	 * @return the coinCont
	 */
	public CoinContainer getCoinCont() {
		return coinCont;
	}
	
	public void updateCoinContainer(Map<String, Integer> mc) {
		for(Map.Entry<String,Integer> entrycqMap:mc.entrySet()) {
			
			this.coinCont.setCoinQuant(entrycqMap.getKey(), entrycqMap.getValue());
			}
	}
}
