package com.reusable.propertyfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReusableExcelProgramm {
	
	
	File f;
	FileInputStream fi;
	FileOutputStream fo;
	XSSFWorkbook wb;
	XSSFSheet sh;
	
	public ReusableExcelProgramm(String pathname) throws FileNotFoundException{
		
		try {
		f=new File(pathname);
		fi=new FileInputStream(f);	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void getSheet(String sheetname) throws IOException {
		if(sheetname.equalsIgnoreCase("WritingData")) {
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheet(sheetname);			
		}else {
			wb=new XSSFWorkbook(fi);
			sh=wb.createSheet(sheetname);
		}
	}
	
	public int getRowCount() {
		
		return sh.getLastRowNum();
	}
	
	public int getColCount() {
		return sh.getRow(0).getLastCellNum();
	}
	
  public void getSheet(int index) throws IOException {
		
		wb=new XSSFWorkbook(fi);
		sh=wb.getSheetAt(index);
	}
	public String getDatafromCell(int rownum,int colnum) {
		
		return sh.getRow(rownum).getCell(colnum).getStringCellValue();
		
	}
	
	public void setDataintoCell(int rownum,int colnum,String text) {
		
		sh.createRow(rownum).createCell(colnum).setCellValue(text);
	}
	
	public void closeFileoutputStream() throws IOException {
		fo=new FileOutputStream(f);
		wb.write(fo);
		fo.close();
	}
	

}
