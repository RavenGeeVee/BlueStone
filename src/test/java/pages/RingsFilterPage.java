package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.IAutoConstants;

public class RingsFilterPage implements IAutoConstants {
	
	WebDriver driver;
	
	@FindBy(xpath="//section[@id='Price-form']//div[contains(@class,'form-items')]//div[1]")
	private WebElement below10kprice;
	@FindBy(xpath="//section[@id='Price-form']//span[@class='title style-fill i-right']")
	private WebElement hprice;
	@FindBy(xpath="//section[contains(@class,'block active')]//div[contains(@class,'form-item last')]")
	private WebElement platinum;
	@FindBy(xpath="//span[@class='title style-fill i-right']//span[contains(text(),'Metal')]")
	private WebElement hmetal;
	@FindBy(xpath="//div[contains(@class,'form-items')]//div[contains(@class,'form-item')]//div[contains(@class,'form-item')]")
	private WebElement nextday;
	@FindBy(xpath="//span[@class='title style-fill i-right']//span[contains(text(),'Delivery Time')]")
	private WebElement hnextday;
	@FindBy(xpath="//span[@class='style-fill title']")
	private WebElement morefilter;
	@FindBy(xpath="//section[@id='Gender-form']")
	private WebElement hgender;
	@FindBy(xpath="//div[contains(@class,'bs-tt bs-tt-tl bs-tt-sq bs-tt-blue active')]/form[@id='gender']/div[contains(@class,'form-items')]/div[1]/span[1]")
	private WebElement gender;
	
	
	public void clickPrice() {
		below10kprice.click();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	public void hoverPrice() {
		Actions act = new Actions(driver);
		act.moveToElement(hprice).perform();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	public void clickMetal() {
		platinum.click();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	public void hoverMetal() {
		Actions act = new Actions(driver);
		act.moveToElement(hmetal).perform();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	public void clickNextDayDelivery() {
		nextday.click();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	public void hoverNextDayDelivery() {
		Actions act = new Actions(driver);
		act.moveToElement(hnextday).perform();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	public void clickMoreFilter() {
		morefilter.click();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	
	public void hoverGender() {
		Actions act = new Actions(driver);
		act.moveToElement(hgender).perform();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	
	public void clickGender() {
		gender.click();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
     public RingsFilterPage(WebDriver driver){
    	 
    	 PageFactory.initElements(driver, this);
    	 this.driver = driver;
    	 
     }
}
