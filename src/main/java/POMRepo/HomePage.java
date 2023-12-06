package POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_utilities.Webdriver_Utility;

public class HomePage {

	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText ="Campaigns")
	private WebElement CampaignsLink;

	//organization
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	//LOgOut
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminisatorSign;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	//getterMethods
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}
	
	public WebElement getProductSign()
	{
		return productLink;
	}
	
	public WebElement getAdminisatorSign() {
		return AdminisatorSign;
	}
	

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	//Business Logics
	/**
	 * This method is used to click on moreLink
	 */
	public void clickOnMoreLink()
	{
		moreLink.click();
	}
	
	/**
	 * This method is used to click on campaignsLink
	 */
	public void clickOnCampaigns()
	{
		CampaignsLink.click();
	}
	
	/**
	 * This method is used to click on OrganizationLink
	 */
	public void clickOrgnaizationLink()
	{
		organizationLink.click();
	}

    /**
     * This method is used to click on productLink
     */
	public void clickProductLink()
	{
		productLink.click();
	}
	/**
	 * click more link using Action class
	 * @param driver
	 */
	public void clickMoreLink(WebDriver driver)
	{
		Webdriver_Utility wlib=new Webdriver_Utility();
	wlib.ActionsMoveToElement(driver, moreLink);
	CampaignsLink.click();
	}
	
	public void Logout(WebDriver driver)
	{
		Webdriver_Utility wlib=new Webdriver_Utility();
		wlib.ActionsMoveToElement(driver, AdminisatorSign);
		signOutLink.click();
	}
}