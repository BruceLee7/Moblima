package control;
import java.util.ArrayList;
import java.util.Arrays;

import entities.*;

import java.io.*;
/**
 Represents an app for Account Manager.
 A manager can have multiple functions here.
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */
public class AccountManager extends DBManager<Person> {

    /**
     * The function for initializing a manager.
     *
     */
    public AccountManager(String root) throws IOException {
        this.root = root;
        // this.columns = new ArrayList<String>();
        this.data = new ArrayList<Person>();
        this.columns = new ArrayList<String>(Arrays.asList("id", "account", "password", "name", "age", "email", "phoneNumber"));
        this.read(root);
    }

    /**
     * A function to read data

     */
    public void read(String root) throws IOException {
        super.read(root);
    }

    /**
     * A function to create an account

     */
    public void createAccount(Person p) throws IOException{
        int id = this.data.size();
        String line = String.format("%d;%s;%s;%s;%d;%s;%s",
                                    id + 1, p.getAccount(), p.getPassword(),
                                    p.getName(), p.getAge(), p.getEmail(), p.getPhoneNumber());
        super.write(line, true);
    }

    /**
     * A function to get personal information from an account

     */
    public Person getPersonFromAccount(String account) {
        for (Person person : this.data){
            if (account.equals(person.getAccount())){
                return person;
            }
        }
        return null;
    }


    /**
     * A function to construct an account
     */
    public Person constructFromArr(ArrayList<String> ele) throws NumberFormatException, IOException {
        System.out.println("Retrieving peronal information.");
        Person m = new Person(
            ele.get(3),
            Integer.parseInt(ele.get(4)),
            ele.get(5),
            ele.get(6),
            ele.get(1),
            ele.get(2)
        );
        return m;
    }


    /**
     * A method inherits from the abstract class
     */
    public ArrayList<String> decodeFromObj(Person obj) {
        // TODO Auto-generated method stub
        return null;
    }
}