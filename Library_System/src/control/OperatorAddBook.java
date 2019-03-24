package control;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.database;

public class OperatorAddBook {
	public boolean addBook(int id, String bookname, String author,String category, float price, int isout){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into book(id,bookname,author,category,price,isout) values("+
						  id+",'"+bookname+"','"+author+"','"+category+"',"+price+","+isout+");" ;
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
