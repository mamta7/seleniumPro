package com.Scripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class AdminLogin {

	
	public static void main(String[] args)
	{
	WebDriver driver=new FirefoxDriver();
	driver.get("http://webapp.qedgetech.com");
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	driver.manage().window().maximize();
	
	driver.findElement(By.id("btnreset")).click();
	driver.findElement(By.id("username")).sendKeys("admin");
	
	driver.findElement(By.id("password")).sendKeys("master");
	driver.findElement(By.id("btnsubmit")).click();
	
	driver.findElement(By.linkText("Suppliers")).click();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
	
	driver.findElement(By.id("x_Supplier_Name")).sendKeys("Manish Babu");
	driver.findElement(By.id("x_Address")).sendKeys("Hyderabad");
	driver.findElement(By.id("x_City")).sendKeys("Hyderabad");
	driver.findElement(By.id("x_Country")).sendKeys("India");
	driver.findElement(By.id("x_Contact_Person")).sendKeys("Manish");
	
	driver.findElement(By.id("x_Phone_Number")).sendKeys("9999111155");
	driver.findElement(By.id("x__Email")).sendKeys("manishbabu@gmail.com");
	driver.findElement(By.id("x_Mobile_Number")).sendKeys("9999111144");
	driver.findElement(By.id("x_Notes")).sendKeys("Imported Items");
	
	driver.findElement(By.id("btnAction")).click();
	
	driver.findElement(By.xpath(".//button[@class='ajs-button btn btn-primary'][1]")).click();
	driver.findElement(By.xpath(".//button[@class='ajs-button btn btn-primary'][1]")).click();
	
	
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a"))).build().perform();
	
	driver.findElement(By.linkText("Stock Categories")).click();
	
	driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
	driver.findElement(By.name("x_Category_Name")).sendKeys("Jackets");
	driver.findElement(By.id("btnAction")).click();
		
	
List<WebElement> b=driver.findElements(By.xpath("html/body/div[*]/div[2]/div/div[4]/div[2]/button[1]"));

System.out.println(b.size());
for (int i = 0; i <b.size(); i++)
{
  if (b.get(i).getText().contains("OK"))
  {
	b.get(i).click();
}	
}

driver.findElement(By.xpath("html/body/div[*]/div[2]/div/div[4]/div[2]/button")).click();
			
	
//stock categories_unit of measurement
	
	driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")).click();
	
	Actions act1=new Actions(driver);
	act1.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_unit_of_measurement']/a"))).build().perform();
	driver.findElement(By.linkText("Unit of Measurement")).click();
	driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
	driver.findElement(By.id("x_UOM_ID")).sendKeys("1111");
	driver.findElement(By.id("x_UOM_Description")).sendKeys("AAAA");
	driver.findElement(By.id("btnAction")).click();
	driver.findElement(By.className("ajs-button btn btn-primary")).click();
	driver.findElement(By.className("btnAction")).click();
	
	List<WebElement>A=driver.findElements(By.xpath(""));
	
	
	
	
		}
	
	

}
