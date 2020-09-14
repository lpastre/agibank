package com.agibank.obj;

import java.math.BigDecimal;
import java.util.List;

import com.agibank.util.Mapper;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

public @Data @NoArgsConstructor @ToString class Sale extends ObjectBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5625463381343461438L;
	
	private Long saleId;
	private List<SaleItem> items;
	private BigDecimal salePrice;
	private String salesmanName;

	public Sale(String[] data) {

		this.saleId = Long.valueOf(data[1]);
		this.items = Mapper.convertToSaleItems(data[2]);
		this.salesmanName = data[3].trim();
		
		
		this.salePrice = BigDecimal.ZERO;
		this.items.forEach(saleItem -> {
			salePrice = salePrice.add(saleItem.getPrice().multiply(new BigDecimal(saleItem.getQtt())));
		});
		 

	}
	
	
	
}
