package POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampValidationPage {

	public CampValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
     private WebElement validateCampaign;
    
	
	//gettter method
	public WebElement getValidateCampaign() {
		return validateCampaign;
	}
	
	
	//Business Logic
	public String campValidate()
	{
		return validateCampaign.getText();
	}
}

