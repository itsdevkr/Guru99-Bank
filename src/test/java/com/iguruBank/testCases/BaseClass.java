package com.iguruBank.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.iguruBank.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();

	public String baseURL = readConfig.getApplicationURL();
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",readConfig.getChromepath());
			driver = new ChromeDriver();
			}
			else if(br.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver",readConfig.getFirefoxpath());
				driver = new FirefoxDriver();
			}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}
	@AfterClass
	public void tearDown() {
		
		driver.quit();
	}
	
	
}
