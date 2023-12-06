package Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
    
	@Test
	public void m1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		Assert.assertEquals(false,true);
		System.out.println("Step4");
		System.out.println("Step5");
	}
	@Test
	public void m2()
	{
		String ExpData="Qspider";
		String ActData="Qspider";
		Assert.assertEquals(ActData, ExpData);
	}
}
