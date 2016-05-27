package DataBase;
import java.sql.*;
public class sql_Example {

	
	/*  In this code we will test DB testing 
	 * 	suppose we enter email in website and we have to check whether same email store in DB 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		
	//Test Data 
		String emailAddress = "pawan@gmail.com";
		
		
    //SQL CONNEC 	
		
		Connection conn=null;
		
		String url = "jdbc:mysql://localhost:3306";
		//which dataBase need to connect 
		String databaseName = "test";
		
		//UserName while install sql
		String UserName= "pawan";
		String password= "pawan";

		
		try{
			//create connection
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url+databaseName, UserName, password);

			System.out.println("Connected to DB");
			
			//	Select Data from Table
			String sqlQuerry= "Select * from Demo ";
			
			
			/*Fetch LATEST Entered data frm data Base 
			 * 
			 * EmplyeeDetails -->TableName
			 * S.No -->ColNmae
			 * 
			 */
			//String sqlQuerry1= "Select * from EmplyeeDetails ORDER BY  S.No DESC LIMIT 1 ";
			
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sqlQuerry);
			
			result.next();
			System.out.println(result.getString("emailaddress"));
			System.out.println(result.getString("address"));
			System.out.println(result.getString("name"));
			/*
			 * OutPut :--
			 * Return 1st row data	
			 */
			
			
	//DataBase Testing 
			if (!result.getString("emailaddress").equals(emailAddress)) {
				System.out.println("wrg email is strored in DB");
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	finally{
		//close connect imp.
		if(conn!=null)
			conn=null;
	}
	}
}



