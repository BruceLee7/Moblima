package boundaries;


import java.io.IOException;
import java.text.ParseException;

import entities.Person;
/**
 Represents the main app and interface
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */
public abstract class App {
    /**
     * The information of the user
     */
    public Person user;

    /**
     * To create a new user
     */
    public App() {
        this.user = new Person();
    }
    public App(Person user){
        this.user = user;
    }

    /**
     * An abstract class to run the session
     * IOException
     * ParseException
     */
    public abstract void runningSession() throws IOException, ParseException;
}