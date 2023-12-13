package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchDataFromDB {

	public static void main(String[] args) throws Throwable {
Driver driverref=new Driver();
DriverManager.registerDriver(driverref);
Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testyantra","root","@Somsuvro98");
Statement state=conn.createStatement();
String query="Select*from qspiders";
ResultSet result = state.executeQuery(query);

while(result.next())
{
	System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
	
}
conn.close();
	}

}
