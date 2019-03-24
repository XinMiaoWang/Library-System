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
				System.out.println("出現未知錯誤，請聯系管理員！");
				sql="";
			}
			
			rs = stmt.executeQuery(sql);
			
			
			if(rs.next()){
				System.out.println("查找成功！您查找的結果為：\n");
				do{
					System.out.println("編號："+rs.getInt("id") +" 書名："+rs.getString("bookname") +" 作者："+rs.getString("author")+
									   " 分類："+rs.getString("category") +" 價格："+rs.getFloat("price") +" 狀態："+rs.getInt("isout"));
				}while(rs.next());
			}
			else
				System.out.println("未查找到您想要的圖書！");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			database.close(conn, stmt, rs);
		}
		
		return booklist;
	}
}
