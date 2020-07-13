package com.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.objRepository.LoginpagePF;

public class LoginApplicationTC1 {

	WebDriver driver;
	SoftAssert softAssert;
	LoginpagePF lp = null;
	String anotherEmail;
	List<String> loginList = null;
	JFrame f;

	List<String> getLoginDetails(LoginpagePF lp) {
		loginList = new ArrayList<String>();
		String loginid = lp.getAnotherEmail();
		String loginpassword = lp.getPassWord();

		loginList.add(loginid);
		loginList.add(loginpassword);

		System.out.println(loginList.toString());

		return loginList;

	}

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
		lp.email().sendKeys("marcos@gmail.com");
		lp.setAnotherEmail("marcos@gmail.com");
		lp.submit().click();

		// Thread.sleep(5000);

		if (lp.create_account_error() != null) {
			Thread.sleep(9000);

			f = new JFrame();
			lp.setAnotherEmail(JOptionPane.showInputDialog(f,
					"Please enter another email:"));
			lp.email().clear();
			lp.email().sendKeys(lp.getAnotherEmail());
			System.out.println(lp.getAnotherEmail());
			lp.submit().click();
		} else {
			System.out.println("Email is available !!!!!!!!!!!!!!!");
		}

		// Check the title of the first Heading
		softAssert
				.assertEquals(lp.PageHeading().getText(), "Create an account");
		// radio button
		if (!lp.gender().isSelected())
			lp.gender().click();
		else
			System.out.println("Gender is already selected!!!");

		// custFirstName
		lp.custFirstName().clear();
		lp.custFirstName().sendKeys("Darshan");
		// custLastName
		lp.custLastName().clear();
		lp.custLastName().sendKeys("Ingale");

		// capturing the email2
		// lp.setAnotherEmail(lp.email2().getText());
		// check email field
		softAssert.assertFalse(lp.email2().isEnabled(),
				"We skip the email ! it is already Present");

		/*
		 * if(lp.email().isEnabled()){ continue;
		 * System.out.println("Email is already present!!!!"); }else{
		 * lp.email().sendKeys("mr.dbi89@gmail.com"); } }
		 */

		// password
		lp.password().sendKeys("Dbi@89");
		lp.setPassWord("Dbi@89");

		LoginApplicationTC1 latc1 = new LoginApplicationTC1();
		latc1.getLoginDetails(lp);

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
		lp.firstname().clear();
		lp.firstname().sendKeys("Darshan");
		// enter lastname
		lp.lastname().clear();
                                                                           		// enter company
		lp.company().clear();
		lp.company().sendKeys("ABC Traders Ltd.");
		// enter Address
		lp.address1().clear();
		lp.address1().sendKeys("ABC Mart,Byk Steet,Mumbai");
		// enter city
		lp.city().sendKeys("New York");
		Thread.sleep(3000);
		// enter drop down for State
		lp.getSelectOptionsstate().selectByVisibleText("New York");
		Thread.sleep(3000);
		// enter zip postal code
		lp.postcode().sendKeys("10001");

		// Select country drop down value
		lp.getSelectOptionscountry().selectByVisibleText("United States");

		// enter mobile number
		lp.phone_mobile().sendKeys("9876565689");

		// clear and enter alias
		lp.alias().clear();
		lp.alias().sendKeys("same as above");
		// click on register button
		lp.submitAccount().click();
		Thread.sleep(3000);
		// click on logout link to again login by credentials
		lp.logOut().click();
		Thread.sleep(3000);

		softAssert.assertAll();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}