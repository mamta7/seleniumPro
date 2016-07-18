package com.StockAccounting.MasterScripts;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGBase
{
	public static  StockAccounting_Master SL=new StockAccounting_Master();
	
  @BeforeTest
  public void adminLogin()
  {
	  SL.AdminLgn("admin","master");
  }

  @AfterTest
  public void Logout()
  {
	  SL.ERP_Logout();
  }

  @BeforeSuite
  public void openApp() throws IOException
  {
	  SL.openApp();
	  
  }

  @AfterSuite
  public void closeApp()
  {
	  SL.ERP_Close();
  }

}
