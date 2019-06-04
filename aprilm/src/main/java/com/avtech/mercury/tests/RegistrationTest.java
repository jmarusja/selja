package com.avtech.mercury.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
//using Maven repository we do not need to create 
//resources in project. instead we create 
//pom.xml file with dependencies

import com.avtech.mercury.data.ReadExcel;
import com.avtech.mercury.data.RegistrationPageData;

//	page object model -> packages
//	pages -> locators & actions
//	test -> test steps
//	data -> test data(inputs and outputs)

public class RegistrationTest extends SharedFunction {// start class name with Capital letter
//	protected WebDriver driver;// this modifier makes the method also accessible from the whole package
// using testng.xml(RegistrationTest > right click > testng > convert >
// create .xml file > make it works for 2 browsers) 
// to run 2 tests in parallel for 2 browser > run testng.xml

	@Test(groups = { "Sanity", "Regression" }) // annotation dzone.com,jaxenter.com
	public void testing() throws InterruptedException {
		SoftAssert sf = new SoftAssert();

		int sizeOfRows = readExl.rows.size();
//		regPage.enterFirstName("Niki");
//		regPage.enterLastName("Shah");
//		regPage.enterCountry();
//		regPage.submit();
		for (int row = 1; row < sizeOfRows; row++) {
			goToRegistrationPage();
			// describe dataObject
			RegistrationPageData dataObject = new RegistrationPageData();
			dataObject.firstName = readExl.getExlDataByName("FirstName", row);
			dataObject.lastName = readExl.getExlDataByName("LastName", row);
			dataObject.city = readExl.getExlDataByName("City", row);
			dataObject.userName = readExl.getExlDataByName("UserName", row);
			regPage.fillOutRegistrationPage(dataObject);
		}

		String thankYouText = accPage.getThankYouText();
		String thankYouExpected = "Thank you for registering. You may now sign-in using the user name and password you've just entered.";
		System.out.println(thankYouText);
		sf.assertEquals(thankYouText, thankYouExpected);// soft Assert
		sf.assertAll();
	}

	@Test(groups = "Regression", priority = 1, dependsOnMethods = "testing", alwaysRun = true, description = "R.101,R.34") // annotation
	// dzone.com,jaxenter.com
	// TC909-test case ID to know which one is automated
	public void TC909_testing2() throws InterruptedException {
		regPage.enterFirstName("Mini");
		regPage.enterLastName("Smith");
		regPage.getCountryOptions();
//instead of submit.click we use here action.click though it's not always work
		regPage.actionExample();
		String thankYouText = accPage.getThankYouText();
		String thankYouExpected = "Thank you for registering. You may now sign-in using the user name and password you've just entered.";
		System.out.println(thankYouText);
		Assert.assertEquals(thankYouText, thankYouExpected);// hard Assert
	}
}
