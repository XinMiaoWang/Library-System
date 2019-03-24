package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.database;
import model.Book;

public class OperatorReturnBook {
	
	public ArrayList<Book> returnBook(int id,String bookname){
		
		ArrayList<Book> booklist = new ArrayList<Book>();
		OperatorFindUser findU = new OperatorFindUser();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql;
			if (id != -1)
				sql = "select ubid,bookname,author,category,price from UserBorrowedBook"+" where ubid="+id+" and borrower="+findU.userId+";";
			else if(bookname != null)
				sql = "select ubid,bookname,author,category,price from UserBorrowedBook"+" where bookname='"+bookname+"' and borrower="+findU.userId+";";
			else{
				System.out.println("�X�{�������~�A���p�t�޲z���I");
				sql="";
			}
			
			rs = stmt.executeQuery(sql);
			int tmpID = -1;
			
			if(rs.next()){
				System.out.println("�ٮѦ��\�I�z�٪��Ѭ��G\n");
				do{
					tmpID = rs.getInt("ubid");
					
					System.out.println("�s���G"+rs.getInt("ubid") +" �ѦW�G"+rs.getString("bookname") +" �@�̡G"+rs.getString("author")+
									   " �����G"+rs.getString("category") +" ����G"+rs.getFloat("price"));
				}while(rs.next());
			}
			else
				System.out.println("�ɮѥ��ѡA�w���H�ɥX�I");
			
			if(tmpID != -1) {
				changeBookIsout(tmpID);
				changeUserTotalBorrowed(findU.userId);
				removeUserBorrowedBook(findU.userId,tmpID);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			database.close(conn, stmt, rs);
		}
		
		return booklist;
	}
	
	
	public boolean changeBookIsout(int id){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql;
			sql = "update book set isout=0 where id="+id+";";
			
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
	
	public boolean changeUserTotalBorrowed(int id){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql;
			sql = "select uid,totalBorrowed from user"+" where uid="+id+";";
			rs = stmt.executeQuery(sql);
			int total = rs.getInt("totalBorrowed");
			
			sql = "update user set totalBorrowed="+(total-1)+" where uid="+id+";";
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
	
	public boolean removeUserBorrowedBook(int uid,int bid){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql = "delete from UserBorrowedBook where ubid="+
					  bid+" and borrower="+uid+";" ;
			
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
