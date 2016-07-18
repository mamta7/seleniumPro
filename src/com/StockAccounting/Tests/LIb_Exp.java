package com.StockAccounting.Tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.StockAccounting.MasterScripts.StockAccounting_Master;

public class LIb_Exp 
{

	public static void main(String[] args) throws IOException ,NullPointerException
		
	{
		String res = null;
		StockAccounting_Master lib=new StockAccounting_Master();
		lib.openApp();
		lib.AdminLgn("admin", "master");		
		System.out.println(res);
		
		res=lib.stock_categories("Watches");
		System.out.println(res);
		
		res=lib.unit_of_measurement("1100", "This contains Watch");
		System.out.println(res);
		
		
		
		FileInputStream fis=new FileInputStream("D:\\Dolly Selenium\\Stock_Accounting\\src\\com\\StockAccounting\\TestData\\UOM.xlsx");
		
		// create workbook
		
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws= wb.getSheet("UOM");
		
	//	XSSFRow wr=ws.getRow(1);
	//	XSSFCell wc=wr.getCell(0);
		
	//	String cellData=wc.getStringCellValue();
//		System.out.println(cellData);
		
		int RC=ws.getLastRowNum();
		System.out.println(RC);
		
		for (int i = 1; i <=RC; i++) 
		{
		XSSFRow wr1=ws.getRow(i);
		
		XSSFCell wc1=wr1.getCell(0);
		XSSFCell wc2=wr1.getCell(1);
		XSSFCell wc3=wr1.createCell(2);
		
		String UID=wc1.getStringCellValue();
		String UDESC=wc2.getStringCellValue();	
		System.out.println(UID+"......"+UDESC);
		
		res=lib.unit_of_measurement(UID, UDESC);
		
		System.out.println(res);
		wc3.setCellValue(res);
		}
		
		FileOutputStream fos=new FileOutputStream("C:\\Users\\mamta\\Desktop\\UOM.xlsx");
		wb.write(fos);
		wb.close();
					
	  //    lib.openApp();
	 //     lib.AdminLgn("admin","master");
        //  lib.Suppliers("mamta", "s.r nagar", "hyderabad", "india"," chandu"," 987777999", "chandu@gmail.com", "9089878765"," contact chandu" );
          
      //    lib.Stock_item();
          
        
//          String res1=lib.openApp();
//          System.out.println(res1);
//          res1=lib.AdminLgn("admin","master");
//          System.out.println(res1);
//          
        		 
	}

}


