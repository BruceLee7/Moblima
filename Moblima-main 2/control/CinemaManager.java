package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import entities.Cinema;
/**
 Represents an interface for Cinema Manager
 A manager is in charge of all services.
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */
public class CinemaManager extends DBManager<Cinema> {
    /**
     * A function to initialize a cinema
     *
     */
    public CinemaManager() throws IOException{
        this.root = "assets/cineplexs/names.txt";
        this.columns = new ArrayList<String>(Arrays.asList("id", "cineplexName", "cinemaName", "totalSeat"));
        this.data = new ArrayList<Cinema>();

        super.read(this.root);
    }

    /**
     * A function to show movie status inside a cinema
     *
     */
    public void showCinema(String movieName){
        System.out.println("Id\tCinema Name");
        int id = 0;
        for (Cinema c: this.data){
            if (c.isShowing(movieName))
                System.out.printf("%d\t%s\n", id, c.getName());
            id++;
        }
        return;
    }

    /**
     * A function to retrieve a cinema's information by its id
     *
     */
    public Cinema getCinemaById(Integer id){
        return this.data.get(id);
    }


    /**
     * A function to construct a new cinema using given information
     */
    public Cinema constructFromArr(ArrayList<String> ele) throws NumberFormatException, IOException {
        Cinema c = new Cinema(
            ele.get(1),
            ele.get(2),
            Integer.parseInt(ele.get(3))
        );
        return c;
    }

    @Override
    /**
     * A function to decode from the original cinema
     */
    public ArrayList<String> decodeFromObj(Cinema obj) {
        // TODO Auto-generated method stub
        return null;
    }
}
