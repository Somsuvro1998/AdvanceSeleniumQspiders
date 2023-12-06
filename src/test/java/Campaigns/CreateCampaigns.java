package Campaigns;


import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_utilities.Excel_Utility;
import Generic_utilities.File_Utility;
import Generic_utilities.Java_Utility;
import Generic_utilities.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class CreateCampaigns {

		public static void main(String[] args) throws Throwable {

			WebDriverManager.edgedriver().setup();
			WebDriver driver=new EdgeDriver();
			
			//driver.get("http://localhost:8888/");
			
			Webdriver_Utility wlib=new Webdriver_Utility();
			File_Utility flib=new File_Utility();
			Excel_Utility elib=new Excel_Utility();
            Java_Utility jlib=new Java_Utility();

			
			wlib.maximizingWindow(driver);
			wlib.implicitwait(driver);
			
			
			String URL=flib.getKeyAndValueData("url");
			String USERNAME=flib.getKeyAndValueData("username");
			String PASSWORD=flib.getKeyAndValueData("password");
			
			
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.linkText("More")).click();
			driver.findElement(By.linkText("Campaigns")).click();
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			
			//Random Approach To avoid Duplicates
			/*Random ran = new Random();
			int ranNum = ran.nextInt(1000);*/
			
			int ranNum=jlib.getRandomNum();
			
			String campName =elib.getDataFormatterData("Campaigns",0,0)+ranNum;
			driver.findElement(By.name("campaignname")).sendKeys(campName);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			String campaignName = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
			
			if(campaignName.contains(campName))
			{
				System.out.println("Campaign Created");
			}
			else
			{
				System.out.println("Campaign not created");
			}
		   driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.linkText("Sign Out")).click();
			driver.close();
		}

	}

