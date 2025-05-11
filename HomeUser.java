/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_home_system;
import java.util.ArrayList;


abstract public class HomeUser extends User{
    public HomeUser(String username, String user_id, String password, String email, String date_of_birth){
        super(username, user_id, password, email, date_of_birth);
    }

    public void use_device(ArrayList<Device> devices_list, int index, String status){
        if (index < 0 || index > devices_list.size()-1) {
            System.out.println("Invalid index! Please Try again.");
            return;
        }

        Device device = devices_list.get(index); 
        
        if(device.get_usage_counter() >= Device.get_max_operating_cycles()){
            if(device.get_device_status() != "error"){
                device.set_device_status("error");
            }
            System.out.println("You can't use this device!!");
        }
        
        String current_status = device.get_device_status();

        if (status.equalsIgnoreCase("on")) {
            if (current_status.equalsIgnoreCase("on")) {
                System.out.println("Device " + device.get_device_name() + " is already on.");
            } 
            else {
                device.set_device_status("on");
                device.increment_counter();
                System.out.println("Device " + device.get_device_name() + " turned on.");
            }
            
        }
        else if (status.equalsIgnoreCase("off")) {
            if (current_status.equalsIgnoreCase("off")) {
                System.out.println("Device " + device.get_device_name() + " is already off.");
            } 
            else {
                device.set_device_status("off");
                System.out.println("Device " + device.get_device_name() + " turned off.");
            }
            
        }
        else {
            System.out.println("Invalid status! Please choose 'on' or 'off'.");
        }
    }

    public void display_all_devices(ArrayList<Device> devices, ArrayList<LinkedDevice> all_links, ArrayList<String> device_ids) {
        int index = -1;
        
        for (Device device : devices){
            if (!device.get_is_private()) {
                index = devices.indexOf(device);
                return;
            }
        }
        
        if(index == -1){
            System.out.println("There is no public device!");
        }
        else{
            System.out.println("Public Devices:");
            for (Device device : devices) {
                if (!device.get_is_private()) {
                    index = devices.indexOf(device);
                    System.out.println("Index: " + index +
                                       ", Name: " + device.get_device_name() +
                                       ", Status: " + device.get_device_status());
                }
            }
        }
        
        for (LinkedDevice link : all_links) {
            if (link.get_owner_id().equals(this.get_user_id())) {
                device_ids.add(link.get_device_id());
            }
        }
        if(device_ids.isEmpty()){
            System.out.println("There is no private devices!");
        }
        else{
            index = 1;
            System.out.println("Your Private Devices:");
            for (Device device : devices) {
                if (device_ids.contains(device.get_device_id())) {
                    System.out.println("Index: " + (index++));
                    device.display_info();
                }
            }
        }
        device_ids.clear();
    } 
    
}
