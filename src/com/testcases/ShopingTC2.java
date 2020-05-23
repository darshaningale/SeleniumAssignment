package com.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.objRepository.LoginpagePF;
import com.objRepository.ShoppingPF;

public class ShopingTC2  {
	
	WebDriver driver;
	SoftAssert softAssert;
	LoginpagePF lp; 
	ShoppingPF sp;
	String anotherEmail;
	List<String> lpList;
	String ProductName,ProductPrie,ProductQuantity,ProductSize;

	@BeforeTest
	public void init() throws InterruptedException {
		// System.out.println("hello java");

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");

		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		softAssert = new SoftAssert();

		/*String title = "My Store";
		String str = driver.getTitle();
		softAssert = new SoftAssert();
		softAssert.assertEquals(str, title);
		System.out.println("Title:" + str);

		Thread.sleep(3000);

		softAssert.assertAll();
*/
	}
	
	@Test
	public void shopping() throws InterruptedException {
		
		
		
		System.out.println("ShopingTC2");
		// Click on Sign in link
		lp = new LoginpagePF(driver);
		lp.signIn().click();
		
		Thread.sleep(3000);
		
		lp.email2().sendKeys("Marcos11@gmail.com");
		lp.password().sendKeys("Dbi@89");
		
		lp.setAnotherEmail("Marcos11@gmail.com");
		lp.setPasswd("Dbi@89");
		
		lp.signIn_btn().click();
		
		
		//click on Women Link
		sp = new ShoppingPF(driver);
		sp.womenMenu().click();
		
		Thread.sleep(3000);
		//Scroll to product image
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sp.productImage());
		
		Thread.sleep(3000); 
		//move to element to Quick view mouse hover button
		Actions action = new Actions(driver);
		action.moveToElement(sp.productImage()).moveToElement(sp.quickView()).click().build().perform();
		
		Thread.sleep(3000); 
		//switch to the product frame
		
		driver.switchTo().frame(0);
		
		//fetch and display product name
		 ProductName = sp.ProductTitle().getText();
		System.out.println(ProductName);
		//fetch and display product Price
		 ProductPrie = sp.productPrice().getText();
		System.out.println(ProductPrie);
		Thread.sleep(3000); 
		//Select Quantity of the product		
		sp.productPlus().click();
		 ProductQuantity = sp.productQty().getText();
		System.out.println(ProductQuantity);
		
		Thread.sleep(3000); 
		//select size of product
		sp.getSelectOptionsproductSize().selectByVisibleText("M");
		 ProductSize = sp.getSelectOptionsproductSize().getFirstSelectedOption().getText();
		System.out.println(ProductSize);
		
		
		//Add To cart product
		
		sp.addToCart().click();
		
		Thread.sleep(3000); 
		
		
		//Checkout Summary
		
		//Product Title entry and visible on page
		String ActualProductTitle = sp.actualProductTitle().getText();
		System.out.println(ActualProductTitle);
		softAssert.assertEquals(ProductName,ActualProductTitle ,"Product Name is not same !");
		//Product Size entry and visible on page 
		String ActualProductSize = sp.actualProductSize().getText();
		System.out.println(ActualProductSize);
		//softAssert.assertEquals(ProductSize,ActualProductSize ,"Product Size is not same !");
		//Product ProductQuantity entry and visible on page '
		String ActualProductQty = sp.actualProductQty().getText();
		System.out.println(ActualProductQty);
	//	softAssert.assertEquals(ProductQuantity,ActualProductQty ,"Product Quantity is not same !");
		//Product ProductPrie entry and visible on page ']
		String ActualProductPrice = sp.actualProductPrice().getText();
		System.out.println(ActualProductPrice);
		//softAssert.assertEquals(ProductPrie,ActualProductPrice ,"Product Price is not same !");
		
		//Product ProductPrie entry and visible on page 
		String TargetExpPrice = sp.actualProductPrice().getText();
		System.out.println("Check"+ActualProductPrice +"and "+ TargetExpPrice);
		
		//softAssert.assertEquals(ActualProductPrice,TargetExpPrice,"Product Price for  is not same !");
				
		//product total shiping
		String TotalShipCost  = sp.targetTotalShiping().getText();
		System.out.println("Total Shipping Cost:"+TotalShipCost);
		//included shipping total Cost
		String TotalCost  = sp.targetTotalCost().getText();
		System.out.println("Total Cost with shipping cost :"+TotalCost);
		
		Thread.sleep(3000); 
		//Proceed to check out
		sp.proceedToCheckout().click();
		
		Thread.sleep(3000); 
		
		System.out.println("<-------------Here we check the Checout page values with entered Values-------------->");
		//checkout page Qty 
		//String productQtyPage =sp.ProductQtyCheckout().getText();
		//System.out.println("Checkout page Qty : "+productQtyPage);
		//softAssert.assertEquals(ActualProductQty, productQtyPage, "Total Quantity on checkout page is not same !");
		
		//checkout page total price comparison
		System.out.println("++++checkout page total price comparison++++");
		String productPriceChecoutPage = sp.totalPriceCheckout().getText();
		System.out.println("Checkout page price :"+productPriceChecoutPage);
		softAssert.assertEquals(ActualProductPrice, productPriceChecoutPage,"Checkout page Product price is not match!!!");
	
		Thread.sleep(3000); 
		//proceed to checkout
		sp.ptcBtnCheckout().click();
		
		//3.address check P T C
		System.out.println("3.address check P T C  stage ----------->");
		sp.addressPTCheckoutBtn().click();
		
		//4.shipping 
		System.out.println("4. shipping stage ------------>");
		//check box click
		sp.shippingCheckbox().click();
		//ptc button click
		sp.shippingPTCheckoutBtn().click();
		
		//5.Payment Stage 
		System.out.println("5.Payment Stage  ------------>");
		System.out.println("Checking final total cost of 2 products--> ");
		String PaymentFinalPrice = sp.paymentFinaltotalPrice().getText();
		System.out.println("Checking final Grand total cost with shipping---> ");
		String PaymentFinalGrandPrice = sp.paymentGrandTotlaPrice().getText();
		
		//total payment stage cost
		softAssert.assertEquals(PaymentFinalPrice, productPriceChecoutPage, "Total cost is not same on Payment stage !");
		//Grand total payment stage cost
		softAssert.assertEquals(PaymentFinalGrandPrice, TotalCost, "Total Grand cost is not same on Payment stage !");
						
		//click on BankWire payment option 
		sp.paymentOptBankWire().click();
		
		//Order summary page
		System.out.println("Order summary page----------->");
		
		String OrderSummaryFinalPrice = sp.orderSummaryfinalPrice().getText();
		
		//checking the order summary page price is same or not !
		softAssert.assertEquals( OrderSummaryFinalPrice, PaymentFinalGrandPrice, "Total cost is not same on Payment Order Summary page !");
		
		//I confirm my order
		sp.orderSummarySubmit().click();
		
		//Go to profile page and select order summary page and check price 
		
		sp.goToProfile().click();
		
		//Go to Orders summary page
		sp.goToOrdersPage().click();
		
		//check the order price is valid or not
		
		int count = sp.orderPricelist().size();
		String price = sp.orderPricelist().get(count-1).getText();
		System.out.println("Order summary price Check :"+price);
		
		softAssert.assertEquals( price, PaymentFinalGrandPrice, "Total cost is not same on Order Summary page !");
		
		
		
		Thread.sleep(5000); 
	
		
		/*LoginApplicationTC1 latc1 =new LoginApplicationTC1();
		lpList = new ArrayList<String>();
		
		lpList = latc1.getLoginDetails(lp);
		
		for(String str : lpList){
			
			System.out.println(str);
		}
		String newEmailID = lpList.get(0).toString();
		String password = lpList.get(1).toString();
		
		lp.email2().sendKeys(newEmailID);
		lp.password().sendKeys(password);*/
		
		
		
		
		
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		softAssert.assertAll();
	}
	
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
