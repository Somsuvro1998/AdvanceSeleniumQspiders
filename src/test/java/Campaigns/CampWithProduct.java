package Campaigns;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_utilities.Excel_Utility;
import Generic_utilities.File_Utility;
import Generic_utilities.Java_Utility;
import Generic_utilities.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CampWithProduct {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		/*File_Utility flib=new File_Utility();
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
	  	driver.get("http://localhost:8888/");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");*/
		
		Webdriver_Utility wlib=new Webdriver_Utility();
		Java_Utility jlib=new Java_Utility();
		Excel_Utility elib=new Excel_Utility();
		File_Utility flib=new File_Utility();
		
		wlib.maximizingWindow(driver);
		wlib.implicitwait(driver);
		
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
		
		
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		
		
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
	
	/*	//Random Approach To avoid Duplicates
	Random ran = new Random();
	int ranNum = ran.nextInt(1000);*/
		
		
		int ranNum=jlib.getRandomNum();
		
	String NAme = elib.getDataFormatterData("Product",0,0)+ranNum;
		driver.findElement(By.name("productname")).sendKeys(NAme);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
String prdName = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();
	
if(prdName.contains(NAme))
{
	System.out.println("Product Created");
}
else
{
	System.out.println("Product not created");
}

driver.findElement(By.linkText("More")).click();
driver.findElement(By.linkText("Campaigns")).click();
driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
driver.findElement(By.xpath("//img[@alt='Select']")).click();

/*Set<String> allWin = driver.getWindowHandles();
Iterator<String> win = allWin.iterator();

while(win.hasNext())
{
	String winText = win.next();
driver.switchTo().window(winText);
String title = driver.getTitle();

if(title.contains("Products&action"))
{
	break;
}

}*/



wlib.windowSwitching(driver,"Products&action");

Thread.sleep(2000);
driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(NAme);
driver.findElement(By.xpath("//input[@name='search']")).click();

//Dynamic Xpath
//driver.findElement(By.xpath("//a[text()='"+NAme+"']")).click();

driver.findElement(By.xpath("//a[text()='"+NAme+"']")).click();

/*Set<String> allWin1 = driver.getWindowHandles();
Iterator<String> win1 = allWin1.iterator();

while(win1.hasNext())
{
	String winText1 = win1.next();
driver.switchTo().window(winText1);
String title1 = driver.getTitle();

if(title1.contains("Campaigns&action"))
{
	break;
}

}*/

wlib.windowSwitching(driver, "campaigns&action");

String campName = elib.getDataFormatterData("Campaigns",0,0)+ranNum;
driver.findElement(By.name("campaignname")).sendKeys(campName);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

String CampaignName=driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();

if(CampaignName.contains(campName))
{
	System.out.println("Campaign with Product created");
}
else
{
	System.out.println("Campaign with product not created");
}

driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.linkText("Sign Out")).click();
driver.close();
	}

}