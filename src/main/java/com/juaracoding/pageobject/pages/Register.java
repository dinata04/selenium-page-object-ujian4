package com.juaracoding.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class Register {
	
public WebDriver driver;
	
	public Register() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(xpath = "//a[normalize-space()='My Account']")
	private WebElement myAccount;
	
	@FindBy(xpath = "//input[@id='reg_username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='reg_email']")
	private WebElement email;
	
	@FindBy(xpath = "//input[@id='reg_password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@name='register']")
	private WebElement btnRegister;
	
	@FindBy(xpath = "//strong[normalize-space()='Error:']")
	private WebElement emptyRegister;
	
	public void clickMyAccount() {
		myAccount.click();
	}
	
	
	public void register(String username, String email, String password) {
		this.username.sendKeys(username);
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		btnRegister.click();
	}
	
	public String msgInvalidRegister() {
		return emptyRegister.getText();
	}

}
