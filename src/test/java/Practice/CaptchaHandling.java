package Practice;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.sourceforge.tess4j.Tesseract;

public class CaptchaHandling {

	public static void main(String[] args) throws Throwable {

//		ChromeOptions opt=new ChromeOptions();
//		opt.addArguments("--disable-notifications");
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://www.irctc.co.in/nget/train-search");
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//a[text()=\" LOGIN \"]")).click();
        
        Thread.sleep(2000);
        WebElement captcha=driver.findElement(By.xpath("//img[@class=\"captcha-img\"]"));
        
        TakesScreenshot tss=(TakesScreenshot)captcha;
        File src=tss.getScreenshotAs(OutputType.FILE);
        File dest=new File("./CaptchaScreenShot.png");
        FileUtils.copyFile(src, dest);
        
        Tesseract ts=new Tesseract();
        
        ts.setDatapath("C:\\Users\\SOMSUVRO\\Downloads\\Tess4J-3.4.8-src\\Tess4J\\tessdata");
        String path = ts.doOCR(dest);
        String img =path.replaceAll(" ", "");
        System.out.println(img);
        
        driver.findElement(By.xpath("//input[@id=\"captcha\"]")).sendKeys(img);
    		
	}

}
