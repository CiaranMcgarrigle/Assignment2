package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import models.Movie;
import models.Rating;
import models.User;
import edu.princeton.cs.introcs.In;

public class Load {

	public List<User> loadUsers(String url) throws Exception
	{
		File usersFile = new File(url);
		List<User> users = new ArrayList<User>();
        In inUsers = new In(usersFile);
          //each field is separated(delimited) by a '|'
        String delims = "[|]";
        while (!inUsers.isEmpty()) {
            // get user and rating from data source
            String userDetails = inUsers.readLine();

            // parse user details string
            String[] userTokens = userDetails.split(delims);

            // output user data to console.
            if (userTokens.length == 7) {
                User newUser = new User(Integer.parseInt(userTokens[0]),userTokens[1],userTokens[2],Integer.parseInt(userTokens[3]),userTokens[4],userTokens[5]);
                users.add(newUser);
            }else
            {
                throw new Exception("Invalid member length: "+userTokens.length);
            }
        }
        return users;
	}

	public List<Movie> loadMovies(String url) throws Exception 
	{
		File moviesFile = new File(url);
		List<Movie> movies = new ArrayList<Movie>();
        In inMovies = new In(moviesFile);
          //each field is separated(delimited) by a '|'
        String delims = "[|]";
        while (!inMovies.isEmpty()) {
            // get user and rating from data source
            String movieDetails = inMovies.readLine();

            // parse user details string
            String[] movieTokens = movieDetails.split(delims);

            // output user data to console.
            if (movieTokens.length == 23) {
            	
            	List<String> thisMovieGenres = new ArrayList<String>();
            	
                Movie newMovie = new Movie(Integer.parseInt(movieTokens[0]), movieTokens[1],movieTokens[2], movieTokens[3]);
                movies.add(newMovie);
            }else
            {
                throw new Exception("Invalid member length: " + movieTokens.length);
            }
        }
        return movies;
		
	}

	public List<Rating> loadRatings(String url) throws Exception{
		File ratingsFile = new File(url);
		List<Rating> ratings = new ArrayList<Rating>();
        In inRatings = new In(ratingsFile);
          //each field is separated(delimited) by a '|'
        String delims = "[|]";
        while (!inRatings.isEmpty()) {
            // get user and rating from data source
            String ratingsDetails = inRatings.readLine();

            // parse user details string
            String[] ratingsTokens = ratingsDetails.split(delims);

            // output user data to console.
            if (ratingsTokens.length == 4) {
                Rating newUser = new Rating(Integer.parseInt(ratingsTokens[0]),Integer.parseInt(ratingsTokens[1]),Integer.parseInt(ratingsTokens[2]));
                ratings.add(newUser);
            }else
            {
                throw new Exception("Invalid member length: "+ratingsTokens.length);
            }
        }
        return ratings;
	}
}

