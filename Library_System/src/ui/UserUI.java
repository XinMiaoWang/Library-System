package ui;

import java.util.Scanner;

import control.OperatorCheckUserStatus;
import control.OperatorPrintBook;
import function.BorrowBook;
import function.FindBook;
import function.ReturnBook;


public class UserUI {
	Scanner scanner = new Scanner(System.in);
	
	
	public UserUI(){
		
		while(this.printMenu());
		
	}
	
	public boolean printMenu(){
		System.out.println("----使用者模式----");
		System.out.println("1) 顯示所有圖書");
		System.out.println("2) 查詢圖書");
		System.out.println("3) 借書");
		System.out.println("4) 還書");
		System.out.println("5) 預約書");
		System.out.println("6) 查詢帳號狀態");
		System.out.println("7) 登出帳號");	
		
		return commandLine();
	}
	
	
	public boolean commandLine() {
		
		String cmd = scanner.next();
		FindBook findb = new FindBook();
		BorrowBook borrowb = new BorrowBook();
		ReturnBook returnb = new ReturnBook();
		OperatorCheckUserStatus checkuser = new OperatorCheckUserStatus();
		OperatorPrintBook printb = new OperatorPrintBook();
		
		switch(cmd){
			case "1": printb.printAllbook(); break;
			case "2": findb.findBook(); break;
			case "3": borrowb.borrowBook(); break;
			case "4": returnb.returnBook(); break;
			case "5": System.out.println("功能待新增"); break;
			case "6": checkuser.checkUserStatus(); break;
			case "7":
				System.out.println("已登出");
				return false;
			default: 
				System.out.println("指令錯誤！");
		}
		return true;
	}
}
