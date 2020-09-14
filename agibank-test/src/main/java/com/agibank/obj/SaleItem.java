package com.agibank.obj;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public @Data @NoArgsConstructor @ToString class SaleItem extends ObjectBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3234536868551984263L;
	
	private Long id;
	private Integer qtt;
	private BigDecimal price;
		
	public SaleItem(String[] data) {
		this.id = Long.valueOf(data[0]);
		this.qtt = Integer.valueOf(data[1]);
		this.price = new BigDecimal(data[2]);
	}
	
}
