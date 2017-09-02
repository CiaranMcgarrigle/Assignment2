
public class User {
	private int userID;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String occupation;
	private double rating;
	
	public User(int userID, String firstName, String lastName,int age, String gender, String occupation, double rating)
	{
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.rating = rating;
		
	}
	
	public User()
	{
	}
	
	public int getUserID() {
		return userID;
	}
	
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getOccupation() {
		return occupation;
	}
	
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String toString(){
		return "UserID: " + userID + " First Name: " + firstName + " Last Name: " + lastName +
				" Age: " + age + " Gender: " + gender + " Occupation: " + occupation + " Ratings: " + rating;
	}
}