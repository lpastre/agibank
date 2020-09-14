package com.agibank.process;

import com.agibank.obj.Customer;
import com.agibank.obj.ResultObject;
import com.agibank.obj.Sale;
import com.agibank.obj.Salesman;

public class ProcessObject {

	private ResultObject resultObject = new ResultObject();
	
	
	public void process(Customer customer) {
		resultObject.getSetCustomerQtt().add(customer.getCnpj());
	}

	public void process(Sale sale) {
		if(sale.getSalePrice().compareTo(resultObject.getMoreExpensiveSalePrice()) == 1 ) {
			resultObject.setMoreExpensiveSalePrice(sale.getSalePrice());
			resultObject.setMoreExpensiveSaleId(sale.getSaleId());
		}
		
		resultObject.getMapSalesmanQtt().put(sale.getSalesmanName(), getQttSalesOfSalesman(sale.getSalesmanName()) + 1);
		
	}

	public void process(Salesman salesman) {
		getQttSalesOfSalesman(salesman.getName());
	}
	
	
	private Integer getQttSalesOfSalesman(String salesmanName) {
		Integer qttSaleOfSalesman = resultObject.getMapSalesmanQtt().get(salesmanName);
		if(qttSaleOfSalesman == null) {
			qttSaleOfSalesman = 0;
			resultObject.getMapSalesmanQtt().put(salesmanName, qttSaleOfSalesman);
		}
		return qttSaleOfSalesman;
	}

	public ResultObject getResultObject() {
		return resultObject;
	}

	
}
