package boundaries;

import java.io.*;
import java.util.Scanner;

import control.AccountManager;
import entities.Person;
/**
 Represents an Registration process for Staff.
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */


public class Register {
    public static void main(String root)  throws IOException{
        AccountManager accountManager = new AccountManager(root);
        Person p = new Person("Albert", 20, "albert0312@gmail.com", "84364048", "albert0312", "123456");
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter your username:" );
            p.setAccount(sc.nextLine().trim());
            System.out.println("Enter your password:" );
            p.setPassword(sc.nextLine().trim());
            System.out.println("Enter your name:" );
            p.setName(sc.nextLine().trim());
            System.out.println("Enter your Age:" );
            p.setAge(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter your email:" );
            p.setEmail(sc.nextLine().trim());
            System.out.println("Enter your phone number:" );
            p.setPhoneNumber(sc.nextLine().trim());
        }
        accountManager.createAccount(p);
    }
}
