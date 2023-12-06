package Organization;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import Generic_utilities.Excel_Utility;
import Generic_utilities.File_Utility;
import Generic_utilities.Java_Utility;
import Generic_utilities.Webdriver_Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganization {

	public static void main(String[] args) throws Throwable {
		
		WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		/*driver.get("http://localhost:8888/");*/
		Webdriver_Utility wlib=new Webdriver_Utility();
        Java_Utility jlib=new Java_Utility();
        Excel_Utility elib=new Excel_Utility();
		File_Utility flib=new File_Utility();
		

		wlib.maximizingWindow(driver);
		wlib.implicitwait(driver);
		
		
		String URL=flib.getKeyAndValueData("url");
		String USERNAME=flib.getKeyAndValueData("username");
		String PASSWORD=flib.getKeyAndValueData("password");
	  	/*driver.get("http://localhost:8888/");*/
		driver.get(URL);		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Organizations")).click();
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();


int ranNum=jlib.getRandomNum();

//Random Approach To avoid Duplicates
/*Random ran = new Random();
int ranNum = ran.nextInt(1000);*/

/*FileInputStream fes=new FileInputStream("./src/test/resources/Testdata1.xlsx");
Workbook book=WorkbookFactory.create(fes);
Sheet sheet=book.getSheet("Organanization");
Row row=sheet.getRow(0);
Cell cel=row.getCell(0);


String OrgName = cel.getStringCellValue()+ranNum;*/

String OrgName=elib.getDataFormatterData("Organization",0,0)+ranNum;
driver.findElement(By.name("accountname")).sendKeys(OrgName);

driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(3000);
String PrdName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
if(PrdName.contains(OrgName))
{
	System.out.println("Organization Created");
}
else
{
	System.out.println("Organization not created");
}

driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.linkText("Sign Out")).click();
	}

}