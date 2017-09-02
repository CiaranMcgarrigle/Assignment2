import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.princeton.cs.introcs.In;

/**
 * 
 * @author Ciaran McGarrigle
 *
 */
public class Main {
	//Setup of variables and ArrayLists to be used in the program
	private Scanner input;
	private ArrayList<User> users;
	private ArrayList<Book> books;
	private ArrayList<Rating> ratings;
	private Book book;
	private User user;
	private Rating rating;
	
	//Main method which runs the program
	public static void main(String [] args)
	{
		Main driver = new Main();
		User user = new User();
		Book book = new Book();
		Rating rating = new Rating();
	}
	
	/**
	 * Sets up the driver
	 * @throws Exception 
	 */
	public Main()
	{
		input = new Scanner(System.in);
		users = new ArrayList<User>();
		books = new ArrayList<Book>();
		ratings = new ArrayList<Rating>();
		user = new User();
		book = new Book();
		rating = new Rating();
		run();
	}
	
	/**
	 * Main menu using Switch Statement to allow for user choice input
	 * @return
	 */
	private int mainMenu()
	{
		int command = 0;
		System.out.println("Choose An Option");
		System.out.println("1) Import Users");
		System.out.println("2) Print User Details");
		System.out.println("3) Add User");
		System.out.println("4) Edit User");
		System.out.println("5) Delete User");
		System.out.println("6) Import Books");
		System.out.println("7) Print Books");
		System.out.println("8) Get Book");
		System.out.println("9) Import Ratings");
		System.out.println("10)Print Ratings");
		System.out.println("11)Add Rating");
		System.out.println("12)Get User Ratings");
		System.out.println("13)Get User Recommendations ");
		System.out.println("14)Get Add Book");
		System.out.println("15)Get Top 5 Books");
		System.out.println("16)Delete Book");
		System.out.println("0) Exit");
		command = input.nextInt();
		return command;
	}

	/**
	 * Method to allow for the choice to be made within the Switch Statement
	 */
	private void run()
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
				addBooks();
			break;
			case 7:
				printBooks();
			break;
			case 8:
				getBook();
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
			case 13:
				getUserRecommendations(choice);
			break;
			case 14:
				addBook();
			break;
			case 15:
				getTopFiveBooks();
			break;
			case 16:
				removeBook();
			break;
			default:
				System.out.println("Invalid option entered");
			break;
			}
			
			input.nextLine();
			choice = mainMenu();
		}
	}
	
	/**
	 * Method to return the ArrayList of users imported from the users file
	 * @return
	 */
	 public ArrayList<User> addUsers(){
		 File usersFile1 = new File("SpanishWords.txt");
		 //ArrayList<User> users = new ArrayList<User>();
	     In inUsers1 = new In(usersFile1);
	     //each field is separated(delimited) by a '|'
	     String delims = "[|]";
	     while (!inUsers1.isEmpty()) {
	         // get user and rating from data source
	         String userDetails = inUsers1.readLine();

	         // parse user details string
	         String[] userTokens = userDetails.split(delims);
	            
	         users.add(new User(Integer.parseInt(userTokens[0]), userTokens[1], userTokens[2], Integer.parseInt(userTokens[3]), userTokens[4], userTokens[5], Double.parseDouble(userTokens[6])));
	    }
	    return users;
	}
	
	 /**
	  * Method to use a for loop to print all users contained within the program
	  */
	public void printUsers(){
		for (int i=0; i<users.size();i++){
			if(users.get(i)!=null)
				System.out.println(users.get(i));
		}
	}
	
	/**
	 * Method to manually enter a user into the ArrayList of users
	 */
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
		
		users.add(new User(userID, firstName, lastName, age, gender, occupation, rating));
	}
	
	/**
	 * Method to edit the details of a user based on the index of that user.
	 */
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
	
	/**
	 * Method to remove a user from the ArrayList but not change other users ID's
	 */
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
		
	}
	/**
	 * Method to import and create the book ArrayList
	 * @return
	 */
	public ArrayList<Book> addBooks(){
		File usersFile = new File("books.dat");
		// ArrayList<User> users = new ArrayList<User>();
	    In inUsers = new In(usersFile);
	    //each field is separated(delimited) by a '|'
	    String delims = "[|]";
	    while (!inUsers.isEmpty()) {
	        // get user and rating from data source
	        String userDetails = inUsers.readLine();

            // parse user details string
	        String[] userTokens = userDetails.split(delims);
	            
	        books.add(new Book(Integer.parseInt(userTokens[0]), userTokens[1], userTokens[2], userTokens[3]));
	    }
	    return books;
	}
	
	/**
	 * Method to add a book to the ArrayList
	 */
	public void addBook(){
		input.nextLine();
		int bookID = books.size()+1;
		String title;
		String date;
		String author;
		System.out.print("Book Title: ");
		title = input.nextLine();
		System.out.print("Date Published: ");
		date = input.nextLine();
		System.out.print("Author: ");
		author = input.nextLine();
		
		books.add(new Book(bookID, title, date, author));
	}
	
	/**
	 * Method to remove a book from the book ArrayList
	 */
	public void removeBook()
	{
		int bookID = 0;
		
		for (int i=0;i<books.size();i++)
		{
			if(books.get(i)!=null)
			System.out.println("BookID: " + books.get(i).getBookID() + " Book Title: "+books.get(i).getName()+" Author: "+books.get(i).getAuthor());
		}
		System.out.println("Select a User");
		bookID = input.nextInt()-1;
		books.set(bookID, null);
		
		/*for (int i=0;i<ratings.size();i++)
			{
				if(userID == ratings.get(i).getUserID()&&!(ratings.get(i).getUserID() == null))
				ratings.set(i, null);
			} */
	}
	
	/**
	 * Method to return the details of a book from the ArrayList based on the bookID variable
	 */
	public void getBook(){
		int bookIndex = 0;
		System.out.print("Enter a Book ID ");
		bookIndex = input.nextInt();
		
		System.out.println(books.get(bookIndex-1));
	}
	
	/**
	 * Method to print the list of books contained within the ArrayList
	 */
	public void printBooks(){
		for (int i=0; i<books.size();i++){
			if(books.get(i)!=null)
				System.out.println(books.get(i));
		}
	}
	
	/**
	 * Method to create the ratings ArrayList from the rating file after import
	 * @return
	 */
	public ArrayList<Rating> addRatings(){
		File usersFile = new File("ratings.dat");
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
	
	/**
	 * Method to print everything contained within the ratings ArrayList
	 */
	public void printRatings(){
		for (int i=0; i<ratings.size();i++){
			System.out.println( " " + ratings.get(i));
		}
	}
	
	/**
	 * Method to add a Rating to a book from a user based on bookID and userID
	 */
	public void addRating(){
		int userID = 0;
		int bookID = 0;
		int rating = 0;
		for (int i=0; i<users.size();i++){
			System.out.println(users.get(i));
		}
		System.out.print("Enter a User ID ");
		userID = input.nextInt();
		 
		for (int i=0; i<books.size();i++){
			System.out.println(books.get(i));
		}
		System.out.print("Enter a Book ID ");
		bookID = input.nextInt();
		
		System.out.print("Enter a Rating ");
		rating = input.nextInt();
		 
		ratings.add(new Rating(userID, bookID, rating));
	}
	
	/**
	 * Method to get the books that a user has rated and then return the list of
	 * books rated by that user
	 * @return
	 */
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
	
	/**
	 * Method to get the recommendations of books for a certain user
	 * @param userID
	 * @return
	 */
	public List<Book> getUserRecommendations(int userID) {
		List<Book> userRecBooks = new ArrayList<Book>();
		System.out.print("User ID: ");
		userID = input.nextInt();

		for(Rating rating : ratings)
		{
			if(rating.getRating()>3)
			{
				if(rating.getUserID()!= userID)
				{
					if(!userRecBooks.contains(books.get(rating.getBookID()+1)))
					{
						userRecBooks.add(books.get(rating.getBookID()+1));
					}
				}
			}
		}
		System.out.println(userRecBooks.toString());
		return userRecBooks;
	}
	
	/**
	 * Method to return the top 5 books based on avergae ratings to the user.
	 */
	public void getTopFiveBooks(){
		int topFive = 0;
		for (int i=0; i<ratings.size();i++){
			if(ratings.get(i).getRating()>=3 && topFive<5){
				System.out.println(ratings.get(i));
				topFive++;
			}
		}
	}
}