
public class Book {
	private int bookID;
	private String name;
	private String year;
	private String author;
	private String genre;
	
	public Book(int bookID, String name, String year, String author)
	{
		this.bookID = bookID;
		this.name = name;
		this.year = year;
		this.author = author;
	}
	
	public Book()
	{
	}
	
	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String toString(){
		return "Book ID: " + bookID + " Book Name: " + name + " Date Released: " + year + " Author: " + author;
	}
}
