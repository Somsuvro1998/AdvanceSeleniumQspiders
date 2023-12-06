package Practice;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Generic_utilities.ListenerImplementation;

@Listeners(Generic_utilities.ListenerImplementation.class)
public class ThreeMethods1 {
     
	//public ListenerImplementation i=new ListenerImplementation();

	@Test
	public void me1(){
		
		System.out.println("hello");
		Assert.assertEquals(true, true);
		System.out.println("Hey");
	}
	@Test
	public void me2()
	{
		System.out.println("Hola");
		Assert.assertEquals(true,true);
		System.out.println("Ciao");
	}
	@Test
	public void me3()
	{
		System.out.println("Namaskar");
		Assert.assertEquals(false,true);
		System.out.println("Namaste");
		Assert.assertEquals(false,true);
		//i.onTestFailure(null);
			
	}
}
