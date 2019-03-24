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
			
			System.out.println("請輸入按哪種方法查找圖書：\n"
					+ "1) 編號\n2) 書名(精確查找)\n3) 書名(模糊查找)\n4) 作者\n5) 分類\n6) 價格\n7) 返回主菜單");
			
			int cmd = scanner.nextInt();
			if(cmd == 1){
				System.out.println("請輸入要查找的書的編號：");
				id = scanner.nextInt();
				Find(id,name,author,dimname,category,minprice,maxprice);
			}
			else if(cmd == 2)
			{
				System.out.println("請輸入您要查找的書名：");
				name = scanner.next();
				Find(id,name,author,dimname,category,minprice,maxprice);
			}
			else if (cmd == 3)
			{
				System.out.println("請輸入您要模糊查找的書名：");
				dimname = scanner.next();
				Find(id,name,author,dimname,category,minprice,maxprice);
			}
			else if (cmd == 4)
			{	
				System.out.println("請輸入您要查找的作者名：");
				author = scanner.next();
				Find(id,name,author,dimname,category,minprice,maxprice);
			}
			else if (cmd == 5)
			{	
				System.out.println("請輸入您要查找的分類名：");
				category = scanner.next();
				Find(id,name,author,dimname,category,minprice,maxprice);
			}
			else if (cmd == 6)
			{
				System.out.println("請輸入您要查找的書的價格的最低價：");
				minprice = scanner.nextFloat();
				System.out.println("請輸入您要查找的書的價格的最高價：");
				maxprice = scanner.nextFloat();
				
				Find(id,name,author,dimname,category,minprice,maxprice);
			}
			else if(cmd == 7)
			{
				break;
			}
			else
			{
				System.out.println("指令錯誤！");
			}
		}
	}
	
	public void Find(int id,String name,String author,String dimname,String category,float minprice,float maxprice) {
		OperatorFindBook operatorFind = new OperatorFindBook();
		operatorFind.findBook(id,name,author,dimname,category,minprice,maxprice);
	}
}
