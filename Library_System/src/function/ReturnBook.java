package function;

import java.util.Scanner;

import control.OperatorReturnBook;

public class ReturnBook {
	
	public void returnBook(){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			String name = null;
			int id = -1;
			
			System.out.println("�п�J�����ؤ�k�ٮѡG\n"
					+ "1) �s��\n2) �ѦW\n3) ����");
			
			int cmd = scanner.nextInt();
			if(cmd == 1){
				System.out.println("�п�J�n�٪��Ѫ��s���G");
				id = scanner.nextInt();
				Return(id,name);
			}
			else if(cmd == 2)
			{
				System.out.println("�п�J�z�n�٪��ѦW�G");
				name = scanner.next();
				Return(id,name);
			}
			else if(cmd == 3)
			{
				break;
			}
			else
			{
				System.out.println("��J�D�k�I");
			}
		}
	}
	
	public void Return(int bid,String bname) {
		OperatorReturnBook operatorReturn = new OperatorReturnBook();
		operatorReturn.returnBook(bid,bname);
	}
}
