package Product;

import org.testng.Assert;
import org.testng.annotations.Listeners;
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
import POMRepo.CreateProductPage;
import POMRepo.HomePage;
import POMRepo.LoginPage;
import POMRepo.ProdValidationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(Generic_utilities.ListenerImplementation.class)
public class CreateProductTest1 extends BaseClass {

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
   	
   	
   Assert.assertEquals(false, true);
   	prod.clickOnSaveButton();
   	
   	
   	ProdValidationPage validate=new ProdValidationPage(driver);
   	
   	
   	String actData=validate.ProdValidate() ;
   	Assert.assertEquals(actData, Name);
   	
   	
   	
   	//home.Logout(driver);
   	
   	
   	
	}

}
