package Generic_utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

public class Webdriver_Utility {
    
	
	/**
	 * For maximizing the window
	 * @param driver
	 */
	public void maximizingWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * For minimizing the window
	 * @param driver
	 */
	/*public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}*/
	
	/**
	 * For implicity wait
	 * @param driver
	 */
	/*public void implicity_wait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * wait for page to load before indentifying any sychronized element in DOM
	 * 	@author Shobha
	 */
	public void implicitwait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 *After every action it will for next action to perform
	 * @author SOMSUVRO
	 */
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
	}

	/**
	 * used to wait for element to be clickable in GUI and check for specific element for every 500 milliseconds
	 * 
	 */
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement Element,int pollingTime)
	{
		FluentWait wait=new FluentWait(driver);
	    wait.pollingEvery(Duration.ofSeconds(20));	
	    wait.until(ExpectedConditions.elementToBeClickable(Element));
	}
	
	/**
	 * For window Switching
	 * @param driver
	 * @param partialVisibleText
	 */
	
	public void windowSwitching(WebDriver driver, String partialVisibleText)
	{
		Set<String> allWin = driver.getWindowHandles();
		Iterator<String> win = allWin.iterator();

		while(win.hasNext())
		{
			String winText = win.next();
		driver.switchTo().window(winText);
		String title = driver.getTitle();

		if(title.contains(partialVisibleText))
		{
			break;
		}

		}
	}
	/**
	 * used to switch to frame window based on Index
	 * @param driver
	 * @param index
	 * @author SOMSUVRO
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
		}
	/**
	 * 
	 * used to switch to frame window based on id or name attribute
	 * @param driver
	 * @param id_name_attribute
	 * @author SOMSUVRO
	 */
	public void switchToFrame(WebDriver driver,String id_name_Attribute)
	{
	driver.switchTo().frame(id_name_Attribute);	
	}
	/**
	 * used to select the value from the dropDown based on index
	 * @param element
	 * @param index
	 * @author Shobha
	 */
	public void select(WebElement element,int index)
	{
		Select sel=new Select(element);
		sel.selectByIndex(index);
	}	
	/**
	 * used to select the value from the dropDown based on text
	* @param element
	 * @param text
	 * @author Shobha
	 */
	public void select(WebElement element, String text)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This is used to point at a element
	 * @param driver
	 * @param ele
	 * @author SOMSUVRO
	 */
	public void ActionsMoveToElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**
	 * used to right click on specific element
	 * @param driver
	 * @param element
	 * @author SOMSUVRO
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void moveByOffest(WebDriver driver,int x,int y)
	{
		Actions act=new Actions(driver);
		act.moveByOffset(x, y).click().perform();
	}	
	/**
	 * This  method is used for scrolling
	 * @param driver
	 * @param element
	 */
	
	public void javaScriptExecutor(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0]. scrollIntoView()",element);
	}
	
	/**
	 * to accept popup
	 * @param driver
	 */
	public void alertAccept(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		alt.accept();
		
	}
	
	/**
	 * To dismiss popup
	 * @param driver
	 */
	public void alertDismiss(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	
	
	public static String takeScreenShot(WebDriver driver, String screenShotName) throws Throwable
	{
		TakesScreenshot takesScreenShot=(TakesScreenshot)driver;
		File src=takesScreenShot.getScreenshotAs(OutputType.FILE);
		File dst=new File("./ScreenShots/" +screenShotName+ ".png");
		FileUtils.copyFile(src, dst);
		
		return dst.getAbsolutePath();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
