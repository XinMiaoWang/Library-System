package function;

import java.util.Scanner;

import control.OperatorBorrowBook;

public class BorrowBook {
	public void borrowBook(){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			String name = null;
			int id = -1;
			
			System.out.println("請輸入按哪種方法借書：\n"
					+ "1) 編號\n2) 書名\n3) 取消");
			
			int cmd = scanner.nextInt();
			if(cmd == 1){
				System.out.println("請輸入要借的書的編號：");
				id = scanner.nextInt();
				Borrow(id,name);
			}
			else if(cmd == 2)
			{
				System.out.println("請輸入您要借的書名：");
				name = scanner.next();
				Borrow(id,name);
			}
			else if(cmd == 3)
			{
				break;
			}
			else
			{
				System.out.println("指令錯誤！");
			}
		}
	}
	
	public void Borrow(int bid,String bname) {
		OperatorBorrowBook operatorBorrow = new OperatorBorrowBook();
		operatorBorrow.borrowBook(bid,bname);
	}
}
