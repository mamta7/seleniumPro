package com.StockAccounting.MasterScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkText
{
@FindBy (xpath="html/body/div[2]/div[2]/div/div/ul[1]/li[2]/a")
WebElement stockItems;

@FindBy (css="#mi_a_suppliers>a")
WebElement Suppliers;

@FindBy (xpath="html/body/div[2]/div[2]/div/div/ul[1]/li[4]/a")
WebElement Purchases;

@FindBy (xpath="html/body/div[2]/div[2]/div/div/ul[1]/li[5]/a")
WebElement Customers;

@FindBy (linkText="Sales")
WebElement Sales;

public void  StockItem()
{
	stockItems.click();
	
}
public void  Supplier()
{
	Suppliers.click();
	
}
public void Purchases()
{
	Purchases.click();
}

public void Customer()
{
	Customers.click();
	
}
public void sales()
{
	Sales.click();
}
}
