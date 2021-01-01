package com.iguruBank.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(xpath="//input[@type='password']")
	@CacheLookup
	WebElement txtPassword;
		
	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[@href='Logout.php']")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}
}
