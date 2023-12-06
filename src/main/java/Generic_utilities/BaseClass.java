package Generic_utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POMRepo.HomePage;
import POMRepo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

public WebDriver driver;
public static WebDriver sdriver;
public File_Utility flib=new File_Utility();
public Webdriver_Utility wlib=new Webdriver_Utility();

	@BeforeSuite(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void beforeSuite()
	{
		System.out.println("DataBase Conection");
	}
	@BeforeTest(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void beforeTest()
	{
		System.out.println("Parallel Execution Start");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void beforeClass() throws Throwable
	{
		//File_Utility flib=new File_Utility();
		String BROWSER = flib.getKeyAndValueData("browser");
	//public void beforeClass(String BROWSER) {
		
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
		}
	
		wlib.maximizingWindow(driver);
		//driver=new EdgeDriver();
	System.out.println("Launch Browser");
	sdriver=driver;
	}
	@BeforeMethod(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void beforeMethod() throws Throwable
	{
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
		}
		System.out.println("Launch Browser");*/
	
		
	
		String URL = flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PASSWORD = flib.getKeyAndValueData("password");
	
		driver.get(URL);
        Thread.sleep(2000);
        LoginPage login = new LoginPage(driver);
    	login.loginToApplication(USERNAME, PASSWORD);
		System.out.println("Login to application");
		
	}
	@AfterMethod(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void afterMethod()
	{
		HomePage home=new HomePage(driver);
		home.Logout(driver);
		System.out.println("Logout application");
	}
	@AfterClass(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void afterClass()
	{
		driver.quit();
		System.out.println("close Browser");
	}
	@AfterTest(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void afterTest()
	{
		System.out.println("Parallel Execution done");
	}
	@AfterSuite(groups= {"SmokeTest","RegressionTest","SanityTest"})
	public void afterSuite()
	{
		System.out.println("DataBase Connection Close");
	}
	
}
