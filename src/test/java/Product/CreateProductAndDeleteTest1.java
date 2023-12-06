package Product;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;
import org.openqa.selenium.By;
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
import POMRepo.CreateProductPage;
import POMRepo.DeleteProductPage;
import POMRepo.HomePage;
import POMRepo.LoginPage;
import POMRepo.ProductPlusSignPage;
import POMRepo.CreateProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductAndDeleteTest1 extends BaseClass 
{
	@Test
public void createProductAndDeleteTest1() throws Throwable {
	

	 	//File_Utility flib=new File_Utility();
		Excel_Utility elib=new Excel_Utility();
		Java_Utility jlib=new Java_Utility();
		//Webdriver_Utility wlib=new Webdriver_Utility();
		
	
		/*WebDriver driver;
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
		}*/
		
		//Launching the browser
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
		
		//login to application
//		wlib.maximizingWindow(driver);
//		wlib.implicitwait(driver);
//		
//		String URL = flib.getKeyAndValueData("url");
//		System.out.println(URL);
//		String USERNAME = flib.getKeyAndValueData("username");
//		String PASSWORD = flib.getKeyAndValueData("password");
//        driver.get(URL);
//        
//
//
//LoginPage login=new LoginPage(driver);
//login.loginToApplication(USERNAME, PASSWORD);
////driver.findElement(By.name("user_name")).sendKeys(USERNAME);
////driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
////driver.findElement(By.id("submitButton")).click();

//click on product link
HomePage home=new HomePage(driver);
home.clickProductLink();
//driver.findElement(By.linkText("Products")).click();

Thread.sleep(2000);
//click on +sign
ProductPlusSignPage productpage=new ProductPlusSignPage(driver);
productpage.clickProductPlus();
//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

//java utility method
int ranNum = jlib.getRandomNum();
String productData = elib.getDataFormatterData("Product", 0, 0)+ranNum;

CreateProductPage propage=new CreateProductPage(driver);
propage.ProductName(productData);
	//driver.findElement(By.name("productname")).sendKeys(productData);

propage.clickOnSaveButton();
	//save the data
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

//product table
DeleteProductPage deletePrd=new DeleteProductPage(driver);
deletePrd.productTable();
//driver.findElement(By.xpath("//a[text()='Products']")).click();
driver.findElement(By.xpath("//table[@class='lvt small']/tbody//td//a[text()='"+productData+"']"+ "/../preceding-sibling::td/input")).click();

deletePrd.deletePrdData();
//driver.findElement(By.xpath("//input[@value='Delete']")).click();

wlib.alertAccept(driver);
//Alert alt = driver.switchTo().alert();
//alt.accept();

//validation
// List<WebElement> productList = driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
//
// boolean flag=false;
// 
// for(WebElement prdName:productList)
// {
//	String actData = prdName.getText();
//	if(actData.contains(productData))//	Markerting293.contains(iphone)
//	{
//		flag=true;
//		break;
//	}
// }
//if(flag)
//{
//	System.out.println("product data is deleted");
//}
//else
//{
//	System.out.println("product data not deleted");
//}
DeleteProductPage page=new DeleteProductPage(driver);
page.validateProduct(driver, productData);

Thread.sleep(2000);
//home.Logout(driver);
	}	
	
}
