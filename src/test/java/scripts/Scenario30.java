package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.SelectHomePage;
import pages.TenplusmonthlyPage;

public class Scenario30 extends BaseTest {

	@Test
	public void execute30() throws IOException {
		
		SelectHomePage sel = new SelectHomePage(driver);
		sel.clickOnmonthlyPlan();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		TenplusmonthlyPage tms = new TenplusmonthlyPage(driver);
		String amount = "5800";
		String email = "chethankumargv1995@gmail.com";
		tms.enterAmount(amount);
		tms.enterEmail(email);
		tms.clickStartNow();
		tms.clickNext();
		WebElement mobile = driver.findElement(By.xpath("//li[contains(text(),'Please enter valid mobile number')]"));
		WebElement name = driver.findElement(By.xpath("//li[contains(text(),'Name is required')]"));
		WebElement address = driver.findElement(By.xpath("//li[contains(text(),'Your address is required')]"));
		WebElement pincode = driver.findElement(By.xpath("//li[contains(text(),'Enter Valid Pincode')]"));
		if(mobile.isDisplayed()&&name.isDisplayed()&&address.isDisplayed()&&pincode.isDisplayed()) {
			System.out.println("Error displayed");
			FWUtils.screenShotofElement("//div[@class='content']", driver);
		}
		else
		{
			System.out.println("Error not displayed");
			Assert.fail();
		}
		
	}
}

