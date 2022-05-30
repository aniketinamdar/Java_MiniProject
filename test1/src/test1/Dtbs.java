package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dtbs {
	private Connection connection = null;
	private Statement statement = null;
	public ResultSet resultset = null;
	Dtbs() {
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehe", "root", "12345");
            
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
	}
	
	public void exec(String s) {
		try {
			statement.execute(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] qry(String s) {
		String[] res = new String[2];
		try {
			
			resultset = statement.executeQuery(s);
			while (resultset.next()) {
				res[0] = resultset.getString("Password");
				res[1] = resultset.getString("Name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void dbClose() {
		try {
			connection.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}


//            statement = connection.createStatement();
//ResultSet resultSet;
//resultSet = statement.executeQuery(
//    "select * from users");
//int code;
//// String title;
//while (resultSet.next()) {
//    code = resultSet.getInt("id");
//    // title = resultSet.getString("title").trim();
//    System.out.println("Code : " + code);
//}
//resultSet.close();
//statement.close();
//connection.close();
