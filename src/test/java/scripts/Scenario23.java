package scripts;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.RingsFilterPage;
import pages.SelectHomePage;

public class Scenario23 extends BaseTest {

	@Test
	public void execute23() throws IOException {
		SelectHomePage sel = new SelectHomePage(driver);
		sel.enterText("rings");
		RingsFilterPage rfp = new RingsFilterPage(driver);
		rfp.hoverMetal();
		rfp.clickMetal();
		String text = driver.findElement(By.xpath("//span[@class='total-designs']")).getText();
		String[] num = text.split("\\s+");
		int res = Integer.parseInt(num[0]);
		if(res>0) {
		System.out.println("There are "+res+" platinum items");
		FWUtils.screenShotofElement("//span[@class='total-designs']", driver);
		}
		else
		   {
			System.out.println("There are no platinum items");
			FWUtils.screenShotofElement("//span[@class='total-designs']", driver);
			Assert.fail();
			}
		
	}
}

