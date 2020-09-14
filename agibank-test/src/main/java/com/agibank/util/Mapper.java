package com.agibank.util;

import java.util.ArrayList;
import java.util.List;

import com.agibank.obj.ObjectBase;
import com.agibank.obj.SaleItem;
import com.agibank.type.CategoryEnum;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Mapper {

	public static ObjectBase convertToObject(String line) throws Exception{
		String[] data = line.split("\\u00E7");
		return CategoryEnum.getCategory(String.valueOf(data[0])).getImplementer().getDeclaredConstructor(String[].class).newInstance(new Object[]{data});
	}

	public static List<SaleItem> convertToSaleItems(String line) {
		List<SaleItem> items = new ArrayList<>();

		String[] data = line.substring(1, line.length() -1).split(",");
		for(String strItem : data ) {
			String[] dataItem = strItem.split("-");
			items.add(new SaleItem(dataItem));
		 }
		
		return items;
	}

}
