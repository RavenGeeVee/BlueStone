package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.SelectHomePage;
import pages.TenplusmonthlyPage;

public class Scenario31 extends BaseTest {

	@Test
	public void execute31() throws IOException {
		
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
		tms.enterMobileNumber("9796437458");
		tms.enterFullName("Admin Test");
		tms.enterAddress("45, 8th cross, 1st main, 2nd stage, rajajinagar, bengaluru");
		tms.enterPincode("908081");
		tms.clickNext();
		String nompagetitle = driver.getTitle();
		int res = nompagetitle.indexOf("Nominee");
		if(res>0) {
		tms.enterNominee("Administrator");
		tms.clickNextinNominee();
		}
		else {
			System.out.println("Error exits in Nominee Details Page");
			Assert.fail();
		}
		String paypagetitle = driver.getTitle();
		 res= paypagetitle.indexOf("Payment");
		if(res>0) {
			System.out.println("Payment Page displayed");
			FWUtils.screenShotofPage(driver);
		}
		else
		{
			System.out.println("Payment Page not displayed");
			Assert.fail();
		}
		
	}
}

