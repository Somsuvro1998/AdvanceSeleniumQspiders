package POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	 public CreateProductPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this);
	 }
	 @FindBy(xpath="//img[@alt='Create Product...']")
		private WebElement productPlus;

	 @FindBy(name="productname")
	private WebElement createProduct;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	public WebElement getCreateProduct()
	{
		return createProduct;
	}
	public WebElement getProductPlus() {
		return productPlus;
	}
	
	public WebElement getSaveButton()
	{
		return saveButton;
	}
	public void clickProductPlus()
	{
		productPlus.click();
	}
	public void ProductName(String Name)
	{
		createProduct.sendKeys(Name);	
	}
	public void clickOnSaveButton()
	{
		saveButton.click();;
	}
	
		
	}
	
	

