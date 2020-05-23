package com.objRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ShoppingPF {

	WebDriver driver;
	String emailid, passWord;

	public ShoppingPF(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ShoppingPF(String emailid, String passWord) {
		this.emailid = emailid;
		this.passWord = passWord;

	}

	// Women shopping
	@FindBy(linkText = "Women")
	WebElement womenMenu;
	@FindBy(xpath = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line first-item-of-tablet-line first-item-of-mobile-line']//img[@alt ='Faded Short Sleeve T-shirts']")
	WebElement productImage;
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[1]/div[1]/a[2]")
	WebElement quickView;
	String anotherEmail;

	String passwd;
	@FindBy(xpath = "//h1[contains(text(),'Faded Short Sleeve T-shirts')]")
	WebElement ProductTitle;
	@FindBy(xpath = "//span[@id='our_price_display']")
	WebElement productPrice;

	// + button
	@FindBy(xpath = "//i[@class='icon-plus']")
	WebElement productPlus;

	//Quantity 
	@FindBy(xpath="//input[@id='quantity_wanted']")
	WebElement productQty;

	// Dropdown

	@FindBy(xpath = "//select[@id='group_1']")
	WebElement productSize;

	// after logout again login by register email and password and click on sign
	// in button
	@FindBy(xpath = "//button[@name='Submit']")
	WebElement addToCart;

	//after add to cart page validate details with actual value
	@FindBy(xpath="//span[@id='layer_cart_product_title']")
	WebElement actualProductTitle;
	@FindBy(id="layer_cart_product_attributes")
	WebElement actualProductSize;
	@FindBy(xpath="//span[@id='layer_cart_product_quantity']")
	WebElement actualProductQty;
	@FindBy(xpath="//span[@id='layer_cart_product_price']")
	WebElement actualProductPrice;

	//expected value of price in checkout panel
	@FindBy(xpath="//span[@class='ajax_block_products_total']")
	WebElement targetExpPrice;

	//total shipping
	@FindBy(xpath="//span[@class='ajax_cart_shipping_cost']")
	WebElement targetTotalShiping;

	//total cost including total shiping
	@FindBy(xpath="//span[@class='ajax_block_cart_total']")
	WebElement targetTotalCost;

	//Proceed To Checkout button click
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckout;

	// Checkout page ------------------------------------------------------->

	//total product price
	@FindBy(id = "total_product_price_1_3_324689")
	WebElement totalPriceCheckout;

	//total quantity 
	@FindBy(xpath = "//input[@value ='4'][2]")
	WebElement ProductQtyCheckout;

	//button submit (proceed to checkout)
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")
	WebElement ptcBtnCheckout;


	//button submit(3.address)
	@FindBy(xpath = "//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")
	WebElement addressPTCheckoutBtn;



	//button submit(4.shipping stage check box)
	@FindBy(id = "cgv")
	WebElement shippingCheckbox;


	//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]

	//button submit(4.shipping stage check box)
	@FindBy(xpath = "//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement shippingPTCheckoutBtn;

	//5.Payment stage
	@FindBy(id="total_product_price_1_3_324689")
	WebElement paymentFinaltotalPrice;
	@FindBy(xpath="//span[@id='total_price']")
	WebElement paymentGrandTotlaPrice;
	@FindBy(xpath="//a[@class='bankwire']")
	WebElement paymentOptBankWire;
	//after bank wire order summary page
	@FindBy(xpath="//span[@id='amount']")
	WebElement orderSummaryfinalPrice;
	//I confirm my order
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	WebElement orderSummarySubmit;
	//go to profile page 
	@FindBy(xpath="//a[@class='account']")
	WebElement goToProfile;
	
	//go to profile page 
	@FindBy(xpath="//a[@title='Orders']")
	WebElement goToOrdersPage;
	
	//check order price
	@FindBy(xpath="//tr[contains(@class,'first_item')]//td[@class='history_price']")
	List<WebElement> orderPricelist;



	// Login Link
	public WebElement womenMenu() {
		return womenMenu;
	}

	public WebElement productImage() {
		return productImage;
	}

	public WebElement quickView() {
		return quickView;
	}

	public String getAnotherEmail() {
		return anotherEmail;
	}

	public void setAnotherEmail(String anotherEmail) {
		this.anotherEmail = anotherEmail;
	}

	public String getPasswd() {
		return passwd;
	}

	public String setPasswd(String passwd) {
		return passwd;
	}

	public WebElement ProductTitle() {
		return ProductTitle;
	}

	public WebElement productPrice() {
		return productPrice;
	}

	public WebElement productPlus() {
		return productPlus;
	}

	public WebElement productQty() {
		return productQty;
	}

	public Select getSelectOptionsproductSize() {
		return new Select(productSize);
	}
	public WebElement addToCart(){
		return addToCart;
	}

	//actual product Details

	public WebElement actualProductTitle(){
		return actualProductTitle;
	}
	public WebElement actualProductSize(){
		return actualProductSize;
	}
	public WebElement actualProductQty(){
		return actualProductQty;
	}
	public WebElement actualProductPrice(){
		return actualProductPrice;
	}

	//exptected value check in checkout panel

	public WebElement targetExpPrice(){
		return targetExpPrice;

	}

	public WebElement targetTotalShiping(){
		return targetTotalShiping;

	}
	public WebElement targetTotalCost(){
		return targetTotalCost;

	}

	//checkout page ------------------------------------------->

	public WebElement proceedToCheckout(){
		return proceedToCheckout;

	}
	public WebElement totalPriceCheckout(){
		return totalPriceCheckout;

	}
	public WebElement ProductQtyCheckout(){
		return ProductQtyCheckout;

	}
	public WebElement ptcBtnCheckout(){
		return ptcBtnCheckout;

	}

	public WebElement addressPTCheckoutBtn(){
		return addressPTCheckoutBtn;

	}

	public WebElement shippingCheckbox(){
		return shippingCheckbox;

	}

	public WebElement shippingPTCheckoutBtn(){
		return shippingPTCheckoutBtn;

	}

	//payment  stage final price
	public WebElement paymentFinaltotalPrice(){
		return paymentFinaltotalPrice;

	}
	//paymentGrand Total
	public WebElement paymentGrandTotlaPrice(){
		return paymentGrandTotlaPrice;

	}
	//paymentGrand Total
	public WebElement paymentOptBankWire(){
		return paymentOptBankWire;

	}
	//order summary final price
	public WebElement orderSummaryfinalPrice(){
		return orderSummaryfinalPrice;

	}

	//order summary final price
	public WebElement orderSummarySubmit(){
		return orderSummarySubmit;

	}
	
	//Go to profile page
		public WebElement goToProfile(){
			return goToProfile;

		}
	
	//Go to profile page
	public WebElement goToOrdersPage(){
		return goToOrdersPage;

	}
	
	//Go to order price
		public List<WebElement> orderPricelist(){
			return orderPricelist;

		}
}
