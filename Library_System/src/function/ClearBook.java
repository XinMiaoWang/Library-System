package function;

import control.OperatorClearBook;

public class ClearBook {
	
	public void clearBook(){
		OperatorClearBook operatorClear = new OperatorClearBook();
		
		boolean isSuccess = operatorClear.clearBook();
		if(isSuccess)
			System.out.println("�M�Ŧ��\�I");
		else
			System.out.println("�M�ť��ѡI");
		
	}
}	
