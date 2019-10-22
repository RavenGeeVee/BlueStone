package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.RingsFilterPage;
import pages.SelectHomePage;

public class Scenario24 extends BaseTest {

	@Test
	public void execute24() throws IOException {
		SelectHomePage sel = new SelectHomePage(driver);
		sel.enterText("rings");
		RingsFilterPage rfp = new RingsFilterPage(driver);
		rfp.clickMoreFilter();
        driver.findElement(By.xpath("//div[@id='mCSB_1_container']/form[@id='gold purity']/div[contains(@class,'form-items')]/div[contains(@class,'form-item last')]/span[1]")).click();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		String text = driver.findElement(By.xpath("//span[@class='total-designs']")).getText();
		String[] num = text.split("\\s+");
		int res = Integer.parseInt(num[0]);
		if(res>0) {
		System.out.println("There are "+res+" of 22k gold purity items");
		FWUtils.screenShotofElement("//span[@class='total-designs']", driver);
		}
		else
		   {
			System.out.println("There are no 22k gold purity items");
			FWUtils.screenShotofElement("//span[@class='total-designs']", driver);
			Assert.fail();
			}
		
	}
}

