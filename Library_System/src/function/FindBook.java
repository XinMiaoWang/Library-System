package function;

import java.util.Scanner;

import control.OperatorFindBook;

public class FindBook {
	public void findBook(){
		Scanner scanner = new Scanner(System.in);
		
		while(true){
			String name = null;
			int id = -1;
			String author = null;
			String dimname = null;
			String category = null;
			float minprice = 0;
			float maxprice = -1;
			
			System.out.println("�п�J�����ؤ�k�d��ϮѡG\n"
					+ "1) �s��\n2) �ѦW(��T�d��)\n3) �ѦW(�ҽk�d��)\n4) �@��\n5) ����\n6) ����\n7) ��^�D���");
			
			int cmd = scanner.nextInt();
			if(cmd == 1){
				System.out.println("�п�J�n�d�䪺�Ѫ��s���G");
				id = scanner.nextInt();
				Find(id,name,author,dimname,category,minprice,maxprice);
			}
			else if(cmd == 2)
			{
				System.out.println("�п�J�z�n�d�䪺�ѦW�G");
				name = scanner.next();
				Find(id,name,author,dimname,category,minprice,maxprice);
			}
			else if (cmd == 3)
			{
				System.out.println("�п�J�z�n�ҽk�d�䪺�ѦW�G");
				dimname = scanner.next();
				Find(id,name,author,dimname,category,minprice,maxprice);
			}
			else if (cmd == 4)
			{	
				System.out.println("�п�J�z�n�d�䪺�@�̦W�G");
				author = scanner.next();
				Find(id,name,author,dimname,category,minprice,maxprice);
			}
			else if (cmd == 5)
			{	
				System.out.println("�п�J�z�n�d�䪺�����W�G");
				category = scanner.next();
				Find(id,name,author,dimname,category,minprice,maxprice);
			}
			else if (cmd == 6)
			{
				System.out.println("�п�J�z�n�d�䪺�Ѫ����檺�̧C���G");
				minprice = scanner.nextFloat();
				System.out.println("�п�J�z�n�d�䪺�Ѫ����檺�̰����G");
				maxprice = scanner.nextFloat();
				
				Find(id,name,author,dimname,category,minprice,maxprice);
			}
			else if(cmd == 7)
			{
				break;
			}
			else
			{
				System.out.println("���O���~�I");
			}
		}
	}
	
	public void Find(int id,String name,String author,String dimname,String category,float minprice,float maxprice) {
		OperatorFindBook operatorFind = new OperatorFindBook();
		operatorFind.findBook(id,name,author,dimname,category,minprice,maxprice);
	}
}
