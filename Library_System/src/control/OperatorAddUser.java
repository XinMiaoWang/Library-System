package control;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.database;

public class OperatorAddUser {
	public boolean addUser(int id, String name, String username, String password,int totalBorrowed){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into user(uid,name,username,password,totalBorrowed) values("+
						  id+",'"+name+"','"+username+"','"+password+"',"+totalBorrowed+");" ;
			//System.out.println(sql);
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			database.close(conn, stmt);
		}
	}
}
