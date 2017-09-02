
public interface Recommender {
	public void addUser(String firstName,String lastName,int age,String gender,String occupation);
	public void removeUser(int userID);
	public void addBook(String title, int year, String url);
	public void addRating(int userID, int movieID, int rating);
	public void getBook(int movieID);
	public void getUserRatings(int userID);
	public void getUserRecommendations(int userID);
	public String getTopFiveBooks();
	public void load();
	public void write();
}
