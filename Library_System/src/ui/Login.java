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
		System.out.println("----�w��---");
		System.out.println("1) �ϥΪ̵n�J");
		System.out.println("2) �޲z�̵n�J");
		System.out.println("3) ���U�ϥΪ̱b��");
		System.out.println("4) ���}");
		
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
				System.out.println("���\�h�X�t�ΡA�w��A�����{�I");
				scanner.close();
				return false;
			default: 
				System.out.println("��J���~");
		}
		return true;
	}
	
	public boolean loginUser() {
		String username = "";
		String password = "";
		OperatorFindUser operatorFindU = new OperatorFindUser();
		
		System.out.println("�п�J�A���b�� : ");
		username = scanner.next();
		System.out.println("�п�J�A���K�X : ");
		password = scanner.next();
		
		boolean isSuccess = operatorFindU.findUser(username,password);
		if(isSuccess)
			System.out.println("�n�J���\�I");
		else
			System.out.println("�n�J���ѡI");
		
		return isSuccess;
	}
	
	public boolean loginManager() {
		String username = "";
		String password = "";
		OperatorFindManager operatorFindM = new OperatorFindManager();
		
		System.out.println("�п�J�A���b�� : ");
		username = scanner.next();
		System.out.println("�п�J�A���K�X : ");
		password = scanner.next();
		
		boolean isSuccess = operatorFindM.findManager(username,password);
		if(isSuccess)
			System.out.println("�n�J���\�I");
		else
			System.out.println("�n�J���ѡI");
		
		return isSuccess;
	}
	
	public void registered() {
		int uid = -1;
		String name = "";
		String username = "";
		String password = "";
		int totalBorrowed = 0;
		
		System.out.println("�п�J�A���Ǹ� : ");
		uid = scanner.nextInt();
		System.out.println("�п�J�A���m�W : ");
		name = scanner.next();
		System.out.println("�п�J�A���b�� : ");
		username = scanner.next();
		System.out.println("�п�J�A���K�X : ");
		password = scanner.next();
		
		OperatorAddUser operatorAddUser = new OperatorAddUser();
		
		boolean isSuccess = operatorAddUser.addUser(uid, name, username, password, totalBorrowed);
		if(isSuccess)
			System.out.println("�W�[���\�I");
		else
			System.out.println("�W�[���ѡI");
	}
	
}
