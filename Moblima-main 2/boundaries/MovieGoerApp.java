package boundaries;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import control.*;
import entities.*;

/**
 Represents an interface for User.
A user can book tickets here.
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */
public class MovieGoerApp extends App {

    /**
     * The manager in charge of all tickets
     */
    private TicketManager ticketManager;
    /**
     * The manager in charge of all movies
     */
    private MoviesManager movieManager;
    /**
     * The manger in charge of all cinemas
     */
    private CinemaManager cinemaManager;
    /**
     * The users
     */
    private Person user;

    public MovieGoerApp(){

    }

    /**
     * The functions for the movie-goers
     *
     */
    public MovieGoerApp(Person user, CinemaManager c, MoviesManager m) throws IOException, ParseException{

        this.user = user;
        this.ticketManager = new TicketManager(user.getAccount());
        this.movieManager = m;
        this.cinemaManager = c;
        // runningSession();

    }


    /**
     * The running session and interface for the movie-goer
     */

    public void runningSession() throws IOException, ParseException {

        System.out.println("Welcome to MOBLIMA Booking Center");
        System.out.println("================================================================");
        try (Scanner sc = new Scanner(System.in)) {
            int choice = 1;
            while (choice != 0){
                System.out.println("1. Search for movies.");
                System.out.println("2. See top reviewed movies");
                System.out.println("3. Check seat availability");
                System.out.println("4. Book a tickets");
                System.out.println("5. View booking history");
                System.out.println("0. Exit");
                choice = sc.nextInt();
                sc.nextLine();
                switch(choice){
                    case 1: 
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        bookTicket();
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
    }
    /**
     * A function which could be used to search movies
     */
    public void searchMovie(){


    }

    /**
     * A function which checks the booking history
     *
     */
    public ArrayList<ArrayList<String>> getHistory() {
        return null;
    }

    /**
     * A function which can help user book tickets
     *
     */
    public boolean bookTicket() throws IOException{
        // Write tickets information to database
            Scanner sc = new Scanner(System.in);
            
            System.out.println("These movies are currently showing.");
            this.movieManager.showMovies();
            System.out.println("Please choose one by enter movie Id:");
            Integer movieId = sc.nextInt();
            sc.nextLine();
            Movie movie = this.movieManager.getMovieById(movieId);
            
            System.out.printf("These cinema are currently showing %s\n", movie.getName());
            this.cinemaManager.showCinema(movie.getName());
            System.out.println("Please choose one by enter cinema Id:");
            Integer cinemaId = sc.nextInt();
            Cinema c = this.cinemaManager.getCinemaById(cinemaId);
            sc.nextLine();
            
            System.out.printf("Schedule for %s in %s\n", movie.getName(), c.getName());
            c.printMovieSchedule(movie.getName());
            System.out.println("Please choose one by enter schedule id:");
            Integer scheduleId = sc.nextInt();
            sc.nextLine();
            Schedule sch = c.getScheduleById(scheduleId);

            sch.presentSeat();
            System.out.println("Please choose a seat by enter its row and colum. [X] are occupied seats");
            Integer row = sc.nextInt(), col = sc.nextInt();
            sc.nextLine();

            System.out.println("Creating ticket...");
            Ticket t = new Ticket(user.getName(), movie.getName(), c.getName(), sch.getDateTime(), user.getAgeGroup());
            System.out.println("Ticket created successfully. Here is your receipt:");
            
            String receipt = t.getReceipt();
            System.out.println(receipt);
            System.out.println("Please enter \"confirm\" to pay");
            if (sc.nextLine().trim().equals("confirm")){
                ticketManager.addTicket(t.toString(), true);
                c.updateSchedule(scheduleId);
                sch.occupiedSeat(row, col);
            }
        
        return false;
    }

    /**
     * A function which help user cancel tickets
     *
     */
    public boolean cancelTicket(String ticketId) {
        //TODO: optional, to be implemented
        return false;
    }


}