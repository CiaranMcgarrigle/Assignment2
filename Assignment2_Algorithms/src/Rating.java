
public class Rating {
	private int rating;
	private int userID;
	private int bookID;
	
	public Rating(int userID, int bookID, int rating){
		this.userID = userID;
		this.bookID = bookID;
		this.rating = rating;
	}
	
	public Rating()
	{
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String toString(){
		return ("User ID: " + userID + " Book ID: " + bookID + " Rating: " + rating + "\n");
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public int getBookID() {
		return userID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
}
