package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.database;
import model.Book;

public class OperatorFindBook {
	
	public ArrayList<Book> findBook(int id,String bookname,String author,String dimname,String category,float minprice,float maxprice){
		
		ArrayList<Book> booklist = new ArrayList<Book>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql;
			if (id != -1)
				sql = "select id,bookname,author,category,price,isout from book"+" where id="+id+";";
			else if(bookname != null)
				sql = "select id,bookname,author,category,price,isout from book"+" where bookname='"+bookname+"';";
			else if(author != null)
				sql = "select id,bookname,author,category,price,isout from book"+" where author='"+author+"';";
			else if(dimname != null)
				sql = "select id,bookname,author,category,price,isout from book"+" where bookname like'%"+dimname+"%';";
			else if(category != null)
				sql = "select id,bookname,author,category,price,isout from book"+" where category like'%"+category+"%';";
			else if(maxprice != 0)
				sql = "select id,bookname,author,category,price,isout from book where price>="+minprice+" and price<="+maxprice+";";
			else{
				System.out.println("�X�{�������~�A���p�t�޲z���I");
				sql="";
			}
			
			rs = stmt.executeQuery(sql);
			
			
			if(rs.next()){
				System.out.println("�d�䦨�\�I�z�d�䪺���G���G\n");
				do{
					System.out.println("�s���G"+rs.getInt("id") +" �ѦW�G"+rs.getString("bookname") +" �@�̡G"+rs.getString("author")+
									   " �����G"+rs.getString("category") +" ����G"+rs.getFloat("price") +" ���A�G"+rs.getInt("isout"));
				}while(rs.next());
			}
			else
				System.out.println("���d���z�Q�n���ϮѡI");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			database.close(conn, stmt, rs);
		}
		
		return booklist;
	}
}
