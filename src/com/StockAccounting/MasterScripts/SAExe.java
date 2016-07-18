package com.StockAccounting.MasterScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SAExe
{
	@Test
	public void LoginTest()
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("http://webapp.qedgetech.com");
		
		 LoginPage  lp=PageFactory.initElements(driver,  LoginPage .class);
		 
		 lp.AdminLgn("admin", "master");
		 
		 LinkText  lt=PageFactory.initElements(driver, LinkText.class);
		 lt.StockItem();
		 lt.Supplier();
		 lt.Purchases();
		 lt.Customer();
		 lt.sales();
		
		
	}
	
	
}
