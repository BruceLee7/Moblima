package entities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
        Represents the Schedule class
The schedule is different from any arrangement of the movies show in any cinema
@author  Li Luyun
@version 1.0
@since   2022-11-13
        */
public class Schedule {
    /**
     * Which cineplex it is in
     */
    private String cineplexName;
    /**
     * Which cinema it is in
     */
    private String cinemaName;
    /**
     * The id for the schedule
     */
    private Integer scheduleId;
    /**
     * The movie name for this schedule
     */
    private String movieName;
    /**
     * The datetime for this shedule
     */
    private DateTime datetime;
    /**
     * The remained seat for this schedule
     */
    private Integer remainSeat;
    /**
     * The column and row number of the seat
     */
    private Integer nRows, nCols;
    /**
     * To set the status of the seat
     */
    private ArrayList<ArrayList<Boolean>> seatStatus;

    /**
     * To initialize a schedule using the given information above

     */
    public Schedule(Integer scheduleId, String movieName, String cinemaName, String cineplexName, String datetime) throws FileNotFoundException{
        this.scheduleId = scheduleId;
        this.cinemaName = cinemaName;
        this.cineplexName = cineplexName;
        this.movieName = movieName;
        this.datetime = new DateTime();
        this.datetime.setFromString(datetime);
        createSeats();
    }

    /**
     * A function to get the id of the schedule

     */
    public Integer getId(){
        return scheduleId;
    }
    /**
     * A function to get the movie name of the schedule

     */
    public String getMovieName() {
        return movieName;
    }
    /**
     * A function to get the remained seats

     */
    public Integer getRemainSeat(){
        return remainSeat;
    }
    /**
     * A function to get the datetime of the movie

     */
    public String getDateTime(){
        return datetime.getDateFormatedString();
    }
    /**
     * A function to create the seats for the schedule

     */
    public void createSeats() throws FileNotFoundException{
        String filename = "assets/cineplexs/" + cineplexName + "/" + cinemaName + "/" + this.scheduleId + ".txt";
        Scanner sc = new Scanner(new FileInputStream(filename));
        ArrayList<Boolean> r;
        this.remainSeat = 0;
        this.seatStatus = new ArrayList<ArrayList<Boolean>>();
        while (sc.hasNext()){
            r = new ArrayList<Boolean>();
            for (String s: sc.nextLine().trim().split(" ")){
                if (s.equals("T")){
                    r.add(true);
                    this.remainSeat += 1;
                }
            }
            this.seatStatus.add(r);
        }
        this.nRows = this.seatStatus.size();
        this.nCols = this.seatStatus.get(0).size();
    }
    /**
     * A function to set the specific seat as occupied after a purcahse
     *
     */
    public void occupiedSeat(Integer row, Integer col){
        this.seatStatus.get(row).set(col, false);
        this.remainSeat -= 1;
    }
    /**
     * A function to show the whole seat status
     *
     */
    public void presentSeat(){
        String s = "";
        for (ArrayList<Boolean> row: this.seatStatus){
            // s += String.join("\t", row);
            for (Boolean status: row){
                s += (status) ? "[ ]" : "[X]";
                s += "\t";
            }
            s += "\n";
        }
        System.out.println(s);
    }

    /**
     * A function to format the schedule
     *
     */
    public String toString(){
        return String.format("%d\t%s\t%s\t%d", this.scheduleId, this.datetime.getDateFormatedString(), this.movieName, this.remainSeat);
    }
}
