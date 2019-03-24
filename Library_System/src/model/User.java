package model;

public class User {
	public int uid;
	public String name;
	public String username;
	public String password;
	public int totalBorrowed;
	
	public User(){
		this.uid = uid;
		this.name = name;
		this.username = username;
		this.password = password;
		this.totalBorrowed = totalBorrowed;
	}
	
	public int getUserid() { return uid; }
	public void setUserid(int uid) { this.uid = uid; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getUsername() { return username; }
	public void setUsername(String username) { this.username = username; }

	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public int getTotalBorrowed() { return totalBorrowed; }
	public void setTotalBorrowed(int totalBorrowed) { this.totalBorrowed = totalBorrowed; }
	
}
