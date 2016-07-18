package com.StockAccounting.MasterScripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class  LoginPage 

{
@FindBy (id="btnreset")
WebElement Reset;

@FindBy (id="username")
WebElement UN;

@FindBy (id="password")
WebElement Pwd;

@FindBy (id="btnsubmit")
WebElement Login;

public void AdminLgn (String UName, String Passwd)
{
	Reset.click();
	UN.sendKeys(UName);
	Pwd.sendKeys(Passwd);
	Login.click();
}
}
