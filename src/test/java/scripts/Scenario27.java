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

public class Scenario27 extends BaseTest {

	@Test
	public void execute27() throws IOException {
		
		SelectHomePage sel = new SelectHomePage(driver);
		sel.clickOnmonthlyPlan();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		TenplusmonthlyPage tms = new TenplusmonthlyPage(driver);
		tms.clickStartNow();
		WebElement amt = driver.findElement(By.xpath("//li[text()='Amount is required']"));
		WebElement email = driver.findElement(By.xpath("//li[text()='Email is required']"));
		if(amt.isDisplayed()&&email.isDisplayed()) {
			System.out.println("Error displayed");
			FWUtils.screenShotofElement("//div[@class='form-content row']", driver);
		}
		else
		{
			System.out.println("Error not displayed");
			Assert.fail();
		}
	
		
	}
}

