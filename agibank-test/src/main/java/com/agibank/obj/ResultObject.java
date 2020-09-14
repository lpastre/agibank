package com.agibank.obj;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import lombok.Data;

public @Data class ResultObject extends ObjectBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3467835843728788612L;
	
	private Set<String> setCustomerQtt;
	private Map<String, Integer> mapSalesmanQtt;
	private Long moreExpensiveSaleId;
	private BigDecimal moreExpensiveSalePrice;
	private String theWorstSalesman;
	private Integer theWorsSalestQtt;

	
	
	public ResultObject() {

		this.setCustomerQtt = new LinkedHashSet<>();
		this.mapSalesmanQtt = new HashMap<>();
		this.moreExpensiveSaleId = 0L;
		this.moreExpensiveSalePrice = BigDecimal.ZERO;
		
	}
	
	
	@Override
	public String toString() {
		mapSalesmanQtt.forEach((name, salesQtt) -> {

			if(this.theWorstSalesman == null || this.mapSalesmanQtt.get(name) < theWorsSalestQtt) {
				this.theWorstSalesman = name;
				theWorsSalestQtt = salesQtt;
			}
		});
		
		
		return String.format("Quantidade de clientes: %s\n"
		 			 + "Quantidade de vendedor: %s\n"
		 			 + "ID da venda mais cara: %s\n"
		 			 + "O pior vendedor: %s", this.setCustomerQtt.size(), 
		 			 this.mapSalesmanQtt.size(), this.moreExpensiveSaleId,this.theWorstSalesman);
		 
	}

	
}
