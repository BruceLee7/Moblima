package boundaries;
// package src;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import control.AccountManager;
import control.CinemaManager;
import control.MoviesManager;
import entities.Person;
/**
 Represents a log-in function for all User.
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */
public class Loger {
    /**
     * The overall manager- account manager
     */
    private static AccountManager accountManager;

    public static Person main(String root, String use_case) throws IOException, ParseException  {
        accountManager = new AccountManager("assets/clients.txt");
        // moviesManager = m;
        // cinemaManager = c;
        Person p = login(use_case);
        return p;
    }

    /**
     * The login function returns the person information
     *
     *
     */
    public static Person login(String use_case) throws IOException, ParseException{
           Scanner sc = new Scanner(System.in);
            String account, password;
            Person p;
            int choice = 1;
            System.out.println("Please login first!");
            System.out.println("1. Login with existed account.");
            System.out.println("2. Exit");
            while (choice != 2){
                choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1){
                    System.out.println("Enter your username:");
                    account = sc.nextLine().trim();
                    p = accountManager.getPersonFromAccount(account);

                    if (p == null) {
                        System.out.println("The account does not exists. Please try again.");
                        System.out.println("You might want to re-enter (press 1) or exit (press 2).");
                        continue;
                    }
                    System.out.println("Enter your password:");
                    password = sc.nextLine().trim();
                    if (password.equals(p.getPassword())){
                        return p;
                    }
                }
                else break;
            }
            return null;
        }
}
