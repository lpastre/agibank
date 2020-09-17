package com.agibank.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.Test;
import com.agibank.obj.Customer;
import com.agibank.obj.Sale;
import com.agibank.obj.Salesman;
import com.agibank.util.Mapper;

public class LayoutTest {

	@Test
	public void testSalesman() {
		try {
			Salesman obj = (Salesman)Mapper.convertToObject("001ç1234567891234çPedroç50000");
		} catch (Exception e) {
			
			fail(e.getMessage());
		}
		assertTrue(true);
	}

	

	@Test
	public void testCustomer() {
		try {
			Customer obj = (Customer)Mapper.convertToObject("002ç2345675434544345çJose da SilvaçRural");
		} catch (Exception e) {
			
			fail(e.getMessage());
		}
		assertTrue(true);
	}
	

	@Test
	public void testSale() {
		try {
			Sale obj = (Sale)Mapper.convertToObject("003ç08ç[1-34-10,2-33-1.50,3-40-0.10]çPaulo");
		} catch (Exception e) {
			
			fail(ExceptionUtils.getStackTrace(e));
		}
		assertTrue(true);
	}
	
}
