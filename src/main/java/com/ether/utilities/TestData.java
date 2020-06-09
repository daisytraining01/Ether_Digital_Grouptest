package com.ether.utilities;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.ether.base.Base;

public class TestData extends Base{

	@DataProvider(name = "getData")
	public Object[][] getData(Method method) {
		String sheetName = null;
		if(method.getName().equals("homePage")) {
			sheetName = "formData";
		}else if(method.getName().equals("productPriceTest")) {
			sheetName = "ProductList";
		}
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);

		Object[][] data = new Object[rows - 1][cols];

		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}

		return data;

	}
}
