package com.juaracoding.pageobject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.CompareProduct;
import com.juaracoding.pageobject.pages.Login;
import com.juaracoding.pageobject.pages.Register;
import com.juaracoding.pageobject.pages.Search;

public class TestMain {

	public static WebDriver driver;
	private Login login;
	private Register register;
	private Search search;
	private CompareProduct compareProduct;

	@BeforeClass
	public void setUp() {
		DriverSingleton.getInstance("Chrome");
		driver = DriverSingleton.getDriver();
		String url = "https://shop.demoqa.com/";
		driver.get(url);
	}

	@BeforeMethod
	public void pageObjec() {
		register = new Register();
		login = new Login();
		search = new Search();
		compareProduct = new CompareProduct();
	}

//	TEST REGISTER
	@Test
	public void testRegister() {
		register.clickMyAccount();
		register.register("henditest", "koyago1476@yubua.com", "TestingUjian14");

	}

	@Test
	public void testiInvalidRegister() {
		register.clickMyAccount();
		register.register("", "", "");
		assertEquals(register.msgInvalidRegister(), "Error:");
	}

//	TEST LOGIN
	@Test
	public void testInvalidLogin() {
		login.login("henditest", "TestingUjian");
		assertEquals(login.msgInvalid(), "The username or password you entered is incorrect. Lost your password?");
	}

	@Test
	public void testEmtyLogin() {
		login.login("", "");
		assertEquals(login.getTxtEmpty(), "The password field is empty");
	}

	@Test
	public void testvalidaLogin() {
		login.login("henditest", "TestingUjian14");
		assertEquals(login.getTxtDashboard(), "Hello");
	}

//	TEST SEARCH
	@Test
	public void testsearch() {
		search.clickBtnSrach();
		search.inputSearch();
		
	}

//	TEST ADD COMPARE ITEM
	@Test
	public void testCompareItemOne() {
		scroll(900);
		compareProduct.compareItemOne();
		compareProduct.selectItemCompare();
		assertEquals(compareProduct.getTxtCompare(), "PINK DROP SHOULDER OVERSIZED T SHIRT");
		
		scroll(700);
		compareProduct.selectColor();
	
	}


	@AfterClass
	public void closebrowser() {
		delay(5);
		driver.quit();
	}

	static void delay(int detik) {
		try {
			Thread.sleep(1000 * detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	static void scroll(int vertical) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + vertical + ")");
	}

}
