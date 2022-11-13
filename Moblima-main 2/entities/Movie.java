package entities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

// import control.ReviewsManager;

/**
 Represents the Movie class
 *A movie should contain below information
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */
public class Movie {

    /**
     * The full name for the movie
     */
    private String name;
    /**
     * The showing status of a movie
     */
    private Status showingStatus;
    /**
     * The length of a movie
     */
    private Float duration;
    // private Genres movieType;
    /**
     * The sale status for a movie
     */
    private Integer sales;
    /**
     * The brief synopsis for a movie
     */
    private String sypnosis;
    /**
     * The full name of the movie director
     */
    private String director;
    /**
     * The detailed casts of the movie
     */
    private ArrayList<String> casts;
    /**
     * The movie-goer reviews of the movie
     */
    private ArrayList<Review> reviews;

    public Movie(){}

    /**
     * To set the information for a movie
     * The above parameters should be provided

     */
    public Movie(String name, String showStatus, Float duration, Integer sales, String director) throws IOException{
        this.name = name;
        this.showingStatus = Status.valueOf(showStatus);
        this.duration = duration;
        this.sales = sales;
        this.director = director;
        this.sypnosis = getMovieSypnosis(name);
        this.casts = getMovieCasts(name);
        // this.reviews = getRevewManager(name);
    }

    /**
     * A function to get the name of the movie

     */
    public String getName(){
        return this.name;
    }

    /**
     * A function to get the status of the movie

     */
    public Status getStatus(){
        return showingStatus;
    }

    /**
     * The function to get the duration of the movie

     */
    public Float getDuration(){
        return duration;
    }

    /**
     * The function to get the sales data of a movie

     */
    public Integer getSales(){
        return sales;
    }

    /**
     * A function to check if the movie is showing

     */
    public boolean isShowing(){
        if (showingStatus == Status.Preview || showingStatus == Status.NowShowing)
            return true;
        return false;
    }

    /**
     * A function to retrieve the synopsis of a movie given the movie name

     */
    public String getMovieSypnosis(String movieName) throws IOException {
        String filename = String.format("assets/movies/sypnosis/%s.txt", movieName);
        Scanner s = new Scanner(new FileInputStream(filename));
        String syp = s.nextLine().trim();
        s.close();
        return syp;
    }

    /**
     * A function to get the information about the movie casts

     */
    public ArrayList<String> getMovieCasts(String movieName) throws IOException {
        ArrayList<String> cast = new ArrayList<String>();
        String filename = String.format("assets/movies/casters/%s.txt", movieName);
        Scanner s = new Scanner(new FileInputStream(filename));
        while (s.hasNext()){
            cast.add(s.nextLine().trim());
        }
        return cast;
    }

    /**
     * A function to the review manager information given the movie name

     */
    public ArrayList<Review> getReviewManager(String movieName) throws IOException {
        String filename = String.format("assets/movies/review/%s.txt", movieName);
        Scanner sc = new Scanner(new FileInputStream(filename));
        sc.nextLine();
        String nextLine;
        ArrayList<String> newEle = new ArrayList<String>();
        while (sc.hasNext()) {
            nextLine = sc.nextLine();
            for (String e: nextLine.trim().split(";", 10)){
                newEle.add(e);
            }
            // Review r = new Review(newEle.get(0), newEle.get(1), newEle.get(2), )
            // this.reviews.add(newEle);
        }
        sc.close();
        return null;
    }

    /**
     * A function to format the information about a movie


     */
    public String rprStringToUser() throws IOException{
        return String.format("Movie : %s\nStatus :%s\nSYPNOSIS : %s\nDirector: %s\nCast: %s, %s,..\nRating: %f",
                             name, showingStatus, sypnosis, director, casts.get(0), casts.get(1), getRating());
    }

    /**
     * A function to get the rating of a movie.

     */
    public Float getRating() throws IOException{
        return (float) 0.0;
    }
}
