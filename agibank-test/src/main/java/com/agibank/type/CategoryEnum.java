package com.agibank.type;

import java.util.Arrays;

import com.agibank.obj.Customer;
import com.agibank.obj.ObjectBase;
import com.agibank.obj.Sale;
import com.agibank.obj.Salesman;

public enum CategoryEnum {

	SALESMAN("001", Salesman.class), CUSTOMER("002",Customer.class), SALE("003", Sale.class);
	
	private String key;
	private Class<? extends ObjectBase> implementer;

	private CategoryEnum(String key, Class<? extends ObjectBase> implementer) {
		this.key = key;
		this.implementer = implementer;
	}
	
    public Class<? extends ObjectBase> getImplementer() {
        return this.implementer;
    }
	
    public static CategoryEnum getCategory(String key) {
    	return Arrays.asList(
    			CategoryEnum.values()).stream().filter(
    					category -> key.equals(category.key)).findFirst().orElse(null);
    }
	
}
