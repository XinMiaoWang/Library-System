package function;

import java.util.Scanner;

import control.OperatorPrintBook;
import control.OperatorAddBook;

public class AddBook {
	public void addBook(){
		
		while(true){
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("請輸入ID：");
			int id = scanner.nextInt();
			System.out.println("請輸入圖書名：");
			String bookname = scanner.next();
			System.out.println("請輸入作者：");
			String author = scanner.next();
			System.out.println("請輸入分類：");
			String category = scanner.next();
			System.out.println("請輸入單價：");
			float price = scanner.nextFloat();
			int isout = 0;
			
			OperatorPrintBook operator = new OperatorPrintBook();
			OperatorAddBook operatorAdd = new OperatorAddBook();
			
			boolean isSuccess = operatorAdd.addBook(id, bookname, author, category, price, isout);
			if(isSuccess)
				System.out.println("增加成功！");
			else
				System.out.println("增加失敗！");
			
			operator.printAllbook();
			
			System.out.println("是否繼續增加？ y/n");
			char yno = scanner.next().charAt(0);
			if (yno == 'y')
				continue;
			else
				break;
		}
		
	}
}
