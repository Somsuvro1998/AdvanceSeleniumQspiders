package Practice;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utilities.BaseClass;
import Generic_utilities.Excel_Utility;
import Generic_utilities.Java_Utility;
import Generic_utilities.Webdriver_Utility;
import POMRepo.CreateOrganizationPage;
import POMRepo.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderEx3 {
	@Test(dataProvider="getdata")
	public void m1(String orgName,String phoneNum, String emailID) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		
//		Random ran=new Random();
//		int rannum=ran.nextInt(1000);
	
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("phone")).sendKeys(phoneNum);
		driver.findElement(By.id("email1")).sendKeys(emailID);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		Thread.sleep(1000);
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getdata() throws Throwable
	{
		Random ran=new Random();
		int ranNum=ran.nextInt(1000);
		Object[][] obj=new Object[3][3];
		obj[0][0]="AAA"+ranNum;
		obj[0][1]="522152332322";
		obj[0][2]="hhgd@gmail.com";
		
		obj[1][0]="BBB"+ranNum;
		obj[1][1]="45656565";
		obj[1][2]="gfsgx@gmail.com";
		
		obj[2][0]="CCC"+ranNum;
		obj[2][1]="545554656";
		obj[2][2]="gswtw@gmail.com";
		return obj;
			
	}	    
	}

	
	
	
	
	

