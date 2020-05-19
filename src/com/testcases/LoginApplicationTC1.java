package com.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.objRepository.LoginpagePF;

public class LoginApplicationTC1 {

	WebDriver driver;
	SoftAssert softAssert;
	LoginpagePF lp = null;

	@BeforeTest
	public void init() throws InterruptedException {
		// System.out.println("hello java");

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		String title = "My Store";
		String str = driver.getTitle();
		softAssert = new SoftAssert();
		softAssert.assertEquals(str, title);
		System.out.println("Title:" + str);

		Thread.sleep(3000);

		softAssert.assertAll();

	}

	@Test
	public void Login() throws InterruptedException {

		lp = new LoginpagePF(driver);
		// Click on Sign in link
		lp.signIn().click();

		Thread.sleep(3000);

		// Enter the email Id and Submit
		lp.email().sendKeys("mr.dbi89@gmail.com");
		lp.submit().click();
		// Check the title of the first Heading
		softAssert
				.assertEquals(lp.PageHeading().getText(), "Create an account");
		// radio button
		if (!lp.gender().isSelected())
			lp.gender().click();
		else
			System.out.println("Gender is already selected!!!");

		// custFirstName
		lp.custFirstName().sendKeys("Darshan");
		// custLastName
		lp.custLastName().sendKeys("Ingale");

		// check email field
		softAssert.assertTrue(lp.email2().isEnabled(),
				"We skip the email ! it is already Present");

		/*
		 * if(lp.email().isEnabled()){ continue;
		 * System.out.println("Email is already present!!!!"); }else{
		 * lp.email().sendKeys("mr.dbi89@gmail.com"); } }
		 */

		// password
		lp.password().sendKeys("Dbi@89");
		Thread.sleep(3000);
		// Select drop down value for day
		lp.getSelectOptionsday().selectByValue("8");
		Thread.sleep(3000);
		// Select drop down value for Month
		lp.getSelectOptionsmonth().selectByValue("12");
		Thread.sleep(3000);
		// Select drop down value for year
		lp.getSelectOptionsyear().selectByValue("1989");
		Thread.sleep(3000);
		// click on check box
		lp.newsletter().click();

		// click on optin special offer
		lp.optin().click();

		// check page sub heading | Your address
		softAssert.assertEquals(lp.pageSubHeading().getText(), "Your address");

		// enter firstname
		lp.firstname().sendKeys("Darshan");
		// enter lastname
		lp.lastname().sendKeys("Ingale");
		// enter company
		lp.company().sendKeys("ABC Traders Ltd.");
		// enter Address
		lp.address1().sendKeys("ABC Mart,Byk Steet,Mumbai");
		// enter city
		lp.city().sendKeys("New York");
		Thread.sleep(3000);
		// enter drop down for State
		lp.getSelectOptionsstate().selectByVisibleText("New York");
		Thread.sleep(3000);
		// enter zip postal code
		lp.postcode().sendKeys("10001");
		Thread.sleep(3000);
		// Select country drop down value
		lp.getSelectOptionscountry().selectByVisibleText("United States");

		// enter mobile number
		lp.phone_mobile().sendKeys("9876565689");
		// click on regiter button
		lp.submitAccount().click();

		softAssert.assertAll();

	}
}