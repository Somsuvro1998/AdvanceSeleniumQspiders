package Practice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_utilities.BaseClass;
import Generic_utilities.Excel_Utility;
import Generic_utilities.Java_Utility;
import Generic_utilities.Webdriver_Utility;
import POMRepo.CampValidationPage;
import POMRepo.CreateCampaignPage;
import POMRepo.CreateOrganizationPage;
import POMRepo.CreateProductPage;
import POMRepo.HomePage;
import POMRepo.OrgValidationPage;
import POMRepo.ProdValidationPage;

@Listeners(Generic_utilities.ListenerImplementation.class)
public class ThreeMethods extends BaseClass{
	
	@Test(groups="RegressionTest")	
	public void createCampaignTest() throws Throwable {
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
		
		CampValidationPage validate=new CampValidationPage(driver);
		
		
		String actData=validate.campValidate();
		Assert.assertEquals(actData,CampaignName);
		
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

	@Test(groups="SmokeTest")
	public void createOrganizationTest1() throws Throwable{

		//WebDriver driver;
		
	   // File_Utility flib=new File_Utility();
		Excel_Utility elib=new Excel_Utility();
		Java_Utility jlib=new Java_Utility();
		//Webdriver_Utility wlib=new Webdriver_Utility();
		
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
		
		wlib.maximizingWindow(driver);
		wlib.implicitwait(driver);
	//	
//		String URL=flib.getKeyAndValueData("url");
//		String USERNAME=flib.getKeyAndValueData("username");
//		String PASSWORD=flib.getKeyAndValueData("password");
	//	
//		driver.get(URL);
	//	
//		Thread.sleep(2000);
	//  LoginPage login = new LoginPage(driver);
//		login.loginToApplication(USERNAME, PASSWORD);
		
		HomePage home=new HomePage(driver);
		home.clickOrgnaizationLink();
		
		CreateOrganizationPage org=new 	CreateOrganizationPage(driver);
	    org.clickOrgPlus();
	    
	    int ranNum=jlib.getRandomNum();
	    String Oname=elib.getDataFormatterData("Organization", 0, 0)+ranNum;
	    String Onumber=elib.getDataFormatterData("Organization", 1, 1);
	    String Oemail=elib.getDataFormatterData("Organization", 2, 2);
	    
	    org.OrganizationData(Oname,Onumber,Oemail );
	    
	    Assert.assertEquals(false, true);
	    
	    org.clickSaveButton();
	    
	   Thread.sleep(3000);
	   
	   OrgValidationPage validate=new OrgValidationPage(driver);
	   
	   String actData=validate.orgValidate();
	   Assert.assertEquals(actData,Oname);
	   
	   String actData1=validate.orgValidate();
	   Assert.assertEquals(actData1,Onumber);
	   
	   String actData2=validate.orgValidate();
	   Assert.assertEquals(actData2,Oemail);
	   //home.Logout(driver);

		
	}
	@Test
	public void createProductTest1() throws Throwable {
		//File_Utility flib = new File_Utility();
		//WebDriver driver;
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
		
//	   Webdriver_Utility wlib=new Webdriver_Utility();
//	   wlib.maximizingWindow(driver);
//	   String URL = flib.getKeyAndValueData("url");
//		String USERNAME = flib.getKeyAndValueData("username");
//		String PASSWORD = flib.getKeyAndValueData("password");
//	
//		driver.get(URL);
//       Thread.sleep(2000);
//       LoginPage login = new LoginPage(driver);
//   	login.loginToApplication(USERNAME, PASSWORD);
   	
   	HomePage home=new HomePage(driver);
   	home.clickProductLink();
   	
   	CreateProductPage prod=new CreateProductPage(driver);
   	prod.clickProductPlus();
   	
   	Excel_Utility elib=new Excel_Utility();
   	Java_Utility jlib=new Java_Utility();
   	int ranNum = jlib.getRandomNum();
   	
   	String Name=elib.getDataFormatterData("Product", 0, 0)+ranNum;
   	prod.ProductName(Name);
   	
   	
    // Assert.assertEquals(false, true);
   	prod.clickOnSaveButton();
   	
   	
   	ProdValidationPage validate=new ProdValidationPage(driver);
   	
   	
   	String actData=validate.ProdValidate() ;
   	Assert.assertEquals(actData, Name);
   	
   	
   	
   	//home.Logout(driver);
   	
   	
   	
	}

	
	

}
