package entities;
/**
 Represents the enumeration class
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */
public class enumClasses {
    
}

/**
 * A class to specify the exact time and day type (holiday or not)
 */
class DateTime{
    private int day;
    private int month;
    private int year;
    private int hour;
    private int minute;
    private boolean isHoliday;

    /**
     * A function to set default date time
     */
    public DateTime(){
        this.day=1;
        this.month=1;
        this.year=1;
        this.hour = 0;
        this.minute=59;
        this.isHoliday = false;
    }
    /**
     * A function to set default date time
     */
    public DateTime(int day, int month, int year, int hour, int minute){
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.isHoliday = false;
    }
    /**
     * A function to set default date time and holiday type
     */
    public DateTime(int day, int month, int year, int hour, int minute, boolean isHoliday){
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.minute = minute;
        this.isHoliday = isHoliday;
    }

    /**
     * A function to check if the given day is a holiday

     */
    public boolean isHoliday(){
        return this.isHoliday;
    }

    /**
     * A function to set a date time from a given string

     */
    public String getDateFormatedString(){
        return String.format("%d-%d-%d %d:%d %s",
         this.day, this.month, this.year, this.hour, this.minute,
         this.isHoliday? "H": "N");
    }

    /**
     * A function to set time from a given string

     */
    public void setFromString(String dateString){
        String[] d = dateString.split(" ");
        String[] date = d[0].split("-");
        String[] time = d[1].split(":");
        this.day = Integer.parseInt(date[0]);
        this.month = Integer.parseInt(date[1]);
        this.year = Integer.parseInt(date[2]);

        this.hour = Integer.parseInt(time[0]);
        this.minute = Integer.parseInt(time[1]);
        if (d[2].equals("H"))
                this.isHoliday = true;
    }
}

/**
 * An enum class of different age rating for movies:
 * We have G, PG13, PG16, NC16,M18,R21
 */
enum AgeRating {
    G("G"),
    PG13("PG13"),
    PG16("PG16"),
    NC16("NC16"),
    M18("M18"),
    R21("R21");
    /**
     * parameter for a special age rating type
     */
    private final String p;

    /**
     * A function to set the age rating for a movie

     */
    private AgeRating(String p){
        this.p =p;
    }
    public String toString(){
        return p;
    }
}

/**
 * An enum class for the definition of different movie status:
 * We have "Coming soon", "Preview", "Now Showing", "End of Showing"
 */
enum Status {
    ComingSoon("ComingSoon"),
    Preview("Preview"),
    NowShowing("NowShowing"),
    EndOfShowing("EndOfShowing");
    /**
     * A name for the definition for special condition of status
     */
    private final String status;

    /**
     * A function to set status for a movie

     */
    private Status(String status){
        this.status = status;
    }

    public String toString(){
        return status;
    }
}

/**
 * A enum class for the cinema type:
 * We have"Standard, First Class and Platinum"
 */
enum CinemaType{
    StandardCinema,
    FirstClass,
    PlatinumMovieSuite,
}