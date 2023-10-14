package ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FindCustomerAccount {
	
	public static String selectaccount(int id) {
		String a="";
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/test?useSSL=false","root","2001");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM Trans where id='"+id+"'");
			while(rs.next()) {  
				a=rs.getString(2);
			}
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}	
		return a;
	}
}

