package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class database {
	private static final String URL="jdbc:sqlite:database/library.db";
	private static Connection conn=null;
	
	// 連接資料庫
	public static Connection getConnection(){
		try {
			conn = DriverManager.getConnection(URL);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	//斷開資料庫連接
	public static void close(Connection con, Statement stat, ResultSet rs){
			try {
				if (rs != null)
					rs.close();
				if (stat != null)
					stat.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void close(Connection con, Statement stat){
		close(con,stat,null);
	}
}