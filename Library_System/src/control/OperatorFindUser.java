package control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import jdbc.database;
import model.User;

public class OperatorFindUser {
	public static int userId = -1;
	public boolean findUser(String username,String password){
		
		ArrayList<User> userlist = new ArrayList<User>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = database.getConnection();
			stmt = conn.createStatement();
			String sql;
			if(username!=null && password!=null)
				sql = "select uid,name,username,password,totalBorrowed from user"+" where username='"+username+"'and password='"+password+"';";
			else{
				System.out.println("�X�{�������~�A���p�t�޲z���I");
				sql="";
			}
			
			rs = stmt.executeQuery(sql);
			
			
			if(rs.next()){
				System.out.println("�d�䦨�\�I�z�d�䪺���G���G\n");
				do{
					userId = rs.getInt("uid");
					System.out.println("�Ǹ��G"+rs.getInt("uid") + " �m�W�G"+rs.getString("name") + " �b���G"+rs.getString("username") +
									   " �K�X�G"+rs.getString("password")+" �ثe�ɤF�h�֮ѡG"+rs.getInt("totalBorrowed"));
				}while(rs.next());
				return true;
			}
			else
				System.out.println("���d���z���b���I");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			database.close(conn, stmt, rs);
		}
		
		return false;
	}
}
