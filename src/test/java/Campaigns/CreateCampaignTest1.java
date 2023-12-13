package Campaigns;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_utilities.BaseClass;
import Generic_utilities.Excel_Utility;
import Generic_utilities.File_Utility;
import Generic_utilities.Java_Utility;
import Generic_utilities.Webdriver_Utility;
import POMRepo.CampValidationPage;
import POMRepo.CreateCampaignPage;
import POMRepo.HomePage;
import POMRepo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Generic_utilities.ExtentImplementation.class)
public class CreateCampaignTest1 extends BaseClass {

	//@Test(retryAnalyzer=Generic_utilities.RetryImplementation.class)	
	@Test
	public void createCampaignTest1() throws Throwable {
		//WebDriverManager.edgedriver().setup();
		//WebDriver driver;
		
		//File_Utility flib = new File_Utility();
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
		/*String URL = flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PASSWORD = flib.getKeyAndValueData("password");
	
		driver.get(URL);
        Thread.sleep(2000);
        LoginPage login = new LoginPage(driver);
    	login.loginToApplication(USERNAME, PASSWORD);*/
    	
		
		//BusinessLogics
	//	LoginPAge1 login = new LoginPAge1(driver);
	//	login.loginToApplication(USERNAME, PASSWORD);
		
	/*	WebElement moreLink = driver.findElement(By.linkText("More"));
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		driver.findElement(By.linkText("Campaigns")).click();*/
		 
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.maximizingWindow(driver);
		
		
		
		Thread.sleep(3000);
		HomePage home = new HomePage(driver);
		home.clickOnMoreLink();
		home.clickOnCampaigns();
		
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		CreateCampaignPage camp=new CreateCampaignPage(driver);
		camp.addCampaign();
		
		
		
		Java_Utility jlib=new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
		Excel_Utility elib=new Excel_Utility();
		String CampaignName = elib.getDataFormatterData("Campaigns", 0, 0)+ranNum;
		
		driver.findElement(By.name("campaignname")).sendKeys(CampaignName);
	    
		
	    //driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();
	    
		Assert.assertEquals(false, true);
		camp.clickOnSaveButton(); 
	
		Thread.sleep(2000);
		
		//CampValidationPage validate=new CampValidationPage(driver);
		
		
		//String actData=validate.campValidate();
	
		//SoftAssert soft=new SoftAssert();
		//soft.assertEquals(actData,CampaignName);
		//soft.assertAll();
		
		//Assert.assertEquals(actData,CampaignName);
		
		/*String Actdata = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		if(Actdata.contains(CampaginName))
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("fail");
		}*/
		 Thread.sleep(2000);
		
		 // driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 // driver.findElement(By.linkText("Sign Out")).click();
	//home.Logout(driver);
	
	}

	
	
}
