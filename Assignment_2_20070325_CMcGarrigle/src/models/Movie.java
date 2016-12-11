package models;

public class Movie {
	private int movieID;
	private String name;
	private String year;
	private String url;
	private String genre;
	
	public Movie(int movieID, String name, String year, String url)
	{
		this.movieID = movieID;
		this.name = name;
		this.year = year;
		this.url = url;
	}
	
	public Movie()
	{
	}
	
	public int getMovieID() {
		return movieID;
	}

	public void setMovieID(int movieID) {
		this.movieID = movieID;
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
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String toString(){
		return "Movie ID: " + movieID + " Movie Name: " + name + " Date Released: " + year + " URL: " + url;
	}
}
