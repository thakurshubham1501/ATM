package ATM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Updatebalance {
	public static void BalanceUpdate(int Account,int amount) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/test?useSSL=false","root","2001");
			Statement stmnt=con.createStatement();
			
			stmnt.executeUpdate("UPDATE Trans  SET amount='"+amount+"', Date=CURRENT_TIMESTAMP WHERE ID='"+Account+"'");
			con.close();
			}
		catch(Exception e)
		{ System.out.println(e);}	
	}
}

