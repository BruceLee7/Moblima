package entities;
/**
 Represents the Schedule class
 The schedule is different from any arrangement of the movies show in any cinema
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */
public class Ticket {
    /**
     * The age rating for a ticket
     */
    private AgeRating ageGroup;
    /**
     * The datetime for a ticket
     */
    private DateTime date;
    /**
     * The movie name of the ticket
     */
    private String movieName;
    /**
     * The user name of the ticket
     */
    private String userName;
    /**
     * The cinema of the ticket
     */
    private String cinema;
    /**
     * The price of the ticket
     */
    private Float price;
    private final static Float basePrice = (float)100;


    /**
     * A function to initialize a ticket using the given parameters above

     */
    public Ticket(String userName, String movieName, String cinema, String datetime, String ageGroup) {
        this.userName = userName;
        this.date = new DateTime();
        this.date.setFromString(datetime);
        this.movieName = movieName;
        this.cinema = cinema;
        this.ageGroup = AgeRating.valueOf(ageGroup);
        this.price = computePrice();
    }

    /**
     * A function returns the price of a ticket

     */

    public Float getPrice() { return price; }

    /**
     * A function to compute the price of the ticket

     */
    public Float computePrice() {
        Float price = basePrice;
        if (ageGroup == AgeRating.M18)
            price = price * (float)0.8;
        if (date.isHoliday())
            price = price * 2;
        return price;
    }

    /**
     * A function returns the receipt of the purchase

     */
    public String getReceipt(){
        return String.format("Movie: %s\nCinema: %s\nShowing Time: %s", movieName, cinema, date.getDateFormatedString()); //)
    }

    /**
     * A function which formats the ticket

     */
    public String toString(){
        // time|email|movie|cinema|ageGroup|price|paid
        return String.format("%s;%s;%s;%s;%s", this.date.getDateFormatedString(), this.userName, this.movieName, this.cinema, this.ageGroup.toString());
    }
}
