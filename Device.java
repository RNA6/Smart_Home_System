/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_home_system;

public class Device {
    private String device_name;
    private String device_id;
    private String device_status;
    private int usage_counter;
    private boolean is_private;
    private static int system_version;

    public Device(String device_name, String device_id, String device_status, int usage_counter, boolean is_private) {
        this.device_name = device_name;
        this.device_id = device_id;
        this.device_status = device_status;
        this.usage_counter = usage_counter;
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

    public String get_device_status() {
        return device_status;
    }

    public void set_device_status(String device_status) {
        this.device_status = device_status;
    }

    public int get_usage_counter() {
        return usage_counter;
    }

    public void set_usage_counter(int usage_counter) {
        this.usage_counter = usage_counter;
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

    public static void set_system_version(int system_version) {
        Device.system_version = system_version;
    }    
}
