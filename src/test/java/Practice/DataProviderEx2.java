package Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_utilities.Excel_Utility;

public class DataProviderEx2 {
	
	@Test(dataProvider="getData")
	public void bookTickets(String src,String dest)
	{
		System.out.println("Book tickets from "+src+" to "+dest+".");
	}
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		
		Excel_Utility elib=new Excel_Utility();
		Object[][]value=elib.getDataProvider("Sheet1");
		return value;
		
	}
	
	
	
	
	

}
