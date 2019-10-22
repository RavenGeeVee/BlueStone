package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.IAutoConstants;

public class TenplusmonthlyPage implements IAutoConstants {
	
	WebDriver driver;
	
	@FindBy(xpath="//input[@id='gmsStart']") private WebElement start;
	@FindBy(xpath="//input[@id='amount']") private WebElement amount;
	@FindBy(xpath="//input[@name='_eventId_savePersonalAddressDetails']") private WebElement next;
	@FindBy(xpath="//input[@name='_eventId_checkoutSaveAddressDetails']") private WebElement nextnominee;
	
	@FindBy(id="Email") private WebElement email;
	@FindBy(xpath="//input[@id='contactNumber']") private WebElement mobilenumber;
	@FindBy(xpath="//input[@id='contactNumber']") private WebElement fullname;
	@FindBy(xpath="//textarea[@id='address']") private WebElement address;
	@FindBy(xpath="//input[@id='postcode_delivery']") private WebElement pincode;
	@FindBy(xpath="//input[@id='nomineeName']") private WebElement nominee;
	
	
	public void clickStartNow() {
		start.click();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	public void clickNext() {
		next.click();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	
	public void clickNextinNominee() {
		nextnominee.click();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	public void enterAmount(String amt) {
		amount.sendKeys(amt);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	public void enterEmail(String eml) {
		email.sendKeys(eml);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	
	public void enterMobileNumber(String number) {
		mobilenumber.clear();
		mobilenumber.sendKeys(number);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	
	public void enterFullName(String full) {
		fullname.click();
		fullname.sendKeys(full);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	
	public void enterAddress(String add) {
		address.sendKeys(add);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	public void enterPincode(String pin) {
		pincode.sendKeys(pin);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	
	public void enterNominee(String nomi) {
		nominee.sendKeys(nomi);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	
     public TenplusmonthlyPage(WebDriver driver){
    	 
    	 PageFactory.initElements(driver, this);
    	 this.driver = driver;
    	 
     }
}
