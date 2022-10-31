package entities;
public class Reviews {
    private String userName;
    private String description;
    private Float rating;
    private String movieName;

    public Reviews(String username String description, Float rating, String movieName) {
        this.userName = username;
        this.description = description;
        this.rating = rating;
        this.movieName = movieName;
    }

    public void setUserName(String username){
        this.userName = username;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setRating(Float rating){
        this.rating = rating;
    }

    public void setMovieName(String movieName){
        this.movieName = movieName;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getDescription() {
        return this.description;
    }

    public Float getRating() {
        return this.rating;
    }

    public String getMovieName(){
        return this.movieName;
    }
}
