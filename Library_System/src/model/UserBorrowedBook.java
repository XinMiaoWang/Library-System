package model;

public class UserBorrowedBook {
	private int id;
	private String bookname;
	private String author;
	private String category;
	private float price;
	private String borrower;
	
	public UserBorrowedBook(){
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.category = category;
		this.price = price;
		this.borrower = borrower;
	}

	public int getBookid() { return id; }
	
	public String getBookname() { return bookname; }
	public void setBookname(String bookname) { this.bookname = bookname; }

	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }
	
	public String getCategory() { return category; }
	public void setCategory(String category) { this.category = category; }
	
	public float getPrice() { return price; }
	public void setPrice(float price) { this.price = price; }
	
	public String getBorrower() { return borrower; }
	public void setBorrower(String borrower) { this.borrower = borrower; }
	
}
