package com.inetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	
	Properties pro;

	public ReadConfig() 
	{
		
		File src = new File("./Configurations/config.properties");

		try {

			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {

			System.out.println("Exception is" + e.getMessage());
		}
	}
	
	//One generic method 
	/*public String getValue(String key)
	{
		return pro.getProperty(key);
	}*/
	
	//we can create a seperate methods for each key from config file to read.
	
	public String getApplicationURL()
	{
		return pro.getProperty("baseURL");
	}
	
	public String getUserName()
	{
		return pro.getProperty("username");
	}
	
	public String getPassword()
	{
		return pro.getProperty("password");
	}
	
	public String getChromePath()
	{
		return pro.getProperty("chromepath");
	}

	public String getIEPath()
	{
		return pro.getProperty("iepath");
	}
	
	public String getFireFoxPath()
	{
		return pro.getProperty("firefoxpath");
	}
}
