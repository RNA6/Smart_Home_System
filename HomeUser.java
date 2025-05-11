/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_home_system;


public class HomeUser {
        public HomeUser(String username, String user_id, String password, String email, String date_of_birth) {
        super(username, user_id, password, email, date_of_birth);
        
 public void use_device(ArrayList<Device> devices_List, int index, String status) {

    if (index < 0 || index > devices_List.size()) {
        System.out.println("Invalid index. Please Try agan.");
        return;
    }

    Device device = devices_List.get(index); 
    String current_Status = device.get_device_status();

    if (status.equalsIgnoreCase("on")) {
        if (current_status.equalsIgnoreCase("on")) {
            System.out.println("Device " + device.get_device_name() + " is already on.");
        } 
        else {
            device.set_device_status("on");
            device.set_usage_counter(device.get_usage_counter() + 1);
            System.out.println("Device " + device.get_device_name() + " turned on.");
        }
    } else if (status.equalsIgnoreCase("off")) {
        device.set_device_status("off");
        System.out.println("Device " + device.get_device_name() + " turned off.");
    } else {
        System.out.println("Invalid action. Please choose 'on' or 'off'.");
    }
}
        
public void display_devices(ArrayList<Device> devices, ArrayList<LinkedDevice> all_links) {
    int index = devices.indexOf(device);
    
    System.out.println("Public Devices:");
    for (Device device : devices) {
        if (!device.is_private) {
            System.out.println("Index: " + index +
                               ", Name: " + device.device_name +
                               ", Status: " + device.device_status);
        }
    }

    for (LinkedDevice link : all_links) {
        if (link.user_id.equals(this.user_id)) {
            device_ids.add(link.device_id);
        }
    }

    System.out.println("Your Private Devices:");
    for (Device device : devices) {
        if (device_ids.contains(device.device_id)) {
            System.out.println("Index: " + index +
                               ", Name: " + device.device_name +
                               ", Status: " + device.device_status);
        }
    }
}

}
