package testdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

public class db {
	@Test
	public void testDB() throws SQLException 
	{
		// jdbc:mysql://localhost:3306/SCHEMAS
		String dbUrl = "jdbc:mysql://localhost:3306/demodb";
		String un = "root";
		String pw = "";

		// Connect to DB
		Connection con = DriverManager.getConnection(dbUrl, un, pw);

		// To send Query to DB(Path)
		Statement stmt = con.createStatement();

		// Send Query to DB(select * from TableName where ColumName = 'RecordName';)
		ResultSet res = stmt.executeQuery("select * from EmpInfo where Name = 'Raghus';");

		// Print result
		while (res.next()) 
		{
			// Get the value
			String name = res.getString("Name");
			String id = res.getString("ID");
			String dept = res.getString("Dept");
			String gender = res.getString("Gender");
			System.out.println(name + " " + id + " " + dept + " " + gender);
		}
		con.close();
	}
}
