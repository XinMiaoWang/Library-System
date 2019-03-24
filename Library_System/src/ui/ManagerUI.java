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
		System.out.println("----管理員模式----");
		System.out.println("1) 顯示所有圖書");
		System.out.println("2) 增加圖書");
		System.out.println("3) 刪除圖書");
		System.out.println("4) 修改圖書");
		System.out.println("5) 查詢圖書");
		System.out.println("6) 清空圖書");
		System.out.println("7) 登出帳號");
		
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
				System.out.println("已登出");
				return false;
			default: 
				System.out.println("指令錯誤！");
		}
		return true;
	}
 
}