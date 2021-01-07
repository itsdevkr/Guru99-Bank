package com.iguruBank.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extentReportDemo {
	
	@Test
	public void signInTest() {
		
		System.out.println("Login to amazon");
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd::HH:mm:ss").format(new Date());
		String repName = "Test-Report-"+timeStamp+".html";
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+repName);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		
		ExtentTest logger = extent.createTest("signInTest");
		logger.log(Status.INFO, "Login to amazon");
		logger.log(Status.INFO, "Title verified");
		
		extent.flush();
	}

}
