/**
 * 
 */
package com.vendingprovider.vendingmachine_a.Service;

import java.util.Map;

import com.vendingprovider.vendingmachine_a.model.CoinContainer;

/**
 * @author classic
 *
 */
public interface CoinService {

	/**
	 * coin availability, 
	 */
	void loadCoin(CoinContainer coinCont);
	Map<String,Integer> storeCoin(int unitPrice,Map<String,Integer> cqMap);
	// check if valid coin
	boolean checkDenomination(String coinNm);
	
	
	
	

}
