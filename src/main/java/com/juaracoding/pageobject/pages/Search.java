package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class Search {
	
	public WebDriver driver;

	public Search() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='noo-search']")
	private WebElement clickSearch;
	
	@FindBy(xpath = "//input[@name='s']")
	private WebElement inputSearch;
	
	public void clickBtnSrach() {
		clickSearch.click();
	}
	
	public void inputSearch() {
		inputSearch.sendKeys("Dress \n");
	}
	
	
	


}
