package control;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.database;

public class OperatorUpdateBook {
	public boolean changeBookId(int id, int newid){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql;
			sql = "update book set id='"+newid+"'"+" where id="+id+";";
			
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			database.close(conn,stmt);
		}
	}
	
	public boolean changeBookName(int id, String newname){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql;
			sql = "update book set bookname='"+newname+"'"+" where id="+id+";";
			
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			database.close(conn,stmt);
		}
	}
	
	public boolean changeBookAuthor(int id, String newauthor){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql;
			sql = "update book set author='"+newauthor+"'"+" where id="+id+";";
			
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			database.close(conn,stmt);
		}
	}
	
	public boolean changeBookPrice(int id, float newprice){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql;
			sql = "update book set price='"+newprice+"'"+" where id="+id+";";
			
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			database.close(conn,stmt);
		}
	}
	
	public boolean changeBookCategory(int id, String newcategory){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql;
			sql = "update book set category='"+newcategory+"'"+" where id="+id+";";
			
			stmt.execute(sql);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {
			database.close(conn,stmt);
		}
	}
}
