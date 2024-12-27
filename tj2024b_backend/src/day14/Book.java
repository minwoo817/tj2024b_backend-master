package day14;

public class Book {
	
	// 1. 멤버변수
	private String bookName;
	private String author;
	// 2. 생성자
	public Book() {}
	public Book(String bookName , String author) {
		this.bookName = bookName;
		this.author = author;
	}
	// 3. 메소드
	public String getBookName() {return this.bookName;}
	public String getAuthor() {return this.author;}
	public void setBookname(String bookname) {
		this.bookName = bookname;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

}
