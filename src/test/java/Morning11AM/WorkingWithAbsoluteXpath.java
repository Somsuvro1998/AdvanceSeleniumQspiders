package Morning11AM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WorkingWithAbsoluteXpath {

	public static void main(String[] args) {

		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("file:///C:/Users/SOMSUVRO/Desktop/New.html");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[1]")).sendKeys("Rakesh");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[2]")).sendKeys("Roshan");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[3]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/form/input[6]")).sendKeys("Rakesh");
		driver.findElement(By.xpath("/html/body/div[2]/form/input[7]")).sendKeys("R@123");
		driver.findElement(By.xpath("/html/body/div[2]/form/button[1]")).click();
	}

}
