package function;

import control.OperatorClearBook;

public class ClearBook {
	
	public void clearBook(){
		OperatorClearBook operatorClear = new OperatorClearBook();
		
		boolean isSuccess = operatorClear.clearBook();
		if(isSuccess)
			System.out.println("清空成功！");
		else
			System.out.println("清空失敗！");
		
	}
}	
