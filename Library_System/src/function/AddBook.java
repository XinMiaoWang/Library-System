package function;

import java.util.Scanner;

import control.OperatorPrintBook;
import control.OperatorAddBook;

public class AddBook {
	public void addBook(){
		
		while(true){
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("�п�JID�G");
			int id = scanner.nextInt();
			System.out.println("�п�J�ϮѦW�G");
			String bookname = scanner.next();
			System.out.println("�п�J�@�̡G");
			String author = scanner.next();
			System.out.println("�п�J�����G");
			String category = scanner.next();
			System.out.println("�п�J����G");
			float price = scanner.nextFloat();
			int isout = 0;
			
			OperatorPrintBook operator = new OperatorPrintBook();
			OperatorAddBook operatorAdd = new OperatorAddBook();
			
			boolean isSuccess = operatorAdd.addBook(id, bookname, author, category, price, isout);
			if(isSuccess)
				System.out.println("�W�[���\�I");
			else
				System.out.println("�W�[���ѡI");
			
			operator.printAllbook();
			
			System.out.println("�O�_�~��W�[�H y/n");
			char yno = scanner.next().charAt(0);
			if (yno == 'y')
				continue;
			else
				break;
		}
		
	}
}
