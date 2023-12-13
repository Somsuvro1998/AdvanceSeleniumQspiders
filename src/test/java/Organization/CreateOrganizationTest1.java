package Organization;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;
import Generic_utilities.BaseClass;
import Generic_utilities.Excel_Utility;
import Generic_utilities.File_Utility;
import Generic_utilities.Java_Utility;
import Generic_utilities.Webdriver_Utility;
import POMRepo.CreateOrganizationPage;
import POMRepo.HomePage;
import POMRepo.LoginPage;
import POMRepo.OrgValidationPage;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(Generic_utilities.ExtentImplementation.class)
public class CreateOrganizationTest1 extends BaseClass {
	
	//@Test(retryAnalyzer=Generic_utilities.RetryImplementation.class)
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
//	String URL=flib.getKeyAndValueData("url");
//	String USERNAME=flib.getKeyAndValueData("username");
//	String PASSWORD=flib.getKeyAndValueData("password");
//	
//	driver.get(URL);
//	
//	Thread.sleep(2000);
//  LoginPage login = new LoginPage(driver);
//	login.loginToApplication(USERNAME, PASSWORD);
	
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
   
   //OrgValidationPage validate=new OrgValidationPage(driver);
   
   //String actData=validate.orgValidate();
   //Assert.assertEquals(actData,Oname);
   
   //String actData1=validate.orgValidate();
   //Assert.assertEquals(actData1,Onumber);
   
   //String actData2=validate.orgValidate();
   //Assert.assertEquals(actData2,Oemail);
   //home.Logout(driver);

	
}
}