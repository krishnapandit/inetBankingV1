package com.inetBanking.functionalTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddNewCustomer_003 extends BaseClass{
	
	
	
	@Test
	public void addnewcustomer() throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(userName);
		lp.setPassword(password);
		lp.clickLogin();
		log.info("Login is successful");
		
		AddCustomerPage addnewcust = new AddCustomerPage(driver);
		log.info("Providing customer details");
		addnewcust.clickAddNewCustomer();
		addnewcust.custName("Krishna");
		addnewcust.custgender("male");
		addnewcust.custdob("11", "11", "1993");
		addnewcust.custaddress("Murgeshparllya");
		addnewcust.custcity("Bangalore");
		addnewcust.custstate("Karnataka");
		addnewcust.custpinno("560017");
		addnewcust.custtelephoneno("0123456789");
		
		String email = randomestring() + "@gmail.com";
		addnewcust.custemailid(email); //Should be unque value for each user.
		addnewcust.custpassword("1234");
		addnewcust.custsubmit();
		
		Thread.sleep(3000);
		log.info("Validation started");
		if(driver.getPageSource().contains("Customer Registered Successfully!!!")==true)
		{
			log.info("Test is pass");
			Assert.assertTrue(true);
		}
		else {
			log.info("Test is fail");
			getScreenShotPath("addnewcustomer", driver);
			Assert.assertTrue(false);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
