package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class OpenAmazon {
 
	public void OpenAmazon() throws Throwable 
	{
WebDriverManager.edgedriver().setup();
WebDriver driver=new EdgeDriver();
driver.manage().window().maximize();
driver.get("https://www.amazon.in/");
Thread.sleep(3000);
WebElement mobiles=driver.findElement(By.partialLinkText("Mobiles"));
Actions a=new Actions(driver);
a.moveToElement(mobiles);
a.click().build().perform();

driver.close();
}

}
