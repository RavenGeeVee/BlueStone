package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class FWUtils implements IAutoConstants{

	public static String readData(String path, String sheetName, int rowVal,int cellVal) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(sheetName);
		Row r = sh.getRow(rowVal);
		if(r==null){
			r = sh.createRow(rowVal);
		}
		r = sh.getRow(rowVal);
		String str = r.getCell(cellVal, MissingCellPolicy.CREATE_NULL_AS_BLANK).toString();
		return str;

	}
	
	public static void writeData(String path,String sheetName, int rowVal,int cellVal, String value) throws EncryptedDocumentException, IOException {
		
		FileInputStream file  = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(sheetName);
		Row r = sh.getRow(rowVal) ;
		if(r==null){
			r = sh.createRow(rowVal);
		}
		Cell c = r.createCell(cellVal);
		c.setCellValue(value);
		
		wb.write(new FileOutputStream(path));
      
	}
	
	public static int rowCount(String path,String sheetName) throws EncryptedDocumentException, IOException {
		
		FileInputStream file  = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(sheetName);
		int rowVal = sh.getLastRowNum();
		return rowVal;
	}
	
    public static int colCount(String path,String sheetName, int rowVal) throws EncryptedDocumentException, IOException {
		
		FileInputStream file  = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(sheetName);
		Row r = sh.getRow(rowVal);
		int colVal = r.getLastCellNum();
		return colVal;
	}
    
    public static void screenShotofPage(WebDriver driver) throws IOException	{
    	 LocalDate da = LocalDate.now();
         LocalTime te = LocalTime.now();
         Integer d = da.getDayOfMonth();
         Integer mon = da.getMonthValue();
         Integer y = da.getYear();
         Integer h = te.getHour();
         Integer min = te.getMinute();
         
         String text = d.toString()+mon.toString()+y.toString()+"#"+h.toString()+min.toString();
    	
    	TakesScreenshot ts = (TakesScreenshot) driver;
    	File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(PHOTO+text+".png");
		FileUtils.copyFile(src, dest);
		Reporter.log("Screenshot of page taken", true);
    }
    
     public static void screenShotofElement(String xpathName,WebDriver driver) throws IOException	{
    	 LocalDate da = LocalDate.now();
         LocalTime te = LocalTime.now();
         Integer d = da.getDayOfMonth();
         Integer mon = da.getMonthValue();
         Integer y = da.getYear();
         Integer h = te.getHour();
         Integer min = te.getMinute();
         
         String text = d.toString()+mon.toString()+y.toString()+"#"+h.toString()+min.toString();
    	
    	WebElement name = driver.findElement(By.xpath(xpathName));
    	File src = name.getScreenshotAs(OutputType.FILE);
		File dest = new File(PHOTO+text+".png");
		FileUtils.copyFile(src, dest);
		Reporter.log("Screenshot of element taken", true);
    }
    
}
