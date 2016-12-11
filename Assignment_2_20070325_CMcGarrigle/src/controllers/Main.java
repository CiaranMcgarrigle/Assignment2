package controllers;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.introcs.In;
import models.Movie;
import models.User;
import utils.SerializerXML;
import models.Rating;

public class Main {
	private Scanner input;
	private ArrayList<User> users;
	private ArrayList<Movie> movies;
	private ArrayList<Rating> ratings;
	private Movie movie;
	private User user;
	private Rating rating;
	
	public static void main(String [] args) throws Exception
	{
		Main driver = new Main();
		User user = new User();
		Movie movie = new Movie();
		Rating rating = new Rating();
	}
	
	/**
	 * Sets up the driver
	 * @throws Exception 
	 */
	public Main() throws Exception
	{
		input = new Scanner(System.in);
		users = new ArrayList<User>();
		movies = new ArrayList<Movie>();
		ratings = new ArrayList<Rating>();
		user = new User();
		movie = new Movie();
		rating = new Rating();
		File datastore = new File("datastore.xml");
	    SerializerXML serializer = new SerializerXML(datastore);
		run();
	}
	
	
	private int mainMenu()
	{
		int command = 0;
		System.out.println("Choose An Option");
		System.out.println("1) Import Users");
		System.out.println("2) Print User Details");
		System.out.println("3) Add User");
		System.out.println("4) Edit User");
		System.out.println("5) Delete User");
		System.out.println("6) Import Movies");
		System.out.println("7) Print Movies");
		System.out.println("8) Get Movie");
		System.out.println("9) Import Ratings");
		System.out.println("10)Print Ratings");
		System.out.println("11)Add Rating");
		System.out.println("12)Get User Ratings");
		System.out.println("0) Exit");
		command = input.nextInt();
		return command;
	}

	private void run() throws Exception
	{
		int choice = mainMenu();
		while(choice != 0)
		{
			switch(choice)
			{
			case 1:
				addUsers();
			break;
			case 2:
				printUsers();
			break;
			case 3:
				addUser();
			break;
			case 4:
				editUser();
			break;
			case 5:
				removerUser();
			break;
			case 6:
				addMovies();
			break;
			case 7:
				printMovies();
			break;
			case 8:
				getMovie();
			break;
			case 9:
				addRatings();
			break;
			case 10:
				printRatings();
			break;
			case 11:
				addRating();
			break;
			case 12:
				getUserRatings();
			break;
			default:
				System.out.println("Invalid option entered");
			break;
			}
			
			input.nextLine();
			choice = mainMenu();
		}
	}

	 public ArrayList<User> addUsers(){
		 File usersFile = new File("users5.dat");
		 // ArrayList<User> users = new ArrayList<User>();
	     In inUsers = new In(usersFile);
	     //each field is separated(delimited) by a '|'
	     String delims = "[|]";
	     while (!inUsers.isEmpty()) {
	         // get user and rating from data source
	         String userDetails = inUsers.readLine();

	         // parse user details string
	         String[] userTokens = userDetails.split(delims);
	            
	         users.add(new User(Integer.parseInt(userTokens[0]), userTokens[1], userTokens[2], Integer.parseInt(userTokens[3]), userTokens[4], userTokens[5]));
	    }
	    return users;
	}
	
	public void printUsers(){
		for (int i=0; i<users.size();i++){
			System.out.println(users.get(i));
		}
	}
	
	public void addUser(){
		input.nextLine();
		int userID = users.size()+1;
		String firstName;
		String lastName;
		int age;
		String gender;
		String occupation;
		long rating;
		System.out.print("First Name: ");
		firstName = input.nextLine();
		System.out.print("lastName: ");
		lastName = input.nextLine();
		System.out.print("Age: ");
		age = input.nextInt();
		System.out.print("Gender: ");
		input.nextLine();
		gender = input.nextLine();
		System.out.print("Occupation : ");
		occupation = input.nextLine();
		System.out.print("Ratings: ");
		rating = input.nextLong();
		
		users.add(new User(userID, firstName, lastName, age, gender, occupation));
	}
	
	public void editUser()
	{
		for (int i=0;i<users.size();i++)
		{
			System.out.println("UserID: " + users.get(i).getUserID() + " First Name: "+users.get(i).getFirstName()+" Last Name: "+users.get(i).getLastName());
		}
		System.out.println("Select a User");
		int userID = input.nextInt()-1;
		users.remove(userID-1);
		for (int i=0;i<users.size();i++){
			users.get(i).setUserID(users.get(i).getUserID()-1);
		}
		addUser();
	}
	
	public void removerUser()
	{
		int userID = 0;
		
		for (int i=0;i<users.size();i++)
		{
			if(users.get(i)!=null)
			System.out.println("UserID: " + users.get(i).getUserID() + " First Name: "+users.get(i).getFirstName()+" Last Name: "+users.get(i).getLastName());
		}
		System.out.println("Select a User");
		userID = input.nextInt()-1;
		users.set(userID, null);
		
		/*for (int i=0;i<ratings.size();i++)
			{
				if(userID == ratings.get(i).getUserID()&&!(ratings.get(i).getUserID() == null))
				ratings.set(i, null);
			} */
	}
	
	 public ArrayList<Movie> addMovies(){
		 File usersFile = new File("items5.dat");
		 // ArrayList<User> users = new ArrayList<User>();
	     In inUsers = new In(usersFile);
	     //each field is separated(delimited) by a '|'
	     String delims = "[|]";
	     while (!inUsers.isEmpty()) {
	         // get user and rating from data source
	         String userDetails = inUsers.readLine();

	         // parse user details string
	         String[] userTokens = userDetails.split(delims);
	            
	         movies.add(new Movie(Integer.parseInt(userTokens[0]), userTokens[1], userTokens[2], userTokens[3]));
	    }
	    return movies;
	}
	 
	public void getMovie(){
		int movieIndex = 0;
		System.out.print("Enter a Movie ID ");
		movieIndex = input.nextInt();
		
		System.out.println(movies.get(movieIndex-1));
	}
	 
	public void printMovies(){
		for (int i=0; i<movies.size();i++){
			System.out.println(movies.get(i));
		}
	}
	
	 public ArrayList<Rating> addRatings(){
		 File usersFile = new File("ratings5.dat");
		 // ArrayList<User> users = new ArrayList<User>();
	     In inUsers = new In(usersFile);
	     //each field is separated(delimited) by a '|'
	     String delims = "[|]";
	     while (!inUsers.isEmpty()) {
	         // get user and rating from data source
	         String userDetails = inUsers.readLine();

	         // parse user details string
	         String[] userTokens = userDetails.split(delims);
	            
	         ratings.add(new Rating(Integer.parseInt(userTokens[0]), Integer.parseInt(userTokens[1]), Integer.parseInt(userTokens[2])));
	     }
	     return ratings;
	 }
	 
	 public void printRatings(){
			for (int i=0; i<ratings.size();i++){
				System.out.println( " " + ratings.get(i));
			}
		}
	 
	 public void addRating(){
		 int userID = 0;
		 int movieID = 0;
		 int rating = 0;
		 for (int i=0; i<users.size();i++){
				System.out.println(users.get(i));
			}
		 System.out.print("Enter a User ID ");
		 userID = input.nextInt();
		 
		 for (int i=0; i<movies.size();i++){
				System.out.println(movies.get(i));
			}
		 System.out.print("Enter a Movie ID ");
		 movieID = input.nextInt();
		
		 System.out.print("Enter a Rating ");
		 rating = input.nextInt();
		 
		 ratings.add(new Rating(userID, movieID, rating));
	 }
	 
	 public List<Rating> getUserRatings(){
		 int userID = 0;
		 for (int i=0; i<users.size();i++){
				System.out.println(users.get(i));
			}
		 System.out.print("Enter a User ID ");
		 userID = input.nextInt();
		 
		 List<Rating> userRatings = new ArrayList<Rating>();
			for(Rating rating : ratings)
			{
				if(rating.getUserID() == userID)
					userRatings.add(rating);
			}
			System.out.println(userRatings.toString());
			return userRatings;
		}
	 
}