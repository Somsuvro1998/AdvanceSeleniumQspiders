package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertDataUsingDB {

	public static void main(String[] args) throws Throwable {
Driver driveRef=new Driver();
DriverManager.registerDriver(driveRef);
Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","@Somsuvro98");
Statement state=conn.createStatement();
String query="insert into qspiders(first_name,last_name,address)values('Ram','Gopal','Bombay')";
int result=state.executeUpdate(query);
if(result==1)
{
	System.out.println("Data is updated");
}
else
{
	System.out.println("Data not updated");
}	
	}

}
