package function;

import java.util.Scanner;

import control.OperatorPrintBook;
import control.OperatorUpdateBook;

public class UpdateBook {
	
	Scanner scanner = new Scanner(System.in);
	OperatorPrintBook operator = new OperatorPrintBook();
	OperatorUpdateBook operatorUpdate = new OperatorUpdateBook();
	
	public void changeBook(){
		
		while(true){
						
			System.out.println("請輸入要修改的書的編號：");
			int id = scanner.nextInt();
			
			System.out.println("請問要修改哪一部分的資料：\n"
			+"1) 編號\n2) 書名\n3) 作者\n4) 價錢\n5) 分類\n6) 返回主菜單");
			
			String cmd = scanner.next();
			
			if(cmd.equals("1")) { UpdateBookId(id); }
			else if(cmd.equals("2")) { UpdateBookName(id); }
			else if(cmd.equals("3")) { UpdateBookAuthor(id); }
			else if(cmd.equals("4")) { UpdateBookPrice(id); }
			else if(cmd.equals("5")) { UpdateBookCategory(id); }
			else if(cmd.equals("6")) { break; }
			else {
				System.out.println("指令錯誤！");
				continue;
			}
			
			System.out.println("是否要繼續修改書的資料(y/n)?");
			cmd = scanner.next();
			if(cmd.equals("n"))
				break;
		}
			
	}
	
		
	public void UpdateBookId(int id) {
		System.out.println("請輸入新的編號：");
		int newid = scanner.nextInt();
		boolean isSuccess = operatorUpdate.changeBookId(id,newid);
		if(isSuccess)
			System.out.println("修改成功！");
		else
			System.out.println("修改失敗！");
		operator.printAllbook();
	}
	
	
	public void UpdateBookName(int id) {
		System.out.println("請輸入新的書名：");
		String name = scanner.next();
		boolean isSuccess = operatorUpdate.changeBookName(id,name);
		if(isSuccess)
			System.out.println("修改成功！");
		else
			System.out.println("修改失敗！");
		operator.printAllbook();
	}
	
	
	public void UpdateBookAuthor(int id) {
		System.out.println("請輸入新的作者：");
		String author = scanner.next();
		boolean isSuccess = operatorUpdate.changeBookAuthor(id,author);
		if(isSuccess)
			System.out.println("修改成功！");
		else
			System.out.println("修改失敗！");
		operator.printAllbook();
	}
	
	
	public void UpdateBookPrice(int id) {
		System.out.println("請輸入新的價錢：");
		float price = scanner.nextInt();
		boolean isSuccess = operatorUpdate.changeBookPrice(id,price);
		if(isSuccess)
			System.out.println("修改成功！");
		else
			System.out.println("修改失敗！");
		operator.printAllbook();
	}
	
	
	public void UpdateBookCategory(int id) {
		System.out.println("請輸入新的分類：");
		String category = scanner.next();
		boolean isSuccess = operatorUpdate.changeBookCategory(id,category);
		if(isSuccess)
			System.out.println("修改成功！");
		else
			System.out.println("修改失敗！");
		operator.printAllbook();
	}
	
}
