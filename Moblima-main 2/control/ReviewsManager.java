package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import entities.Review;
/**
 Represents the interface for reviews manager
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */

public class ReviewsManager extends DBManager<Review> {
    /**
     * The basic settings for reviews manager
     */
    public ReviewsManager(){
        this.root = "";
        this.columns = new ArrayList<String>(
            Arrays.asList("id", "user", "title", "description", "rating")
        );
    }
    /**
     * The reviews for root
     */
    public ReviewsManager(String root){

        this.root = root;
        this.columns = new ArrayList<String>(
            Arrays.asList("id", "user", "title", "description", "rating")
        );
        // this.data = new ArrayList<ArrayList<String>>();
    }

    /**
     * The function helps to read the reviews

     */
    public void read() throws IOException{
        super.read(this.root);
    }

    /**
     * The function helps to get the rating

     */
    public Float getRating() throws IOException{
        // Get overall rating from 5 best rated reviews.
        return (float) 0.0;
    }

    /**
     * To implement the function inherits from the abstract class

     */
    @Override
    public Review constructFromArr(ArrayList<String> ele) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        return null;
    }


    /**
     * To implement the function inherits from the abstract class
     */
    public ArrayList<String> decodeFromObj(Review obj) {
        // TODO Auto-generated method stub
        return null;
    }

}