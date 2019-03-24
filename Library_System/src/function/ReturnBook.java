package function;

import java.util.Scanner;

import control.OperatorReturnBook;

public class ReturnBook {
	
	public void returnBook(){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			String name = null;
			int id = -1;
			
			System.out.println("請輸入按哪種方法還書：\n"
					+ "1) 編號\n2) 書名\n3) 取消");
			
			int cmd = scanner.nextInt();
			if(cmd == 1){
				System.out.println("請輸入要還的書的編號：");
				id = scanner.nextInt();
				Return(id,name);
			}
			else if(cmd == 2)
			{
				System.out.println("請輸入您要還的書名：");
				name = scanner.next();
				Return(id,name);
			}
			else if(cmd == 3)
			{
				break;
			}
			else
			{
				System.out.println("輸入非法！");
			}
		}
	}
	
	public void Return(int bid,String bname) {
		OperatorReturnBook operatorReturn = new OperatorReturnBook();
		operatorReturn.returnBook(bid,bname);
	}
}
