
package main;


public class Accounts {
    
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String username;
    private final String password;

    public Accounts(int id, String firstName, String lastName, String email, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public void view() {
        System.out.println("ID: " + id);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Email: " + email);
        System.out.println("Username: " + username);
    }
}

