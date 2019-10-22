package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.SelectHomePage;

public class Scenario17  extends BaseTest{
	
	@Test
	public void execute17() throws EncryptedDocumentException, IOException {
		
		SelectHomePage sel = new SelectHomePage(driver);
		sel.clickCoins();
		driver.findElement(By.xpath("//span[@class='prcs-d'][text()='Plain Gold Coins']/../../ul/li[6]")).click();
		String text = driver.findElement(By.xpath("//h1[@class='title-5']")).getText();
		int m = text.indexOf("50 gram");
		
		if(m>=0) {
			System.out.println("50 gram coin displayed in Plain Gold");
			FWUtils.screenShotofPage(driver);
		}
			
		else {
			System.out.println("50 gram coin is not displayed in Plain Gold");
			Assert.fail();
			FWUtils.screenShotofPage(driver);
		}
			
	}

}

