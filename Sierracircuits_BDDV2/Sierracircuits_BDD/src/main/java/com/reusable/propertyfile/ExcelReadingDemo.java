package com.reusable.propertyfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadingDemo {

	public static void main(String[] args) throws IOException {
	
		System.out.println();
		File f=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Sheet1.xlsx");
		FileInputStream fi=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("WritingData");		
		int  total_rows=sh.getLastRowNum();
		int total_cols=sh.getRow(0).getLastCellNum();	
		for(int i=0;i<total_rows;i++) {			
			Row r=sh.getRow(i);
			
			for(int j=0;j<total_cols;j++) {
				System.out.println(r.getCell(j).getStringCellValue());
			}		
		}
		wb.close();
		fi.close();
	}
}
