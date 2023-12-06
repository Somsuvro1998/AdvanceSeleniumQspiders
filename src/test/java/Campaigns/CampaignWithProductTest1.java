package Campaigns;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import Generic_utilities.BaseClass;
import Generic_utilities.Excel_Utility;
import Generic_utilities.File_Utility;
import Generic_utilities.Java_Utility;
import Generic_utilities.Webdriver_Utility;
import POMRepo.CreateCampaignPage;
import POMRepo.CreateProductPage;
import POMRepo.HomePage;
import POMRepo.LoginPage;
import POMRepo.ProductWindowPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CampaignWithProductTest1 extends BaseClass {

	@Test
//	public static void main(String[] args) throws Throwable {x
	public void createCampaignWithProductTest() throws Throwable
	{
		//WebDriverManager.chromedriver().setup();
         //WebDriver driver;
         //File_Utility flib=new File_Utility();
         /*String BROWSER = flib.getKeyAndValueData("browser");
     	
     	if(BROWSER.equalsIgnoreCase("CHROME"))
     	{
     		WebDriverManager.chromedriver().setup();
     		 driver=new ChromeDriver();
     	}
     else if(BROWSER.equalsIgnoreCase("edge"))
     	{
     	WebDriverManager.edgedriver().setup();
     	 driver=new EdgeDriver();
     	}
     	else
     	{
     		driver=new ChromeDriver();
     	}*/
         Java_Utility jlib=new Java_Utility();
         Excel_Utility elib=new Excel_Utility();
        // Webdriver_Utility wlib=new Webdriver_Utility();
         
        wlib.maximizingWindow(driver);
		wlib.implicitwait(driver);
//	    String URL = flib.getKeyAndValueData("url");
//		String USERNAME = flib.getKeyAndValueData("username");
//		String PASSWORD = flib.getKeyAndValueData("password");
//		
//		driver.get(URL);
//		LoginPage login=new LoginPage(driver);
//		login.loginToApplication(USERNAME, PASSWORD);
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		HomePage home=new HomePage(driver);
		home.clickProductLink();
		//driver.findElement(By.linkText("Products")).click();
        
		CreateProductPage product=new CreateProductPage(driver);
		product.clickProductPlus();
		//driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
        
        int ranNum = jlib.getRandomNum();
        String ProductName = elib.getDataFormatterData("Product",0,0)+ranNum;
        
        product.ProductName(ProductName);
	   // driver.findElement(By.name("productname")).sendKeys(ProductName);
	    Thread.sleep(2000);
	    product.clickOnSaveButton();
	  // driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
	
	    home.clickMoreLink(driver);
	 // driver.findElement(By.linkText("More")).click();
	  // driver.findElement(By.linkText("Campaigns")).click();
	    
	    CreateCampaignPage campaigns=new CreateCampaignPage(driver);
	    campaigns.addCampaign();
	// driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
	    
	    
	    ProductWindowPage prdWindow=new ProductWindowPage(driver);
	    prdWindow.clickOnSelectSign(driver, wlib);
	  // driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
    	//wlib.switchWindow(driver,"Products&action");

	Thread.sleep(1000);
	prdWindow.productName(ProductName);
	//driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ProductName);
	prdWindow.searchPrdData();
	//driver.findElement(By.xpath("//input[@name='search']")).click();
	
	//    "+value+"
	//driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
	prdWindow.selectProduct(driver, ProductName, wlib);
	//driver.findElement(By.xpath("//a[text()='"+ProductName+"']")).click();
	
	//wlib.switchWindow(driver, "Campaigns&action");

	String CampaginName = elib.getDataFormatterData("Campaigns", 0, 0)+ranNum;
	
	campaigns.campaignName(CampaginName);
  // driver.findElement(By.name("campaignname")).sendKeys(CampaginName);
   
	campaigns.clickOnSaveButton();
  // driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
	
   Thread.sleep(2000);
   
   
   
   //home.Logout(driver);
	 //driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
	   // driver.findElement(By.linkText("Sign Out")).click();
	}

}
