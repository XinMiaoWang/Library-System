package function;

import java.util.Scanner;

import control.OperatorBorrowBook;

public class BorrowBook {
	public void borrowBook(){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			String name = null;
			int id = -1;
			
			System.out.println("�п�J�����ؤ�k�ɮѡG\n"
					+ "1) �s��\n2) �ѦW\n3) ����");
			
			int cmd = scanner.nextInt();
			if(cmd == 1){
				System.out.println("�п�J�n�ɪ��Ѫ��s���G");
				id = scanner.nextInt();
				Borrow(id,name);
			}
			else if(cmd == 2)
			{
				System.out.println("�п�J�z�n�ɪ��ѦW�G");
				name = scanner.next();
				Borrow(id,name);
			}
			else if(cmd == 3)
			{
				break;
			}
			else
			{
				System.out.println("���O���~�I");
			}
		}
	}
	
	public void Borrow(int bid,String bname) {
		OperatorBorrowBook operatorBorrow = new OperatorBorrowBook();
		operatorBorrow.borrowBook(bid,bname);
	}
}
