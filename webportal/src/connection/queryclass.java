package connection;

import java.sql.*;

import org.zkoss.zul.Messagebox;

public class queryclass {

	Statement st;
	Connection conn;
	ResultSet rs;
	String search; 
	public queryclass()
	{
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
	      
          conn = DriverManager.getConnection(
             "jdbc:mysql://localhost/webportal?user=root&password=root");	
		 }
		 catch(Exception e)
		 {
				Messagebox.show(e.getMessage());	 
		 }
		 
	}

	public ResultSet selectquery(String query)
	{
		try
		{
			st=conn.createStatement();
		  	String str1 = query;
		  	rs=st.executeQuery(str1);
		}
		catch(Exception e)
		{
			Messagebox.show(e.getMessage());
		}
		return rs;
	}
	
	public void insertquery(String query)
	{
		try
		{
			
			st=conn.createStatement();
		  	String str1 = query;
		  	st.executeUpdate(str1);
		  	
		}
		catch(Exception e)
		{
			
			Messagebox.show(e.getMessage());
		}
		
	}
	
	public void deletequery(String query)
	{
		try
		{
			st=conn.createStatement();
		  	String str1 = query;
		  	st.executeUpdate(str1);
		  	
		}
		catch(Exception e)
		{
			Messagebox.show(e.getMessage());
		}	
	}
	
	public void updatequery(String query)
	{
		try
		{
			st=conn.createStatement();
		  	String str1 = query;
		  	st.executeUpdate(str1);
		  	
		}
		catch(Exception e)
		{
			Messagebox.show(e.getMessage());
		}
	}
	
	public String Searchquery(String query)
	{
		
		try
		{
			st=conn.createStatement();
		  	String str1 = query;
		  	rs=st.executeQuery(str1);
		  	search=rs.getString(0);
		}
		catch(Exception e)
		{
			Messagebox.show(e.getMessage());
		}
		return search;
		
	}
	
}
