package Morning11AM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tricenties {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/");
		Thread.sleep(3000);
		driver.findElement(By.partialLinkText("Jewelry")).click();
		WebElement dropDown=driver.findElement(By.xpath("//select[@id='products-orderby']"));
		Select s=new Select(dropDown);
		
		for(int i=0;i<6;i++)
		{
			s.selectByIndex(i);
			dropDown=driver.findElement(By.xpath("//select[@id='products-orderby']"));
			s=new Select(dropDown);

		}
		
	}

}
