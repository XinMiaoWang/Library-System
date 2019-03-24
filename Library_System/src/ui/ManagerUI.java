package ui;
 
import java.util.Scanner;
import control.OperatorPrintBook;
import function.AddBook;
import function.ClearBook;
import function.DeleteBook;
import function.FindBook;
import function.UpdateBook;
 
public class ManagerUI {
	
	Scanner scanner = new Scanner(System.in);
	AddBook addb = new AddBook();
	DeleteBook deleteb = new DeleteBook();
	UpdateBook changeb = new UpdateBook();
	FindBook findb = new FindBook();
	ClearBook clearb = new ClearBook();
	OperatorPrintBook printb = new OperatorPrintBook();
	
	public ManagerUI(){
		
		while(this.printMenu());
		
	}
	
	public boolean printMenu(){
		System.out.println("----�޲z���Ҧ�----");
		System.out.println("1) ��ܩҦ��Ϯ�");
		System.out.println("2) �W�[�Ϯ�");
		System.out.println("3) �R���Ϯ�");
		System.out.println("4) �ק�Ϯ�");
		System.out.println("5) �d�߹Ϯ�");
		System.out.println("6) �M�ŹϮ�");
		System.out.println("7) �n�X�b��");
		
		return commandLine();
	}
	
	
	public boolean commandLine() {
		
		String cmd = scanner.next();
		
		switch(cmd){
			case "1": printb.printAllbook(); break;
			case "2": addb.addBook(); break;
			case "3": deleteb.deleteBook(); break;
			case "4": changeb.changeBook(); break;
			case "5": findb.findBook(); break;
			case "6": clearb.clearBook(); break;
			case "7":
				System.out.println("�w�n�X");
				return false;
			default: 
				System.out.println("���O���~�I");
		}
		return true;
	}
 
}