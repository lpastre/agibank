package com.agibank.obj;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public @Data @NoArgsConstructor @ToString class Salesman extends ObjectBase{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5807104255417102754L;
	
	private String cpf;
	private String name;
	private BigDecimal salary;
	
	
	public Salesman(String[] data) {
		this.cpf = data[1].trim();
		this.name = data[2].trim();
		this.salary = new BigDecimal(data[3]);
	}
}
