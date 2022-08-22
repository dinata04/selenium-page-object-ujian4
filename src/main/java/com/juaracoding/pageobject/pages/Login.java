package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class Login {

	public WebDriver driver;

	public Login() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@name='login']")
	private WebElement btnLogin;

	@FindBy(xpath = "//div[@id='primary']//li[1]")
	private WebElement msgError;

	@FindBy(xpath = "//p[contains(text(),'Hello')]")
	private WebElement txtDashboard;

	@FindBy(xpath = "//div[@id='primary']//li[1]")
	private WebElement empty;

//		Scenario
	public void login(String username, String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		btnLogin.click();

	}

//			Actual
	public String msgInvalid() {
		return msgError.getText();
	}

	public String getTxtDashboard() {
		return txtDashboard.getText();
	}

	public String getTxtEmpty() {
		return empty.getText();
	}

}
