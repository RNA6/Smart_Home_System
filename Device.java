/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_home_system;


public class Device {
    private String device_name;
    private String device_id;
    private String owner_id;
    private String device_status;
    private int usage_counter;
    private boolean is_private;
    private static double system_version = 1.3;

    public Device(String device_name, String device_id, String owner_id , String device_status, boolean is_private) {
        this.device_name = device_name;
        this.device_id = device_id;
        this.owner_id = owner_id;
        this.device_status = device_status;
        usage_counter = 0;
        this.is_private = is_private;
        
    }

    public String get_device_name() {
        return device_name;
    }

    public void set_device_name(String device_name) {
        this.device_name = device_name;
    }

    public String get_device_id() {
        return device_id;
    }

    public void set_device_id(String device_id) {
        this.device_id = device_id;
    }

    public String get_owner_id() {
        return owner_id;
    }

    public void set_owner_id(String owner_id) {
        this.owner_id = owner_id;
    }
    

    public String get_device_status() {
        return device_status;
    }

    public void set_device_status(String device_status) {
        this.device_status = device_status;
    }

    public int get_usage_counter() {
        return usage_counter;
    }

    public boolean get_is_private() {
        return is_private;
    }

    public void set_is_private(boolean is_private) {
        this.is_private = is_private;
    }

    public static void display_system_version() {
        System.out.println("V" + system_version);
        
    }

    public static void update_system_version(double system_version) {
        Device.system_version = system_version;
    }
    
    public void increment_counter(){
        usage_counter++;
    }
    
    public void reset_usage_counter() {
        usage_counter = 0;
    }
    
    public void display_info(){
        System.out.println("Device Name: " + device_name);
        System.out.println("Device Status: " + device_status);     
    }
}
