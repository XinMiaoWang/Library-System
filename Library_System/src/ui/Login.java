package ui;

import java.util.Scanner;

import control.OperatorAddBook;
import control.OperatorAddUser;
import control.OperatorFindManager;
import control.OperatorFindUser;

public class Login {
	Scanner scanner = new Scanner(System.in);
	
	public Login() {
		
		while(this.loginMenu());
		
	}
	
	public boolean loginMenu(){
		System.out.println("----歡迎---");
		System.out.println("1) 使用者登入");
		System.out.println("2) 管理者登入");
		System.out.println("3) 註冊使用者帳號");
		System.out.println("4) 離開");
		
		return commandLine();
	}
	
	
	public boolean commandLine() {	
		String cmd = scanner.next();
		
		switch(cmd){
			case "1":
				if(this.loginUser())
					new UserUI();
				break;
			case "2": 
				if(this.loginManager())
					new ManagerUI();
				break;
			case "3": this.registered(); break;
			case "4":
				System.out.println("成功退出系統，歡迎再次光臨！");
				scanner.close();
				return false;
			default: 
				System.out.println("輸入錯誤");
		}
		return true;
	}
	
	public boolean loginUser() {
		String username = "";
		String password = "";
		OperatorFindUser operatorFindU = new OperatorFindUser();
		
		System.out.println("請輸入你的帳號 : ");
		username = scanner.next();
		System.out.println("請輸入你的密碼 : ");
		password = scanner.next();
		
		boolean isSuccess = operatorFindU.findUser(username,password);
		if(isSuccess)
			System.out.println("登入成功！");
		else
			System.out.println("登入失敗！");
		
		return isSuccess;
	}
	
	public boolean loginManager() {
		String username = "";
		String password = "";
		OperatorFindManager operatorFindM = new OperatorFindManager();
		
		System.out.println("請輸入你的帳號 : ");
		username = scanner.next();
		System.out.println("請輸入你的密碼 : ");
		password = scanner.next();
		
		boolean isSuccess = operatorFindM.findManager(username,password);
		if(isSuccess)
			System.out.println("登入成功！");
		else
			System.out.println("登入失敗！");
		
		return isSuccess;
	}
	
	public void registered() {
		int uid = -1;
		String name = "";
		String username = "";
		String password = "";
		int totalBorrowed = 0;
		
		System.out.println("請輸入你的學號 : ");
		uid = scanner.nextInt();
		System.out.println("請輸入你的姓名 : ");
		name = scanner.next();
		System.out.println("請輸入你的帳號 : ");
		username = scanner.next();
		System.out.println("請輸入你的密碼 : ");
		password = scanner.next();
		
		OperatorAddUser operatorAddUser = new OperatorAddUser();
		
		boolean isSuccess = operatorAddUser.addUser(uid, name, username, password, totalBorrowed);
		if(isSuccess)
			System.out.println("增加成功！");
		else
			System.out.println("增加失敗！");
	}
	
}
