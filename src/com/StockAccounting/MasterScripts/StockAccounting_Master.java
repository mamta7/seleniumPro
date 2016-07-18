package com.StockAccounting.MasterScripts;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;

import com.StockAccounting.Tests.LIb_Exp;

public class StockAccounting_Master 
{

public static List<WebElement> okbs;
public static WebDriver driver;
public static String ExpVal,ActVal;

public String openApp() throws IOException
{
	//Properties pr = new Properties();
	//FileInputStream fis = new FileInputStream("");
	
	
	ExpVal="Login";
	driver=new FirefoxDriver();
	driver.get("http://webapp.qedgetech.com");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	ActVal=driver.findElement(By.id("btnsubmit")).getText();
	
if (ExpVal.equalsIgnoreCase(ActVal))
{
return "PASS";	
} 
else
{
return "FAIL";
}
		
}
public String AdminLgn(String UserName , String Pwd)
{
	ExpVal="Administrator";
	driver.findElement(By.id("btnreset")).click();
	driver.findElement(By.id("username")).sendKeys(UserName);
	driver.findElement(By.id("password")).sendKeys(Pwd);
	driver.findElement(By.id("btnsubmit")).click();
	
	ActVal=driver.findElement(By.xpath(".//*[@id='msUserName']/font/strong")).getText();
	//String res;
	
	if (ExpVal.equalsIgnoreCase(ActVal))
	{
	System.out.println("Login Pass");	
	
	 return "PASS";
	} 
	else 
	{
		
     System.out.println("Login Failed");
     
     //return "FAIL";
     
      return "FAIL";
     
     	}
	
}
	//suppliers
	public void  Suppliers(String Supplier_Name, String Address,
			String City,String Country,String ContactPerson, String PhoneNumber,String Email,String MobileNumber,String Notes)
	
	{
	
		ExpVal="Add succeeded";
		driver.findElement(By.linkText("Suppliers")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		driver.findElement(By.id("x_Supplier_Name")).sendKeys(Supplier_Name);
		driver.findElement(By.id("x_Address")).sendKeys(Address);
		driver.findElement(By.id("x_City")).sendKeys(City);
		driver.findElement(By.id("x_Country")).sendKeys(Country);
		driver.findElement(By.id("x_Contact_Person")).sendKeys(ContactPerson);
		driver.findElement(By.id("x_Phone_Number")).sendKeys(PhoneNumber);
		driver.findElement(By.id("x__Email")).sendKeys(Email);
		driver.findElement(By.id("x_Mobile_Number")).sendKeys(MobileNumber);
		driver.findElement(By.id("x_Notes")).sendKeys(Notes);
		
		driver.findElement(By.xpath(".//*[@id='btnAction']")).click();
		
		Sleeper.sleepTightInSeconds(3);
		List<WebElement> cok=driver.findElements(By.xpath("html/body/div[*]/div[2]/div/div[4]/div[2]/button[1]"));
		for (int i = 0; i < cok.size(); i++)
		{
			System.out.println(cok.get(i).getText());
			if (cok.get(i).getText().contains("OK")) 
			{
				cok.get(i).click();
				
			}
			
		}
		
		driver.findElement(By.xpath(".//button[@class='ajs-button btn btn-primary']"));
	
		Sleeper.sleepTightInSeconds(2);
		
		ActVal=driver.findElement(By.xpath(".//div[@class='alert alert-success ewSuccess']")).getText();
		
		driver.findElement(By.xpath(".//button[@class='ajs-button btn btn-primary']")).click();
		
		if (ExpVal.equalsIgnoreCase(ActVal))
		{
			System.out.println("pass");
			//return "Pass";			
		}
		else
		{
			System.out.println("fail");
			//return "Fail";
			}
		
	}

//Stock Items 
	
	public void Stock_item(String St_Item, String Name, String Watch_Brand, String watch_Name)
	{
		driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")).click();		
		
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();		
		
		WebElement  drop=driver.findElement(By.id("x_Category"));		
		Select droplist=new Select(drop);		
		droplist.selectByVisibleText("Ear Ring");
		
		WebElement drop1=driver.findElement(By.id("x_Supplier_Number"));
		Select dropDown=new Select(drop1);
		dropDown.selectByVisibleText("24");
		
		driver.findElement(By.id("x_Stock_Name")).sendKeys("Earrings");
		
		WebElement drop2=driver.findElement(By.id("x_Unit_Of_Measurement"));
		Select dropDown1=new Select(drop2);
		dropDown1.selectByVisibleText("12 items");
		
		driver.findElement(By.id("x_Purchasing_Price")).sendKeys("1000");
		driver.findElement(By.id("x_Selling_Price")).sendKeys("1500");
		driver.findElement(By.id("x_Notes")).sendKeys("Final Price");
		
 driver.findElement(By.id("btnAction")).click();
 
 driver.findElement(By.xpath("html/body/div[*]/div[2]/div/div[4]/div[2]/button[1]")).click();
 
 Sleeper.sleepTightInSeconds(2);
 //driver.findElement(By.id("html/body/div[*]/div[2]/div/div[4]/div[2]/button")).click();
		
 ActVal=driver.findElement(By.xpath("html/body/div[*]/div[2]/div/div[3]/div/div")).getText();
	
	driver.findElement(By.xpath("html/body/div[*]/div[2]/div/div[4]/div[2]/button")).click();
	
	if (ExpVal.equalsIgnoreCase(ActVal))
	{
		System.out.println("Stock Item Pass");
		//return "Pass";			
	}
	else
	{
		System.out.println("Stock Item Failed");
		//return "Fail";
					
	}
	
	}
	//Stock Categories
	
	public String stock_categories( String cat)
	
	{ 		
	/*ExpVal="Add succeded";	
	
	Actions Act=new Actions(driver);
	Act.moveToElement(driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/ul[1]/li[2]/a"))).build().perform();
	
	driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/ul[1]/li[2]/ul/li[1]/a")).click();
	Sleeper.sleepTightInSeconds(3);		
	driver.findElement(By.xpath("html/body/div[2]/div[3]/div/div/div[3]/div[1]/div[1]/div[1]/div/a")).click();	
	Sleeper.sleepTightInSeconds(4);
   driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div/ul[1]/li[2]/ul/li[1]/a")).click();
  	driver.findElement(By.xpath("html/body/div[2]/div[3]/div/div/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();	
	driver.findElement(By.id(".x_Category_Name")).sendKeys(cat);	
	driver.findElement(By.xpath(".//*[@id='btnAction']")).click();	
	Sleeper.sleepTightInSeconds(3);
	driver.findElement(By.xpath("html/body/div[*]/div[2]/div/div[4]/div[2]/button[1]"));		
	 ActVal=driver.findElement(By.xpath("html/body/div[*]/div[2]/div/div[3]/div/div")).getText();		
	 driver.findElement(By.xpath("html/body/div[*]/div[2]/div/div[4]/div[2]/button")).click();	
		
		if (ExpVal.equalsIgnoreCase(ActVal))
		{
			System.out.println("Stock  categories Pass");
			//return "Pass";			
		}
		else
		{
			System.out.println("Stock categories  Failed");
			//return "Fail";
*	
	}*/
		
		
		 ExpVal="Add succeeded";
		 
	      Actions act= new Actions(driver);
	      WebElement Sitm=driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"));
	      
	      act.moveToElement(Sitm).build().perform();
	      
	      driver.findElement(By.xpath(".//*[@id='mi_a_stock_categories']/a")).click();
	      
	     
	      driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
	      driver.findElement(By.id("x_Category_Name")).sendKeys(cat);
	      driver.findElement(By.xpath(".//*[@id='btnAction']")).click();
	      
	      
	      driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();
	      Sleeper.sleepTightInSeconds(2);
	      
	      ActVal=driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).getText();
	     
	      
	
		driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button")).click();
	      
	      if (ExpVal.equalsIgnoreCase(ActVal)) 
	      {
	    	  return "Pass";
		  } 
	      else
	      {
	    	  return "fail";
		  }
		
		
		
	}
			//Unit Of Measurement			
		public String unit_of_measurement(String uom,String udesc)
		
		{
			ExpVal="Add succeeded";		
			
			Actions act=new Actions(driver);
			
			act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"))).build().perform();
			
			driver.findElement(By.xpath(".//*[@id='mi_a_unit_of_measurement']/a")).click();		
			
			driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();			
			driver.findElement(By.id("x_UOM_ID")).sendKeys(uom);
			driver.findElement(By.id("x_UOM_Description")).sendKeys(udesc);
			driver.findElement(By.id("btnAction")).click();
			
		//	driver.findElement(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]")).click();		
			okbs=driver.findElements(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]"));
			
			for (int i = 0; i < okbs.size(); i++)
			{
			if (okbs.get(i).getText().equalsIgnoreCase("OK!"))
			{
			okbs.get(i).click();	
			break;
			}	
			}
			
			ActVal=driver.findElement(By.xpath("html/body/div[*]/div[2]/div/div[3]/div/div")).getText();
			
			driver.findElement(By.xpath("html/body/div[*]/div[2]/div/div[4]/div[2]/button")).click();
			
			
			if (ExpVal.equalsIgnoreCase(ActVal))
			{
			System.out.println("Unit Of Measurement Pass");
			return "PASS";
			
			}
			else
			{ 
				System.out.println("Unit Of Measurement Failed");
				return "FAIL";

			}
			
			
			//test data path
		
	}
		
		public String ERP_Logout()
		
		{
		driver.findElement(By.id("logout")).click();
		//driver.findElement(By.xpath("html/body/div[*]/div[2]/div/div[4]/div[2]/button[1]")).click();
	okbs=driver.findElements(By.xpath("html/body/div[.]/div[2]/div/div[4]/div[2]/button[1]"));
	
	for (int i = 0; i < okbs.size(); i++)
	{
	if (okbs.get(i).getText().equalsIgnoreCase("OK!"))
	{
	okbs.get(i).click();	
	break;
	}	
	}
	
	ExpVal="Login";
	ActVal=driver.findElement(By.id("btnsubmit")).getText();
	
	if (ExpVal.equalsIgnoreCase(ActVal))
	{
	return "pass";	
	} 
	else
	{
return "fail";
	}
			
		}
		public void ERP_Close()
		{
			driver.close();
		}
}

