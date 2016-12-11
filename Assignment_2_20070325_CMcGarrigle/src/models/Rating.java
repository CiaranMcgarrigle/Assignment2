package models;


public class Rating {
	private int rating;
	private int userID;
	private int movieID;
	
	public Rating(int userID, int movieID, int rating){
		this.userID = userID;
		this.movieID = movieID;
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
		return ("User ID: " + userID + " Movie ID: " + movieID + " Rating: " + rating + "\n");
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public int getMovieID() {
		return userID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}
}