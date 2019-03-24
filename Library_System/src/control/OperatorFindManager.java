package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.database;
import model.Manager;

public class OperatorFindManager {
	
	public boolean findManager(String username,String password){
		
		ArrayList<Manager> managerlist = new ArrayList<Manager>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql;
			if(username!=null && password!=null)
				sql = "select mid,name,username,password from manager"+" where username='"+username+"'and password='"+password+"';";
			else{
				System.out.println("出現未知錯誤，請聯系管理員！");
				sql="";
			}
			
			rs = stmt.executeQuery(sql);
			
			
			if(rs.next()){
				System.out.println("查找成功！您查找的結果為：\n");
				do{
					System.out.println("編號："+rs.getInt("mid") +" 姓名："+rs.getString("name")+" 帳號："+rs.getString("username") +
									   " 密碼："+rs.getString("password"));
				}while(rs.next());
				return true;
			}
			else
				System.out.println("未查找到您的帳號！");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			database.close(conn, stmt, rs);
		}
		
		return false;
	}
}
