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
			
			System.out.println("�п�J�����ؤ�k�R���ϮѡG\n"
					+ "1) �s��\n2) �ѦW\n3) ��^�D���");
			int cmd = scanner.nextInt();
			
			
			if(cmd == 1){
				System.out.println("�п�J�n�R�����Ѫ��s���G");
				id = scanner.nextInt();
				Delete(id,name);
			}
			else if(cmd == 2){
				System.out.println("�п�J�z�n�R�����ѦW�G");
				name = scanner.next();
				Delete(id,name);
			}
			else if(cmd == 3)
				break;
			else
				System.out.println("���O���~�I");
		}
	}
	
	
	public void Delete(int id, String name) {
		OperatorPrintBook operator = new OperatorPrintBook();
		OperatorDeleteBook operatorDelete = new OperatorDeleteBook();
		
		boolean isSuccess = operatorDelete.deleteBook(id,name);
		if(isSuccess)
			System.out.println("�R�����\�I");
		else
			System.out.println("�R�����ѡI���ˬd�z��J���O�_���T�I");
		
		operator.printAllbook();
	}
}
