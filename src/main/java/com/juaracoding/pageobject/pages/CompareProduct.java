package com.juaracoding.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.juaracoding.pageobject.drivers.DriverSingleton;

public class CompareProduct {
	
	public WebDriver driver;

	public CompareProduct() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='noo-product-item noo-product-sm-4 not_featured post-1497 product type-product status-publish has-post-thumbnail product_cat-t-shirt product_tag-t-shirt product_tag-women has-featured first instock shipping-taxable purchasable product-type-variable']//a[@class='compare button'][normalize-space()='Compare']")
	private WebElement choiceItemOne;
	
	@FindBy(className = "button product_type_variable add_to_cart_button")
	private WebElement selectItem;
	
	@FindBy(xpath = "//h1[@class='page-title']")
	private WebElement txtCompare;
	
	@FindBy(xpath = "//*[@id=\"pa_color\"]")
	private WebElement chooseColor;
	
	@FindBy(xpath = "//body/div[@id='noo-site']/div[@role='main']/div[@class='noo-container-fluid']/div[@class='vc_row wpb_row vc_row-fluid vc_custom_1465285769156']/div[@class='padding-stylebox wpb_column vc_column_container vc_col-sm-12 vc_col-lg-7 vc_col-md-7 vc_hidden-sm']/div[@class='vc_column-inner vc_custom_1465550709194']/div[@class='wpb_wrapper']/div[@class='noo-shortcode-product-wrap']/div[@class='noo-sh-product-grid woocommerce ']/div[@class='noo-sh-product-html columns_3 no_masonry three row is-flex']/div[2]/div[1]/div[1]/div[1]/div[1]/a[1]")
	private WebElement choiceItemTwo;
	
	public void compareItemOne() {
		choiceItemOne.click();
	}
	
	public void selectItemCompare() {
		selectItem.click();
	}
	
	public String getTxtCompare() {
		return txtCompare.getText();
	}
	
	public void selectColor() {
		Select select = new Select(chooseColor);
		select.selectByValue("pink");
	}

}
