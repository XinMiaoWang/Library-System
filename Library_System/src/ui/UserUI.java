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
		System.out.println("----�ϥΪ̼Ҧ�----");
		System.out.println("1) ��ܩҦ��Ϯ�");
		System.out.println("2) �d�߹Ϯ�");
		System.out.println("3) �ɮ�");
		System.out.println("4) �ٮ�");
		System.out.println("5) �w����");
		System.out.println("6) �d�߱b�����A");
		System.out.println("7) �n�X�b��");	
		
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
			case "5": System.out.println("�\��ݷs�W"); break;
			case "6": checkuser.checkUserStatus(); break;
			case "7":
				System.out.println("�w�n�X");
				return false;
			default: 
				System.out.println("���O���~�I");
		}
		return true;
	}
}
