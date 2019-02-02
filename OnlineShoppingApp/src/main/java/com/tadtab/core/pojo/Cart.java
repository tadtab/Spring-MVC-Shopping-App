package com.tadtab.core.pojo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Cart {
	
	private List<Product> cartList = new CopyOnWriteArrayList<Product>();
	private Map<Integer, Integer>  mappedListOfProducts = new ConcurrentHashMap<>();
	
	int numberOfProducts = cartList.size();
		
	public List<Product> getCartList(){
		Product[] produtsInArray =  cartList.toArray(new Product[numberOfProducts]);
		int produtsInArraylength = produtsInArray.length;
		
		for(int i = 0; i < produtsInArraylength; i++){
			int mapKey = produtsInArray[i].getId();
			int mapValue = 1;
			
			for(int j = 0; j < produtsInArraylength; j++){
				if(i != j && produtsInArray[i].getId() == produtsInArray[j].getId()){
					mapValue += 1;
				}
			}
			mappedListOfProducts.put(mapKey, mapValue);
		}
		if(produtsInArray.length > 0){
			
			int sampleKey = mappedListOfProducts.size();
			
			
			Iterator<Integer> it =mappedListOfProducts.keySet().iterator();
			int numberOfKeys = mappedListOfProducts.keySet().size();
			
			Collection col = mappedListOfProducts.values();
			
			System.out.println("Total number of key = " + mappedListOfProducts.keySet().size());
			System.out.println("Total number of values are = " + col.size());
			
			Integer keysArray[] = new Integer[numberOfKeys];
			Integer valuesArray[] = new Integer[col.size()];
			
			while(it.hasNext()){
				for(int i=0; i < keysArray.length; i++){
					keysArray[i] = it.next();
				}
				
			}
			Iterator<Integer> it2 = col.iterator();
			
			while(it2.hasNext()){
				for(int i=0; i < valuesArray.length; i++){
					valuesArray[i] = it2.next();
				}

			}
			for(int i =0; i < valuesArray.length; i++){
				System.out.println(" the list of values are " + valuesArray[i]);
			}
			System.out.println("Map length is " + sampleKey);
			
			Set mappedSet = mappedListOfProducts.entrySet();
			
			Iterator it4 = mappedSet.iterator();
			
			while(it4.hasNext()){
				System.out.println("Entry set Values " + it4.next());
			}
			
		}
		
		return cartList; 		
	}
	
	public void setCartList(List<Product> cartList) {
		this.cartList = cartList;
	}
	
	

}