package Morning11AM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkingWithDynamicXpath {

	public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.findElement(By.partialLinkText("Jewelry")).click();
		WebElement dropDown=driver.findElement(By.id("products-orderby"));
		Select s=new Select(dropDown);
		
		for(int i=0;i<6;i++)
		{
			s.selectByIndex(i);
			String name=driver.findElement(By.xpath("//div[@class='product-grid']/div[1]/div/div[2]//a")).getText();
			
			System.out.println(name);
			dropDown=driver.findElement(By.id("products-orderby"));
			s=new Select(dropDown);
		}
		driver.close();
		
		
	}

}
