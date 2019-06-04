package com.avtech.mercury.tests;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.avtech.mercury.data.ReadExcel;

public class SharedFunction {
	private WebDriver driver;
	protected RegistrationPage regPage;
	protected AccountsPage accPage;
	protected ReadExcel readExl;
	
	@Parameters("browser")	
    @BeforeClass(alwaysRun=true)
	public void setUp(@Optional("firefox") String browser) throws InterruptedException, InvalidFormatException, IOException {
		// public void setUp(){
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "null");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver_74.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		regPage = new RegistrationPage(driver);
		accPage = new AccountsPage(driver);
		readExl = new ReadExcel("G:\\Selenium\\workspace\\aprilmercuryproject\\mercury_inputs\\RegistrationData.xlsx");
	}

@BeforeMethod(alwaysRun=true)//always use(alwaysRun=true) when you use groups
public void goToRegistrationPage(){
	driver.get("http://newtours.demoaut.com/mercuryregister.php");
}

@AfterClass(alwaysRun=true)
public void tearDown(){
	driver.quit();
}
}
