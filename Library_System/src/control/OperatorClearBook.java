package control;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.database;

public class OperatorClearBook {
	
	public boolean clearBook(){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql = "DELETE FROM 'book' ;";
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
