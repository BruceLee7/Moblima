package entities;

/**
 Represents the Person class
 @author  Li Luyun
 @version 1.0
 @since   2022-11-13
 */
public class Person {
    /**
     * The parameter of the full name of a person
     */
    private String name;
    /**
     * The age of a person
     */
    private int age;
    /**
     * The person's contact information-email
     */
    private String email;
    /**
     * The person's contact information- phoneNumber
     */
    private String phoneNumber;
    /**
     * The person's account number
     */
    private String account;
    /**
     * The person's password
     */
    private String password;

    /**
     * The default initialization of a person
     */
    public Person(){
        // when no information is available
        // treat as anonimous guess
        this.name = "Anonymous";
        this.age = 6; // Set age as kid to restrict booking some movies as guess
        this.email = "";
        this.phoneNumber = "";
        this.account = "guess";
        this.password = "admin123456";
    }
/**
 * The initialization of a person given the parameters above
 */
    public Person(String name, int age, String email, String phoneNumber, String account, String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.account = account;
        this.password = password;
    }

    /**
     * A function to get the name of a person

     */
    public String getName(){
        return this.name;
    }

    /**
     * A function to get the age of a person

     */
    public int getAge(){
        return this.age;
    }

    /**
     * A function to decide a person's age group
     * We have: PG13, PG16, M18, and R21

     */
    public String getAgeGroup() {
        if (age <= 13)
            return "PG13";
        else if (age <= 16)
            return "PG16";
        else if (age <= 18)
            return "M18";
        return "R21";
    }

    /**
     * A function to get the email of a person

     */
    public String getEmail(){
        return this.email;
    }

    /**
     * A function to get the phone number of a person

     */
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    /**
     * A function to get the account number of a person

     */
    public String getAccount(){
        return this.account;
    }

    /**
     * A function to get the password of a person

     */
    public String getPassword(){
        return this.password;
    }

    // TODO: Implement getters, setters methods

    /**
     * A function to set name for a person

     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * A function to set the age of a person

     */
    public void setAge(int age){
        this.age = age;
    }

    /**
     * A function to set the email for a person

     */
    public void setEmail(String email){
        this.email = email;
    }

    /**
     * A function to the phone number for a person

     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    /**
     * A function to set the account number for a person

     */
    public void setAccount(String account){
        this.account = account;
    }

    /**
     * A function to set the password for a person

     */
    public void setPassword(String password){
        this.password = password;
    }
}
