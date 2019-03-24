package model;
 
public class Book {
	private int id;
	private String bookname;
	private String author;
	private String category;
	private float price;
	private int isout;
	
	public Book(){
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.category = category;
		this.price = price;
		this.isout = isout;
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
	
	public float getIsout() { return isout; }
	public void setIsout(int isout) { this.isout = isout; }
 
}