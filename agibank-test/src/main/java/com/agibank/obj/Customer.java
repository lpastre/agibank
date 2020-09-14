package com.agibank.obj;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public @Data @NoArgsConstructor @ToString class Customer extends ObjectBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8787481967230157386L;
	
	private String cnpj;
	private String name;
	private String businessArea;
	
	public Customer(String[] data) {
		this.cnpj = data[1];
		this.name = data[2];
		this.businessArea = data[3];
	}
	
	
}
