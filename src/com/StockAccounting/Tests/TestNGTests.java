package com.StockAccounting.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.StockAccounting.MasterScripts.TestNGBase;

public class TestNGTests extends TestNGBase
{
	
@Test(dataProvider="Udata")

public void UOM(String uid,String udesc)
{
	SL.unit_of_measurement(uid, udesc);
}

@Test
public void  sc()
{
SL.stock_categories("HTC Desire mobile");
}

@DataProvider

public Object [] [] udata()
{
	Object[] [] obj=new Object[3][2];
	
	obj [0][0] = "1001GB";
	obj [0][1]="testNG1";
	
	obj [1][0]="1002GB";
	obj[1][1]="testNG2";
	
	obj [2][0]="1003GB";
	obj[2][1]="testNG3";
	
	return obj;
}
}