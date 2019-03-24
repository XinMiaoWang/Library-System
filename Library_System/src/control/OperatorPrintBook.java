package control;
 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
 
import jdbc.database;
import model.Book;
 
public class OperatorPrintBook {
	
	public ArrayList<Book> printAllbook(){
		ArrayList<Book> booklist = new ArrayList<Book>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select id,bookname,author,category,price,isout from book;");//選擇import java.sql.ResultSet;
			
			
			if(rs.next()){
				do{
					System.out.println("編號："+rs.getInt("id")+" 書名："+rs.getString("bookname")+",作者："+rs.getString("author")+
							   ",分類："+rs.getString("category")+",價格："+rs.getFloat("price")+",狀態："+rs.getInt("isout"));
				}while(rs.next());
			}
			else
				System.out.println("圖書庫為空，請添加圖書！");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			database.close(conn, stmt, rs);
		}
		
		return booklist;
	}
	
}