package com.StockAccounting.MasterScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NGexample 

{
	@Test(priority=3)
public void abc()
{
Assert.assertEquals("gmail","gmail");

}

	@Test(priority=1,enabled=false)
public void xyz()
{
	Assert.assertEquals("google","google");

}

	@Test(priority=2)
public void pqr()
{
Assert.assertEquals("facebook","facebook");

}

}
