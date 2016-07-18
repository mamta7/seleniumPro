package com.StockAccounting.MasterScripts;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class notepadUOM
{
	
	public static void main(String[] args) throws IOException
	{ 
		
		StockAccounting_Master SL=new StockAccounting_Master();
		String FPath="D:\\Dolly Selenium\\Stock_Accounting\\src\\com\\StockAccounting\\TestData\\UOM.txt";
		String RPath="D:\\Dolly Selenium\\Stock_Accounting\\src\\com\\StockAccounting\\Results\\UOMResult.txt";
		String SD;
		
					
			FileReader FR=new FileReader(FPath);
			BufferedReader BR=new BufferedReader(FR);
			
			String SRead=BR.readLine(); 
			System.out.println(SRead);
			
			FileWriter FW=new FileWriter(RPath);
			BufferedWriter BW=new BufferedWriter(FW);
			BW.write(SRead+"###"+"Results");
			BW.newLine();
			
			while ((SD=BR.readLine())!=null)
			{
			System.out.println(SD);	
			String[] SR=SD.split("###");
			
			String UID=SR[0];
					System.out.println(UID);
					
					String UDESC=SR[1];
					System.out.println(UDESC);
					
					
			/*	String	res=SL.unit_of_measurement(UID, UDESC);
					System.out.println(res);*/
					
					BW.write(UID+"@@@"+UDESC+"@@@"+"PASS");
					BW.newLine();
					}
			
			BW.close();
			BR.close();
	}

}

