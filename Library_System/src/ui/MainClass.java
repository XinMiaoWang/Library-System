package ui;
  
public class MainClass {
	
	public static void main(String[] args) {
		try {
			new Login();
		}
		catch( IllegalArgumentException ex ){
			System.out.println(ex) ;
			System.exit(1);
		}
		catch( Exception ex ){
			System.out.println( ex.getMessage() );
		}	
	}
 
}