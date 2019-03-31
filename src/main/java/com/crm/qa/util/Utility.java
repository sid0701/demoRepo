package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.crm.qa.base.TestBase;

public class Utility extends TestBase{
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	public static final long implicitWait = 30;
	public static final long pageLoadTimeout = 30;
	
	public Utility(String excelPath,String sheetName) {
		
		File f = new File(excelPath);
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(f);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheet(sheetName);
	}
	
	public static void switchToFrame(String frameName) {
		
		driver.switchTo().frame(frameName);
	}
	
	
	
	public String readExcelData(int rowno, int columnno) {
		
		return sheet.getRow(rowno).getCell(columnno).getStringCellValue();
		
	}
	
	public int returnRowCount() {
		return sheet.getLastRowNum();
	}
	
}
