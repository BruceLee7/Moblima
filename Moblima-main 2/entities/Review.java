package entities;
/**
 Represents the Review class
 A review should contain:User name, tittle, description, rating and movie name.
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */
public class Review {
    /**
     * Who creates this review?
     */
    private String userName;
    /**
     * The title for the review.
     */
    private String tittle;
    /**
     * The content of the review.
     */
    private String description;
    /**
     * The rating for the review
     */
    private Float rating;
    /**
     * The movie name
     */
    private String movieName;

    /**
     * The initialization of the review should contain the below information

     */

    public Review(String username, String tittle, String description, Float rating, String movieName) {
        this.userName = username;
        this.tittle = tittle;
        this.description = description;
        this.rating = rating;
        this.movieName = movieName;
    }

    /**
     * A function to set the user name

     */

    public void setUserName(String username){
        this.userName = username;
    }
    /**
     * A function to set the tittle

     */
    public void setTittle(String tittle){
        this.tittle = tittle;
    }
    /**
     * A function to create the content

     */
    public void setDescription(String description){
        this.description = description;
    }
    /**
     * A function to set the rating for the movie

     */
    public void setRating(Float rating){
        this.rating = rating;
    }
    /**
     * A function to set the movie name

     */
    public void setMovieName(String movieName){
        this.movieName = movieName;
    }
    /**
     * A function to get the user name

     */
    public String getUserName(){
        return this.userName;
    }
    /**
     * A function to get the tittle

     */
    public String getTitle(){
        return this.tittle;
    }
    /**
     * A function to get the description

     */
    public String getDescription() {
        return this.description;
    }
    /**
     * A function get the rating of the review

     */
    public Float getRating() {
        return this.rating;
    }
    /**
     * A function to get the movie name
  
     */
    public String getMovieName(){
        return this.movieName;
    }
}
