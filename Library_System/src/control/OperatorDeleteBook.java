package control;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.database;

public class OperatorDeleteBook {
	public boolean deleteBook(int id,String bookname){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql;
			if(id != -1)
				sql = "delete from book where id ="+id+";";
			else
				sql = "delete from book where bookname ='"+bookname+"';";
			
			if(stmt.execute(sql))
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			database.close(conn, stmt);
		}
	}
}
