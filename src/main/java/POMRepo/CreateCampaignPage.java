package POMRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement campaignplus;
	
	@FindBy(name="campaignname")
	private WebElement createCampaign;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	public WebElement getCampaignPlus()
	{
		return campaignplus;
	}
	public WebElement getCreateCampaign() {
		return createCampaign;
	}
	
	public WebElement getSaveButton() {
		return saveButton;
	}
    public void addCampaign()
    {
    	campaignplus.click();
    }
    public void campaignName(String Name)
	{
		createCampaign.sendKeys(Name);
	}
    
    public void clickOnSaveButton()
    {
    	saveButton.click();
    }
}

