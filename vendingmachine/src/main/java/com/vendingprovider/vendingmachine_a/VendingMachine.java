package com.vendingprovider.vendingmachine_a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import com.vendingprovider.vendingmachine_a.Service.CoinService;
import com.vendingprovider.vendingmachine_a.Service.ProductService;
import com.vendingprovider.vendingmachine_a.impl.CoinStorageImpl;
import com.vendingprovider.vendingmachine_a.impl.ProductStorageImpl;
import com.vendingprovider.vendingmachine_a.model.CoinContainer;
import com.vendingprovider.vendingmachine_a.model.ProductContainer;
import com.vendingprovider.vendingmachine_a.model.ProductContainerImpl;

/**
 * @author classic
 *
 */
public class VendingMachine {

	/**
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) {
		try {
			ProductService pdtService = new ProductStorageImpl();
			CoinService coinService = new CoinStorageImpl();

			pdtService.loadProducts(new ProductContainerImpl(1, "Coke", 25, 10));
			pdtService.loadProducts(new ProductContainerImpl(2, "Pepsi", 35, 10));
			pdtService.loadProducts(new ProductContainerImpl(3, "Soda", 45, 10));
			
//penny(1), nickel(5), dime(10), quarter(25)
			coinService.loadCoin(new CoinContainer("PENNY", 10));
			coinService.loadCoin(new CoinContainer("NICKEL", 10));
			coinService.loadCoin(new CoinContainer("DIME", 10));
			coinService.loadCoin(new CoinContainer("QUARTER", 10));

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Choose the product");
			String displayProducts=pdtService.showAllProducts();
			System.out.println(displayProducts);
			String product = br.readLine();
			int quantity = Integer.parseInt(br.readLine());

			// check Product availability
			if (pdtService.checkProductAvailability(product, quantity)) {

				System.out.println("Insert coins:");
				String[] coinquant = br.readLine().split(",");
				Map<String, Integer> cqMap = new HashMap<>();
				for (String cq : coinquant) {
					String[] cqSplit = cq.split(":");
					String key = cqSplit[0];
					Integer value = Integer.parseInt(cqSplit[1]);
					cqMap.put(key, value);

				}
				int unitPrice = pdtService.getproductPrice(product);
				Map<String, Integer> balance = coinService.storeCoin(unitPrice, cqMap);
				// check if valid coin
				try {
					coinService.storeCoin(unitPrice, cqMap);
					// DeliveryService deliveryService = new DeliveryImpl(new
					// UnitDelivery(product,));
					System.out.println("product:" + product + "balance:" + balance);

				} catch (Exception e) {
					System.out.println(e.getMessage());

				}

			} else {
				System.out.println("Choosen product is out of stock");
			}
			/*
			 * catch(IllegalArgumentException e) {
			 * System.out.println(e.getMessage()+": Please provide valid coins"); }
			 */

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
