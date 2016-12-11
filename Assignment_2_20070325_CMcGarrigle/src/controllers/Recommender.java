package controllers;
import java.util.List;

import models.Movie;
import models.Rating;
import models.User;

public interface Recommender 
{
	void addUser(String firstName, String lastName,int age, String gender, String occupation);
	void removeUser(int userID);
	void addMovie(String title, String year, String url);
	void addRating(int userID, int movieID, int rating);
	List<Movie> getMovies();
	Movie getMovie(int movieID);
	List<Rating> getUserRatings(int userID);
	List<Movie> getUserRecommendations(int userID);
	List<Movie> getTopTenMovies();
	List<User> getUsers();
	void load()throws Exception;
	void write()throws Exception;
}
