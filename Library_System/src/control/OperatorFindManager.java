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
				System.out.println("�X�{�������~�A���p�t�޲z���I");
				sql="";
			}
			
			rs = stmt.executeQuery(sql);
			
			
			if(rs.next()){
				System.out.println("�d�䦨�\�I�z�d�䪺���G���G\n");
				do{
					System.out.println("�s���G"+rs.getInt("mid") +" �m�W�G"+rs.getString("name")+" �b���G"+rs.getString("username") +
									   " �K�X�G"+rs.getString("password"));
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
