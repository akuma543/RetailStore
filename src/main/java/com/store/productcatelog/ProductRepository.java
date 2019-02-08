package com.store.productcatelog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class ProductRepository {
	private HashMap<String ,Product> hm;
public ProductRepository(HashMap<String ,Product> hashmap){
this.hm=hashmap;
}

public Product getproductById(String pId){
	return hm.get(pId);
}
public List<Product> getproductByIds(List<String> pIds){
	if(pIds.isEmpty())
		return Collections.emptyList();
	else{
		List<Product> productList=new ArrayList<Product>();
		for(String pIdList:pIds){
			productList.add(hm.get(pIdList));
			
		}
		return productList;
	}

}
}
