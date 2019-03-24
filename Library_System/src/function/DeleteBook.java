package function;

import java.util.Scanner;

import control.OperatorPrintBook;
import control.OperatorDeleteBook;

public class DeleteBook {
	
	public void deleteBook(){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			int id = -1;
			String name = "";
			
			System.out.println("請輸入按哪種方法刪除圖書：\n"
					+ "1) 編號\n2) 書名\n3) 返回主菜單");
			int cmd = scanner.nextInt();
			
			
			if(cmd == 1){
				System.out.println("請輸入要刪除的書的編號：");
				id = scanner.nextInt();
				Delete(id,name);
			}
			else if(cmd == 2){
				System.out.println("請輸入您要刪除的書名：");
				name = scanner.next();
				Delete(id,name);
			}
			else if(cmd == 3)
				break;
			else
				System.out.println("指令錯誤！");
		}
	}
	
	
	public void Delete(int id, String name) {
		OperatorPrintBook operator = new OperatorPrintBook();
		OperatorDeleteBook operatorDelete = new OperatorDeleteBook();
		
		boolean isSuccess = operatorDelete.deleteBook(id,name);
		if(isSuccess)
			System.out.println("刪除成功！");
		else
			System.out.println("刪除失敗！請檢查您輸入的是否正確！");
		
		operator.printAllbook();
	}
}
