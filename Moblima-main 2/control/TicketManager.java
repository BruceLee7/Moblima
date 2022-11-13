package control;
import java.util.ArrayList;

import entities.Ticket;

// import java.util.*;
import java.io.*;
/**
 Represents the interface for ticket manager
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */

public class TicketManager extends DBManager<Ticket> {
    /**
     * Account information for the TicketManager: Email address
     */
    private String email;
    /**
     * The counter for total tickets sold
     */
    private static Integer totalTicketCount = 0;

    /**
     * The function to register a new ticket manager
     */
    public TicketManager() {
        this.email = "admin";
        this.root = "assets/tickets/" + this.email + ".txt";
        // this.data = new ArrayList<ArrayList<String>>();
    }

    /**
     * A function to initialize a ticket manager information
     */
    public TicketManager(String email) throws IOException{
        this.email = email;
        this.root = "assets/tickets/" + this.email + ".txt";
        this.data = new ArrayList<Ticket>();
        super.read(this.root);
    }

    // public void readDataFromUser() throws IOException{
    //     if (this.email == "admin")
    //         super.read(this.root);
    //     else {
    //         read();
    //     }
    // }

    /**
     * A function for the manger to add a ticket
     * Add one to the ticketcount after using

     */
    public void addTicket(String line, Boolean append) throws IOException{
        super.write(String.format("%d;%s",totalTicketCount,line), append);
        totalTicketCount += 1;
    }


    /**
     * To construct a ticket from given information
     */
    public Ticket constructFromArr(ArrayList<String> ele) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        Ticket t = new Ticket(this.email, 
                            ele.get(3), 
                            ele.get(4),
                            ele.get(1), 
                            ele.get(5));
        return t;
    }


    /**
     * To implement the method inherited from the abstract class
     */
    public ArrayList<String> decodeFromObj(Ticket obj) {
        // TODO Auto-generated method stub
        return null;
    }
}
