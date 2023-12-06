package POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdValidationPage {
	
	public ProdValidationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@id='dtlview_Product Name']")
    private WebElement validateProduct;
	
	//gettter method
		public WebElement getValidateProduct() {
			return validateProduct;
		}
		
		
		//Business Logic
		public String ProdValidate()
		{
			return validateProduct.getText();
		}
	
	
	
	
	
}
