package servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LogInDao 
{
	public boolean check(String uname, String pass)
	{
		String sql = "select * from login where uname=? and pass=?";
		String url = "jdbc:mysql://localhost:3306/first_schema";
		String userName="root";
		String Pass = "123456";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con =DriverManager.getConnection(url,userName,Pass);
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, pass);
			
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{
				return true; 
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println("smtngn wrng with database");
		
		}
		return false;
			
		
		
	
	}
}
