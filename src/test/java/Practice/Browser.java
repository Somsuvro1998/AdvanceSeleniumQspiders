package Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public static void main(String[] args) {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		driver.get("http://localhost:8888/");
		//what is the issue?
       //  can't open localhost
         //its working
		//I'll show u once
	}

}
