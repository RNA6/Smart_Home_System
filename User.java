/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_home_system;
import java.util.*;

abstract public class User {
    private String username;
    private String user_id;
    private String password;
    private String email;
    private String date_of_birth;
    private boolean logged_in;
    private ArrayList<String> notifications;

    public User(String username , String user_id , String password , String email , String date_of_birth){
        this.username = username;
        this.user_id = user_id;
        this.password = password;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.logged_in = false;
        this.notifications = new ArrayList<>();
    }


    public String get_username() {
        return username;
    }


    public String get_user_id() {
        return user_id;
    }


    public String get_password() {
        return password;
    }


     public String get_email() {
        return email;
    }


     public String get_date_of_birth() {
        return date_of_birth;
    }


    public void set_username(String username) {
        this.username = username;
    }


    public void set_user_id(String user_id) {
        this.user_id = user_id;
    }


    public void set_password(String password) {
        this.password = password;
    }


    public void set_email(String email) {
        this.email = email;
    }


    public void set_date_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public boolean is_logged_in() {
        return logged_in;
    }

    public void login(){
        Scanner input = new Scanner(System.in);
        String username;
        String password;
        
        System.out.print("Enter Username: ");
        username = input.nextLine();
        
        System.out.print("Enter Password: ");
        password = input.nextLine();
        
        if(username == this.username && password == this.password){
            System.out.println("User logged in: " + username);
            logged_in = true;
        }
    }

    public void logout(){
        logged_in = false;
        System.out.println("User logged out: " + username);
    }


    public void switch_users(){
        System.out.println("Attempting to switch users....");
    }

    //System.out.println("Sending notification to user: " + username);
    abstract public void send_notification(User user);
    
    public void recieve_notification(String notification){
        notifications.add(notification);
    }

    public void display_function(){
        System.out.println(this.username + "Main Menu");
    }


    public void display_notification(){
        System.out.println("Notification for user " + username + ": ");
        if(notifications.isEmpty()){
            System.out.println("No notification.");
        }
        else{
            for(String notification : notifications){
                System.out.println("-" + notification);
            }
        }
    }
}
