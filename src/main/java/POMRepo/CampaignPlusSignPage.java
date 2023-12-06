package POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPlusSignPage {

	//initialization
	public CampaignPlusSignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Declaration
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement campaignPlus;

	//getterMethods
	public WebElement getCampaignPlus() {
		return campaignPlus;
	}
	//BusinessLogics
	/**
	 * THis method is used to click on Campaign(+)Sign
	 */
	public void clickCampaignPlus()
	{
		campaignPlus.click();
	}
}
