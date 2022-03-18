package com.techblog.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
		private static      XSSFWorkbook excelWBook; //Excel WorkBook
	    private static      XSSFSheet    excelWSheet; //Excel Sheet
	   

	    // This method has two parameters: "Test data excel file name" and "Excel sheet name"
	    // It creates FileInputStream and set excel file and excel sheet to excelWBook and excelWSheet variables.
	    public static String getCellData(int RowNum, int ColNum) throws IOException {
	        
	        // Open the Excel file
	    	 FileInputStream ExcelFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources"
	                 + "/Testdata.xlsx");
	excelWBook = new XSSFWorkbook(ExcelFile);
	        excelWSheet = excelWBook.getSheetAt(0);
	        //return excelWSheet.getRow(RowNum).getCell(ColNum).getStringCellValue();
	        DataFormatter formatter = new DataFormatter();
	         return formatter.formatCellValue(excelWSheet.getRow(RowNum).getCell(ColNum));
	    }
	}


