package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import entities.Movie;
/**
 Represents the interface for movie manager
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */
public class MoviesManager extends DBManager<Movie> {
    /**
     * The basic function to set movie attributes
     */
    public MoviesManager() throws IOException {
        this.root = "assets/movies/names.txt";
        this.data = new ArrayList<Movie>();
        this.columns = new ArrayList<String>(Arrays.asList("id","movieName","status","duration","totalSale","director"));
        // System.out.println("Retrieving movies...");
        super.read(this.root);
        
    }

    /**
     * A function to find movie synopsis

     */
    public String getMovieSypnosis(String movieName) throws IOException {
        String filename = String.format("assets/movies/sypnosis/%s.txt", movieName);
        Scanner s = new Scanner(new FileInputStream(filename));
        String syp = s.nextLine().trim();
        s.close();
        return syp;
    }

    /**
     * A function to find movie caster
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

    // public ReviewsManager getRevewManager(String movieName) throws IOException {
    //     return new ReviewsManager(String.format("assets/movies/revew/%s.txt", movieName));
    // }

    /**
     * A function to find movie information

     */
    public Movie getMovieById(Integer id){
        return this.data.get(id - 1);
    }

    /**
     * A function to show all movies

     */
    public void showMovies() throws IOException{
        int count = 1;
        for (Movie m : this.data){
            if (m.isShowing())
                System.out.printf("%d. %s\n", count, m.rprStringToUser());
            count ++;
        }
    }


    /**
     * To construct from given information
     */
    public Movie constructFromArr(ArrayList<String> ele) throws NumberFormatException, IOException{
        Movie m = new Movie(
            ele.get(1),
            ele.get(2),
            Float.parseFloat(ele.get(3)),
            Integer.parseInt(ele.get(4)),
            ele.get(5)
        );
        return m;
    }

    /**
     * A function that inherits from the abstract class
     */
    @Override
    public ArrayList<String> decodeFromObj(Movie obj) {
        // TODO Auto-generated method stub
        return null;
    }
}
