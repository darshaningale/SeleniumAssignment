package com.objRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginpagePF {
	
	WebDriver driver;
	String emailid,passWord;
	
	public LoginpagePF(WebDriver driver){
		
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
	}
	
	public LoginpagePF(String emailid,String passWord){
		this.emailid = emailid;
		this.passWord = passWord;
		
	}
	
	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	//Login Link
	@FindBy(xpath="//a[@class='login']")
	WebElement signIn;
	@FindBy(id="email_create")
	WebElement email;
	@FindBy(id="create_account_error")
	WebElement create_account_error;
	 String anotherEmail;
	


	String passwd;
	@FindBy(id="SubmitCreate")
	WebElement submit;   
	@FindBy(xpath="//h1[contains(text(),'Create an account')]")
	WebElement PageHeading;
	
	//CREATE AN ACCOUNT
	
	//radio button
	@FindBy(id="id_gender1")
	WebElement gender; 
	
	//TextField
	@FindBy(id="customer_firstname")
	WebElement custFirstName; 
	@FindBy(id="customer_lastname")
	WebElement custLastName; 
	@FindBy(id="email")
	WebElement email2;
	@FindBy(id="passwd")
	WebElement password;
	
	
	
	//Dropdown
	
	@FindBy(id="days")
	WebElement dayList; 
	@FindBy(id="months")
	WebElement monthList; 
	@FindBy(id="years")
	WebElement yearList; 
	
	//checkboxes
	@FindBy(id="newsletter")
	WebElement newsletter;
	@FindBy(id="optin")
	WebElement optin; 
	
	//YOUR ADDRESS
	@FindBy(xpath="//h3[contains(text(),'Your address')]")
	WebElement pageSubHeading;
	
	@FindBy(id="firstname")
	WebElement firstname; 
	@FindBy(id="lastname")
	WebElement lastname; 
	@FindBy(id="company")
	WebElement company; 
	@FindBy(id="address1")
	WebElement address1; 
	@FindBy(id="city")
	WebElement city; 
	@FindBy(id="id_state")
	WebElement stateList; 
	@FindBy(id="postcode")
	WebElement postcode; 
	@FindBy(id="id_country")
	WebElement countryList; 
	@FindBy(id="phone_mobile")
	WebElement phone_mobile; 
	@FindBy(id="alias")
	WebElement alias; 
	@FindBy(id="submitAccount")
	WebElement register; 
	@FindBy(xpath="//a[@class='logout']")
	WebElement logOut; 
	
	//after logout again login by register email and password and click on sign in button
	@FindBy(id="SubmitLogin")
	WebElement signIn_btn;
	
	
   //Login Link
   public WebElement signIn()
   {
	   return signIn;
   }
         
   public WebElement email()
   {
	   return email;
   }
   public WebElement create_account_error()
   {
	   return create_account_error;
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

public WebElement submit()
   {
	   return submit;
   }
   
   public WebElement PageHeading()
   {
	   return PageHeading;
   }
   
   ////CREATE AN ACCOUNT
   public WebElement gender()
   {
	   return gender;
   }
   
   public WebElement custFirstName()
   {
	   return custFirstName;
   }
   
   public WebElement custLastName()
   {
	   return custLastName;
   }
   public WebElement email2()
   {
	   return email2;
   }
   public WebElement password()
   {
	   return password;
   }
   
   

   public Select getSelectOptionsday() {
     return new Select(dayList);
   }
   public Select getSelectOptionsmonth() {
	     return new Select(monthList);
	   }
   public Select getSelectOptionsyear() {
	     return new Select(yearList);
	   }
   
  
   
   public WebElement newsletter()
   {
	   return newsletter;
   }
   
   public WebElement optin()
   {
	   return optin;
   }
   //YOUR ADDRESS

   public WebElement pageSubHeading()
   {
	   return pageSubHeading;
   }
   
   public WebElement firstname()
   {
	   return firstname;
   }
   public WebElement lastname()
   {
	   return lastname;
   }
   public WebElement company()
   {
	   return company;
   }
   public WebElement address1()
   {
	   return address1;
   }
   public WebElement city()
   {
	   return city;
   }
   
   public Select getSelectOptionsstate() {
	     return new Select(stateList);
	   }
   
   public WebElement postcode()
   {
	   return postcode;
   }
   public Select getSelectOptionscountry() {
	     return new Select(countryList);
   }
   
   public WebElement phone_mobile()
   {
	   return phone_mobile;
   }
   public WebElement alias()
   {
	   return alias;
   }
   public WebElement submitAccount()
   {
	   return register;
   }
   
   //login link 
   public WebElement logOut()
   {
	   return logOut;
   }
   
   //signIn button click
   public WebElement signIn_btn()
   {
	   return signIn_btn;
   }


   
   
}
