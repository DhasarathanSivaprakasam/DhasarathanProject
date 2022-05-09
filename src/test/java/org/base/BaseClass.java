package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Navigation navigate; 
	public static Actions a;
	public static Alert alrt;
	public static Select dpdn;
	public static JavascriptExecutor js;

	// 1.Baseclass for webdriver
	public static void browserLaunch() {		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	// 2.Window Maximize
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}
	// 3.URL Launch
	public static void urlLaunch(String url) {
		driver.get(url);
	}
	// 4.Get Title of Web Page
	public static void getTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	// 5.Get Current URL
	public static void getCurrentUrl() {
		String title = driver.getCurrentUrl();
		System.out.println(title);
	}
	// 6.Get Page Source
	public static void getPageSource() {
		String title = driver.getPageSource();
		System.out.println(title);
	}
	// 7.Close Action
	public static void close() {
		driver.close();
	}
	// 8.Quit Action
	public static void quit() {
		driver.quit();
	}
	// 9.Navigation
	public static void urlNavigation(String url) {
		navigate=driver.navigate();
		navigate.to(url);
	}
	// 10.Refresh function with navigation
	public static void refreshCurrentPage() {
		driver.navigate().refresh();			
	}
	// 11.Next Page with navigation
	public static void navigateNextPage() {
		driver.navigate().forward();			
	}
	// 12.Previous Page function with navigation
	public static void navigatePreviousPage() {
		driver.navigate().back();			
	}
	// 13.Windows Handle
	public static void windowsHandle() {
		String handle = driver.getWindowHandle();
		System.out.println(handle);
	}
	// 14.Screenshot
	public static void takeScreenshot(String snap) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File("C:\\Users\\Dhasarathan S\\eclipse-workspace\\MavenProject\\Screenshots\\"+snap+".png");
		FileUtils.copyFile(source, target);	
	}
	// 15.Button Click
	public static void btnClick(WebElement element) {
		element.click();
	}
	// 16.Send Value to Text box
	public static void sendKeys(WebElement element,String value) {
		element.sendKeys(value);
	}
	// 17.Clear the text Field
	public static void clear(WebElement element) {
		element.clear();
	}
	// 18.Clear Cookies
	public static void clearCookies() {
		driver.manage().deleteAllCookies();
	}
	// 19.Element Displayed or Not 
	public static void isDisplayed(WebElement element) {
		element.isDisplayed();
	}
	// 20.Element Enabled or Not 
	public static void isEnabled(WebElement element) {
		element.isEnabled();
	}
	// 21.Element Selected or Not 
	public static void isSelected(WebElement element) {
		element.isSelected();
	}
	// 22.Submit
	public static void submit(WebElement element) {
		element.submit();
	}
	// 23.Mouse Hover
	public static void mouseHover(WebElement element) {
		a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	// 24.Drag and Drop
	public static void dragAndDrop(WebElement source,WebElement target) {
		a.dragAndDrop(source, target).perform();
	}
	// 25.Right Click
	public static void rightClick(WebElement element) {
		a.contextClick(element).perform();
	}
	// 26.Double Click
	public static void doubleClick(WebElement element) {
		a.doubleClick(element).perform();
	}
	// 27.Alert accept
	public static void acceptAlert() {
		alrt=driver.switchTo().alert();
		alrt.accept();
	}
	// 28.Alert dismiss
	public static void dismissAlert() {
		alrt=driver.switchTo().alert();
		alrt.dismiss();
	}
	// 29.Send Value to Alert Text Box
	public static void sendKeysToAlert(String value) {
		alrt=driver.switchTo().alert();
		alrt.sendKeys(value);
	}
	// 30.Get Text From Alert
	public static void getTextFromAlert() {
		alrt=driver.switchTo().alert();
		String text = alrt.getText();
		System.out.println(text);
	}
	// 31.Drop Down 
	public static void dropDownSelectByVisibleText(WebElement element,String value) {
		dpdn=new Select(element);  
		dpdn.selectByVisibleText(value);
	}
	// 32.Get All Options from Drop Down List 
	public static void getAllOptionsFromDropDown(WebElement element) { 
		dpdn=new Select(element);
		List<WebElement> options = dpdn.getOptions();
		for (WebElement option : options) {
			String text = option.getText();	
			System.out.println(text);
		}
	}
	// 33.Get Selected Options from Drop Down List 
	public static void getSelectedOptionsFromDropDown(WebElement element) { 
		dpdn=new Select(element);
		List<WebElement> list = dpdn.getAllSelectedOptions();
		for (WebElement webElement : list) {

		}
		System.out.println(list);
	}
	// 34.Get First Selected Options from Drop Down List 
	public static void getFirstSelectedOptionsFromDropDown(WebElement element) { 
		dpdn=new Select(element);
		WebElement option = dpdn.getFirstSelectedOption();

		System.out.println(option);
	}
	// 35.Delay
	public static void sleep(int value) throws InterruptedException { 
		Thread.sleep(value);
	}
	// 36.printHiddenText with Java Script Executor
	public static void printHiddenText(String key,WebElement orderId) {
		js = (JavascriptExecutor)driver;
		Object id = js.executeScript(key, orderId);
		String text=(String)id;
		System.out.println(text);
	}

	//Read data from Excel
	public static String excelRead(int row, int cell) throws IOException {

		File f= new File("C:\\Users\\Dhasarathan S\\eclipse-workspace\\PomFrameWork\\Excel\\DataDriven.xlsx");		
		FileInputStream fin=new FileInputStream(f);	
		Workbook b= new XSSFWorkbook(fin);
		Sheet s = b.getSheet("Sheet1");		
		Row r = s.getRow(row);			
		Cell c = r.getCell(cell);

		String value;

		int type = c.getCellType();

		if (type==1) {
			value = c.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(c)) {
			Date d = c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
			value = sim.format(d);			     
		}
		else {
			double dd = c.getNumericCellValue();
			long l=(long)dd;
			value = String.valueOf(l);
		}
		return value;    
	}

	public static void date() {

		Date d=new Date();
		System.out.println(d);

	}
}  




