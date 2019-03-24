package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.database;
import model.User;

public class OperatorCheckUserStatus {
	
	public boolean checkUserStatus(){
		
		ArrayList<User> userlist = new ArrayList<User>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			OperatorFindUser findU = new OperatorFindUser();
			
			String sql;
			sql = "select uid,name,totalBorrowed from user"+" where uid="+findU.userId+";";
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				System.out.println("查找成功！您查找的結果為：\n");
				do{
					System.out.println("學號："+rs.getInt("uid") + " 姓名："+rs.getString("name")  +
									   " 目前借了多少書："+rs.getInt("totalBorrowed") );
				}while(rs.next());
			}
			else
				System.out.println("出現未知錯誤，請聯絡管理員！");
			
			
			sql = "select ubid,bookname,author,category,price from UserBorrowedBook"+" where borrower="+findU.userId+";";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				System.out.println("你借的書：\n");
				do{
					System.out.println("編號："+rs.getInt("ubid") +" 書名："+rs.getString("bookname") +" 作者："+rs.getString("author")+
									   " 分類："+rs.getString("category") +" 價格："+rs.getFloat("price"));
				}while(rs.next());
			}
			else
				System.out.println("未借書！");
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			database.close(conn, stmt, rs);
		}
		
		return false;
	}
}
