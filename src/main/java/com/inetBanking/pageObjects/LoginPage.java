package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage (WebDriver driver)
	{
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@name='uid']")
	private WebElement usernameTextField;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//input[@name='btnReset']")
	private WebElement resetButton;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement lnkLogout;
	
	
	public void setUserName (String username)
	{
		usernameTextField.sendKeys(username);
	}
	
	public void setPassword (String password)
	{
		passwordTextField.sendKeys(password);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public void clickReset()
	{
		resetButton.click();
	}
	
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	
	
	

}
