package scripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.RingsFilterPage;
import pages.SelectHomePage;

public class Scenario22 extends BaseTest {

	@Test
	public void execute22() throws IOException {
		SelectHomePage sel = new SelectHomePage(driver);
		sel.enterText("rings");
		RingsFilterPage rfp = new RingsFilterPage(driver);
		rfp.hoverNextDayDelivery();
		rfp.clickNextDayDelivery();
		
		String text = driver.findElement(By.xpath("//span[@class='total-designs']")).getText();
		String[] num = text.split("\\s+");
		int res = Integer.parseInt(num[0]);
		if(res>0) {
		System.out.println("There are "+res+" with next day delivery option");
		FWUtils.screenShotofPage(driver);
		}
		else
		   {
			System.out.println("There are no items with next day delivery options");
			FWUtils.screenShotofPage(driver);
			Assert.fail();
			}
		
	}
}

