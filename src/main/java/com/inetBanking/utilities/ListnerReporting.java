package com.inetBanking.utilities;

import java.io.File;
import java.io.IOException;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerReporting implements ITestListener {
	
	public ExtentReports extent;
	public ExtentTest logger;
	
		
	public void onStart(ITestContext testContext)
	{
		/*String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";
	    ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "\\test-output\\"+ repName);//specify location of the report
		//reporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		
		

		
		/*String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String repName="Test-Report-"+timeStamp+".html";*/
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setDocumentTitle("InetBanking Test Project"); // Tile of report
		reporter.config().setReportName("Functional Test Automation Report"); // name of the report
		reporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Test engineer", "Krishna Pandit");
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Enviroment","QA");
		
		
	}
	
	public void onTestStart(ITestResult result) {
		
		logger= extent.createTest(result.getMethod().getMethodName());// create new entry in th report
			
	}
	
	public void onTestSuccess(ITestResult result)
	{
		
		logger.log(Status.PASS, result.getThrowable());
	}
	
	public void onTestFailure(ITestResult result)
	{
	
		logger.log(Status.FAIL, result.getThrowable());
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+result.getMethod().getMethodName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		}
		
	}
	
	public void onTestSkipped(ITestResult result)
	{	
		logger.log(Status.SKIP, result.getThrowable());
	}
	
	public void onFinish(ITestContext testContext)
	{
		extent.flush();
	}

	

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

}
