package Practice;

import org.testng.annotations.Test;

import Generic_utilities.BaseClass;

public class TestNG2 extends BaseClass {

	@Test(groups= {"SanityTest","SmokeTest"})
	public void createProduct()
	{
		System.out.println("Product created");
	}
}
