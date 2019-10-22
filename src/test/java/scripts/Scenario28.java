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

public class Scenario28 extends BaseTest {

	@Test
	public void execute28() throws IOException {
		
		SelectHomePage sel = new SelectHomePage(driver);
		sel.clickOnmonthlyPlan();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		TenplusmonthlyPage tms = new TenplusmonthlyPage(driver);
		String amount = "5800";
		String email = "abc@gmail.com";
		tms.enterAmount(amount);
		tms.enterEmail(email);
		tms.clickStartNow();
	
		WebElement emailid = driver.findElement(By.xpath("//input[@id='email']"));
		String emailValue = emailid.getAttribute("value");
		System.out.println(emailValue);
		WebElement subAmount = driver.findElement(By.xpath("//div[@name='subscriptionAmount']"));
		String num = subAmount.getText();
		String dnum = " ";
		for(int i=0;i<num.length();i++) {
			if(Character.isDigit(num.charAt(i)))
				dnum += num.charAt(i);
		}
		System.out.println(dnum);
		if((amount.equals(dnum))&&(email.equals(emailValue))) {
			System.out.println("Entered Values match displayed values");
			FWUtils.screenShotofPage(driver);
		}
		else
		{
			System.out.println("Values not matched");
			Assert.fail();
		}
		
	}
}

