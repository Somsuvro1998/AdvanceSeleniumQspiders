package Practice;

import org.testng.annotations.Test;


public class TestNG {

	@Test(groups={"SanityTest","SmokeTest"})
public void createProduct()
	{
		System.out.println("product created");
	}
	
	@Test
	public void modifyProduct()
	{
		System.out.println("Product modified");
	}
	@Test(enabled=false)
	public void deleteProduct()
	{
		System.out.println("product deleted");
	}
}
