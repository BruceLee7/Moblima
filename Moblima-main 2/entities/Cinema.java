package entities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *Represents the class of the Cinema
 *A cinema should contain detail information about itself
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */
public class Cinema {
    /**
     * Different types of cinemas are defined here
     */
    private CinemaType type;
    /**
     * The name of the cineplex it belongs to
     */
    private String cineplexName;
    /**
     * The name of itself
     */
    private String cinemaName;
    /**
     * The number of the total seats it has
     */
    private Integer totalSeat;
    // private Integer nRows, nCols;
    /**
     * The schedules of this cinema
     */
    private ArrayList<Schedule> schedules;
    /**
     * The map of the cinema. As well as seating arrangements
     */
    private Map<String, Boolean> map;

    /**
     * To construct a cinema. We should have all the parameters listed above

     */
    public Cinema(String cineplexName, String cinemaName, Integer totalSeat) throws IOException{
        this.cineplexName = cineplexName;
        this.cinemaName = cinemaName;
        this.type = CinemaType.valueOf(cinemaName.split("_")[0]);
        this.totalSeat = totalSeat;
        this.map = new HashMap<String, Boolean>();
        this.schedules = new ArrayList<Schedule>();
        retrieveSchedule(cineplexName, cinemaName);
    }

    /**
     * To access the schedule of a cinema
     * The name of cineplex name and cinema name should be provided

     */
    public void retrieveSchedule(String cineplexName, String cinemaName) throws IOException {
        String filename = "assets/cineplexs/" + cineplexName + "/" + cinemaName + ".txt";
        Scanner sc = new Scanner(new FileInputStream(filename));
        sc.nextLine();
        ArrayList<String> ele;
        while(sc.hasNext()) {
            ele = new ArrayList<String>();
            for (String s: sc.nextLine().trim().split(";"))
                ele.add(s);

            Schedule sch = new Schedule(
                Integer.parseInt(ele.get(0)),
                ele.get(2),
                this.cinemaName,
                this.cineplexName,
                ele.get(1)
            );
            this.schedules.add(sch);
            // System.out.println(ele);
            this.map.put(sch.getMovieName(), true);
        }
    }

    /**
     * A function to get cinema name

     */
    public String getName(){
        return cinemaName;
    }

    /**
     * a function to get a cineplex name

     */
    public String getCineplex(){
        return cineplexName;
    }

    /**
     * a function to get a cinema type
     * we have three different types: First Class, Platinum and Standard

     */
    public CinemaType getType(){
        return type;
    }

    /**
     * A function to get all the total seats

     */
    public Integer getTotalSeat(){
        return totalSeat;
    }

    /**
     * A function to print out schedules of a given cinema
     */
    public void printSchedule(){
        for(Schedule schedule : schedules)
            System.out.println(schedule.toString());
    }

    /**
     * A function to print out movie schedules in all cinema given a movie name

     */
    public void printMovieSchedule(String movieName){
        int count = 0;
        System.out.println("Schedule Id\tTime\tMovie\tSeat Available");
        for (Schedule schedule : schedules){
            if (schedule.getMovieName().equals(movieName) && schedule.getRemainSeat() != 0){
                System.out.println(schedule.toString());
                count ++;
            }
        }
        if (count == 0)
            System.out.println("Sorry there are no more available seat in this time slot.");
        return;
    }

    /**
     * A function to get schedules of a cinema given its id

     */
    public Schedule getScheduleById(Integer id){
        for (Schedule sch : this.schedules){
            if (sch.getId() == id)
                return sch;
        }
        return null;
    }

    /**
     * get date time given the id of a cinema

     */
    public String getDateTime(Integer id){
        return this.schedules.get(id).getDateTime();
    }

    /**
     * A function to check if a given movie is now showing
     * Need movieName provided

     */
    public boolean isShowing(String movieName){
        return this.map.getOrDefault(movieName, false);
    }

    /**
     * to update the schedule of a cinema
     */
    public void updateSchedule(Integer id){

    }
}
