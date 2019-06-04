package com.avtech.mercury.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.avtech.mercury.data.RegistrationPageData;

public class RegistrationPage {
	private WebDriver driver;

	@FindBy(name = "firstName")
	private WebElement firstname;
	@FindBy(name = "lastName")
	private WebElement lastname;
	@FindBy(name = "phone")
	private WebElement phone;
	@FindBy(name = "userName")
	private WebElement email;
	@FindBy(name = "address1")
	private WebElement address;
	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "country")
	private WebElement countryDD;
	@FindBy(name = "register")
	private WebElement submit;

//constructor	
	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String fName) {
		firstname.clear();
		firstname.sendKeys(fName);
	}

	public void selectCountry(String country) throws InterruptedException {
		new Select(countryDD).selectByVisibleText(country);
		Thread.sleep(2000);
	}

	public void enterLastName(String lName) {
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.name("lastName")).sendKeys(lName);
	}

	public void enterPhoneNumber(String phone) {
		driver.findElement(By.name("phone")).sendKeys(phone);
	}

	public void enterEmail(String email) {
		driver.findElement(By.name("userName")).sendKeys(email);
	}

	public void enterAddress(String address) {
		driver.findElement(By.name("address1")).sendKeys(address);
	}

	public void enterCity(String city) {
		driver.findElement(By.name("city")).clear();
		;
		driver.findElement(By.name("city")).sendKeys(city);
	}

	public void enterZipCode(String zipcode) {
		driver.findElement(By.name("postalCode")).sendKeys(zipcode);
	}

	public void enterCountry() {
		// driver.findElement(By.name("country"));
		Select country = new Select(driver.findElement(By.name("country")));
		country.selectByVisibleText("UNITED STATES");
	}
	
	public void enterCountryFromData(String countryName) {
		List <WebElement> countries = driver.findElements(By.cssSelector("option[value]"));
		for(WebElement c : countries) {
			String fromList = c.getText().replace(" ", "");
			String cNModified = countryName.replace(" ", "");
			if (fromList.compareToIgnoreCase(cNModified))
				//country.sendKeys(country.getText());
				//Select country = new Select(driver.findElement(By.));
			//countries.
				countries.forEach(action);
		}
	}

	public void getCountryOptions() {
		List<WebElement> lists = driver.findElements(By.cssSelector("option[value]"));
		for (WebElement el : lists) {
			String countryValue = el.getText();
			String attributeValue = el.getAttribute("value");
			System.out.println("countryValue - " + countryValue + "attributeValue - " + attributeValue);
		}
	}

	public void enterUserName(String userName) {
		driver.findElement(By.name("email")).clear();
		driver.findElement(By.name("email")).sendKeys(userName);
	}

	public void enterPassword(String password) {
		driver.findElement(By.name("password")).sendKeys(password);
	}

	public AccountsPage submit() {
		waitElementToBeClickable(submit);
		submit.click();
		return new AccountsPage(driver);
	}

	public void waitElementToBeClickable(WebElement button) {
		// find locator for time no more than 5 seconds
		new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(button));
	}

	public void actionExample() {
		Actions action = new Actions(driver);
		action.click(submit).build().perform();
	}

	public void fillOutRegistrationPage(RegistrationPageData data) throws InterruptedException {
		enterFirstName(data.firstName);
		enterLastName(data.lastName);
		enterCity(data.city);
		enterUserName(data.userName);
//	enterCountry();
		Thread.sleep(1000);
		submit();

	}

}
