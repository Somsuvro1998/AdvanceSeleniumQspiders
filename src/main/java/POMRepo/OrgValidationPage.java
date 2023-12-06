package POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgValidationPage {

	public OrgValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);		
	}
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement validateOrganization;
	
	//getter method
	public WebElement getValidateOranization()
	{
		return validateOrganization;
	}
	
	
	//Business Logic
	public String orgValidate()
	{
		return validateOrganization.getText();
	}	
	
	
	
}
