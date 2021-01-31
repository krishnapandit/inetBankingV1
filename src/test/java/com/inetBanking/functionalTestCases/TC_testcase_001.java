package com.inetBanking.functionalTestCases;




import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_testcase_001 extends BaseClass {
	
	
	@Test
	public void loginTest01() throws Exception
	{
		
		log.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(userName);
		log.info("Entered username");
		lp.setPassword(password);
		log.info("Entered password");
		lp.clickLogin();
		log.info("Clicked on login button");
		
		//Page title validation
		//Assert.assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//System.out.println(timeStamp);
		if(driver.getTitle().equals("Guru99 Bank Manager 44HomePage"))
		{
			Assert.assertTrue(true);
			log.info("Loggin test Pass");
		}
		else {
			getScreenShotPath("loginTest01", driver);
			Assert.assertTrue(false);
			log.info("Loggin test Fail");
		}
	}

}
