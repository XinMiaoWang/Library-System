package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.database;
import model.Book;
import model.User;

public class OperatorBorrowBook {
	
	public ArrayList<Book> borrowBook(int id,String bookname){
		
		ArrayList<Book> booklist = new ArrayList<Book>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql;
			if (id != -1)
				sql = "select id,bookname,author,category,price,isout from book"+" where id="+id+" and isout=0 ;";
			else if(bookname != null)
				sql = "select id,bookname,author,category,price,isout from book"+" where bookname='"+bookname+"' and isout=0 ;";
			else{
				System.out.println("�X�{�������~�A���p�t�޲z���I");
				sql="";
			}
			
			rs = stmt.executeQuery(sql);
			int tmpID = -1;
			String tmpBookname = "";
			String tmpAuthor = "";
			String tmpCategory = "";
			float tmpPrice = -1;
			
			if(rs.next()){
				System.out.println("�ɮѦ��\�I�z�ɮѪ����G���G\n");
				do{//�p�G��H�����ƾڡA�N�|�`�����L�X��
					tmpID = rs.getInt("id");
					tmpBookname = rs.getString("bookname");
					tmpAuthor = rs.getString("author");
					tmpCategory = rs.getString("category");
					tmpPrice = rs.getFloat("price");
					
					System.out.println("�s���G"+rs.getInt("id") +" �ѦW�G"+rs.getString("bookname") +" �@�̡G"+rs.getString("author")+
									   " �����G"+rs.getString("category") +" ����G"+rs.getFloat("price") +" ���A�G1");
				}while(rs.next());
			}
			else
				System.out.println("�ɮѥ��ѡA�w���H�ɥX�I");
			
			if(tmpID != -1) {
				changeBookIsout(tmpID);
				OperatorFindUser findU = new OperatorFindUser();
				changeUserTotalBorrowed(findU.userId);
				addUserBorrowedBook(findU.userId,tmpID,tmpBookname,tmpAuthor,tmpCategory,tmpPrice);
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
			sql = "update book set isout=1 where id="+id+";";
			
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
			
			sql = "update user set totalBorrowed="+(total+1)+" where uid="+id+";";
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
	
	public boolean addUserBorrowedBook(int uid,int bid,String bookname,String author,String category,float price){
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql = "insert into UserBorrowedBook(ubid,bookname,author,category,price,borrower) values("+
					  bid+",'"+bookname+"','"+author+"','"+category+"',"+price+","+uid+");" ;
			
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
