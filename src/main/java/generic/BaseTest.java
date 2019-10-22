package generic;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(generic.TestListener.class)
public class BaseTest implements IAutoConstants {
	static {
		//System.setProperty(CHROME_KEY, CHROME_VALUE);
        WebDriverManager.chromedriver().setup();
	}
	public WebDriver driver;
	
	@BeforeMethod
	public void selectDriver() throws EncryptedDocumentException, IOException {

		driver = new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.MILLISECONDS);
		//FWUtils fw = new FWUtils();
		//fw.readData(EXCEL_DATA, "Sheet1", 0, 0);
		
	}

	@AfterMethod
	public void closeDriver() {

		driver.quit();

	}

}
