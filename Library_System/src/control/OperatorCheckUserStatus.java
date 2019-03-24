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
				System.out.println("�d�䦨�\�I�z�d�䪺���G���G\n");
				do{
					System.out.println("�Ǹ��G"+rs.getInt("uid") + " �m�W�G"+rs.getString("name")  +
									   " �ثe�ɤF�h�֮ѡG"+rs.getInt("totalBorrowed") );
				}while(rs.next());
			}
			else
				System.out.println("�X�{�������~�A���p���޲z���I");
			
			
			sql = "select ubid,bookname,author,category,price from UserBorrowedBook"+" where borrower="+findU.userId+";";
			rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				System.out.println("�A�ɪ��ѡG\n");
				do{
					System.out.println("�s���G"+rs.getInt("ubid") +" �ѦW�G"+rs.getString("bookname") +" �@�̡G"+rs.getString("author")+
									   " �����G"+rs.getString("category") +" ����G"+rs.getFloat("price"));
				}while(rs.next());
			}
			else
				System.out.println("���ɮѡI");
			
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
