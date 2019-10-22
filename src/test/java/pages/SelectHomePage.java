package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.IAutoConstants;

public class SelectHomePage implements IAutoConstants {
	
	WebDriver driver;
	
	@FindBy(xpath="//ul[@class='wh-main-menu']/li/child::a[@href='https://www.bluestone.com/jewellery/rings.html']") private WebElement rings;
	@FindBy(xpath="//ul[@class='wh-main-menu']/li/child::a[@href='https://www.bluestone.com/jewellery.html']") private WebElement alljewels;
	@FindBy(xpath="//ul[@class='wh-main-menu']/li/child::a[@href='https://www.bluestone.com/jewellery/offers.html']") private WebElement offers;
	@FindBy(xpath="//ul[@class='wh-main-menu']/li/child::a[@href='https://www.bluestone.com/jewellery/goldcoins.html']") private WebElement coins;
	@FindBy(xpath="//ul[@class='wh-main-menu']/li/child::a[@href='https://www.bluestone.com/jewellery/next+day+delivery.html']") private WebElement delivery;
	@FindBy(xpath="//input[@class='form-text typeahead']") private WebElement search;
	@FindBy(xpath="//span[@class='logo-icon']") private WebElement icon;
	@FindBy(xpath="//a[contains(text(),'10+1 Monthly Plan')]") private WebElement monthlyplan;
	
	public void clickOffers() {
		Actions act = new Actions(driver);
		act.moveToElement(offers).perform();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
	
     public void clickRings() {
    	 Actions act = new Actions(driver);
    	 act.moveToElement(rings).perform();
    	 driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		
	}
     public void clickJewellary() {
    	 Actions act = new Actions(driver);
 		act.moveToElement(alljewels).perform();
 		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
 		
 	}
     public void clickCoins() {
    	 Actions act = new Actions(driver);
  		act.moveToElement(coins).perform();
  		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
  		
  	}
     public void clickNextDayDeliver() {
    	delivery.click();
  		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
  		
  	}
     public void enterText(String value) {
    	search.sendKeys(value, Keys.ENTER );
  		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
  		
  	}
     
     public void clickOnIcon() {
     	icon.click();
   		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
   		
   	}
     public void clickOnmonthlyPlan() {
    	    monthlyplan.click();
    		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
    		
    	}
     public SelectHomePage(WebDriver driver){
    	 
    	 PageFactory.initElements(driver, this);
    	 this.driver = driver;
    	 
     }
}
