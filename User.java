/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_home_system;
import java.util.ArrayList;

public class User {
    private String username;
    private String user_id;
    private String password;
    private String email;
    private String date_of_birth;
    private ArrayList<String>notification;

    public User(String username , String user_id , String password , String email , String date_of_birth){
        this.username = username;
        this.user_id = user_id;
        this.password = password;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.notification = new ArrayList<>();
    }


    public String getUsername() {
        return username;
    }


    public String getUser_id() {
        return user_id;
    }


    public String getPassword() {
        return password;
    }


     public String getEmail() {
        return email;
    }


     public String getDate_of_birth() {
        return date_of_birth;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }


    public void login(){
        System.out.println("User logged in: " + username);
    }


    public void logout(){
        System.out.println("User logged out: " + username);
    }


    public void switch_users(){
        System.out.println("Attempting to switch users....");
    }


    public void send_notification(){
        System.out.println("Sending notification to user: " + username);
    }


    public void display_function(){
        System.out.println("Displaying user function....");
    }


    public void display_notification(){
        System.out.println("Notification for user " + username + ": ");
        if(notification.isEmpty()){
            System.out.println("No notification.");
        }
        else{
            for(String notificaion : notification){
                System.out.println("-" + notification);
            }
        }
    }
}
