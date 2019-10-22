package scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtils;
import pages.SelectHomePage;

public class Scenario26 extends BaseTest {

	@Test
	public void execute26() throws IOException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)");
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		FWUtils.screenShotofPage(driver);
		SelectHomePage sel = new SelectHomePage(driver);
		sel.clickOnIcon();
		FWUtils.screenShotofPage(driver);
	}
}

