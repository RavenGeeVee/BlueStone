package scripts;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.RingsFilterPage;
import pages.SelectHomePage;

public class Scenario25 extends BaseTest {

	@Test
	public void execute25() throws IOException {
		SelectHomePage sel = new SelectHomePage(driver);
		sel.enterText("rings");
		RingsFilterPage rfp = new RingsFilterPage(driver);
		rfp.hoverGender();
		rfp.clickGender();
		String text = driver.findElement(By.xpath("//span[@class='total-designs']")).getText();
		String[] num = text.split("\\s+");
		int res = Integer.parseInt(num[0]);
		if(res>0) {
		System.out.println("There are "+res+" women items");
		FWUtils.screenShotofElement("//span[@class='total-designs']", driver);
		}
		else
		   {
			System.out.println("There are no women items");
			FWUtils.screenShotofElement("//span[@class='total-designs']", driver);
			Assert.fail();
			}
		
	}
}

