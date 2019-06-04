package com.avtech.mercury.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountsPage {
	WebDriver driver;
	
	@FindBy(css = "table:nth-child(1) table:nth-child(1) table:nth-child(1)  table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(1) > p:nth-child(2) > font:nth-child(1)")
	private WebElement thankYouText;

	public AccountsPage(WebDriver driver1) {
		this.driver = driver1;
		PageFactory.initElements(driver1, this);
	}

	public String getThankYouText() throws InterruptedException {
		Thread.sleep(1000);
		return thankYouText.getText();
	}
	
	
}

