package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_utilities.File_Utility;
import Generic_utilities.Webdriver_Utility;
import POMRepo.HomePage;
import POMRepo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
		
		File_Utility flib = new File_Utility();
		WebDriver driver;
		String BROWSER = flib.getKeyAndValueData("browser");
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
	   Webdriver_Utility wlib=new Webdriver_Utility();
	   wlib.maximizingWindow(driver);
	   
		
	/*	WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();*/
		
		String URL = flib.getKeyAndValueData("url");
		String USERNAME = flib.getKeyAndValueData("username");
		String PASSWORD = flib.getKeyAndValueData("password");
	
		driver.get(URL);
        Thread.sleep(2000);
        LoginPage login = new LoginPage(driver);
    	login.loginToApplication(USERNAME, PASSWORD);
    	
    	//driver.findElement(By.linkText("Organizations")).click();
    	HomePage home = new HomePage(driver);
    	home.clickOrgnaizationLink();
	
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	
	Random ran = new Random();
	int ranNum = ran.nextInt(1000);
	
	FileInputStream fis = new FileInputStream("C:\\Users\\SOMSUVRO\\Desktop\\Testdata.xlsx");
	Workbook book = WorkbookFactory.create(fis);
    Sheet sheet = book.getSheet("Organization");
    Row row = sheet.getRow(0);
    Cell cell = row.getCell(0);
    
    String orgName =cell.getStringCellValue()+ranNum;
	
	
     driver.findElement(By.name("accountname")).sendKeys(orgName);
	
	driver.findElement(By.id("phone")).sendKeys("468654684");
	driver.findElement(By.id("email1")).sendKeys("abc@gmail.com");
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	Thread.sleep(2000);
//	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
	/*WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(ele).click().perform();
	driver.findElement(By.linkText("Sign Out")).click();*/
	home.Logout(driver);
	driver.close();	
	
	}

}