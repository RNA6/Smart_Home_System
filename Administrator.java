/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_home_system;
import java.util.*;

public class Administrator extends User{
    private Scanner input = new Scanner(System.in);
    public Administrator(String username, String user_id, String password, String email, String date_of_birth) {
        super(username, user_id, password, email, date_of_birth);
    }

    public boolean check_device(Device device) {
        if (device.get_usage_counter() >= Device.get_max_operating_cycles()) {
                return true;
        }
        return false;
    }

    public void generate_report(ArrayList<Device> devices, ArrayList<LinkedDevice> all_links, ArrayList<Device> malfunctioning_devices){
        for(Device device : devices) {
            System.out.println("Device " + (devices.indexOf(device)+1) + " information");
            System.out.println("Id: " + device.get_device_id());
            device.display_info();
            System.out.println("Usage counter:" + device.get_usage_counter());
            
            if (check_device(device)) {                
                malfunctioning_devices.add(device);
                System.out.println("This device needs maintenance!!");
            }
            System.out.println("___________________________________");
        }
        Device.display_system_version();
    }

    public void provide_maintenance(ArrayList<Device> malfunctioning_devices) {
        if(!malfunctioning_devices.isEmpty()){
            for (Device device : malfunctioning_devices) {            
                System.out.println("Maintenance provided for device: " + device.get_device_name());
                device.reset_usage_counter();
                device.set_device_status("off");

            }
            System.out.println("Maintenance Done successfully!");
            malfunctioning_devices.clear();
        }
        else{
            System.out.println("There is no malfunctioning devices, or no check is done!");
        }
    }

    public void turn_off(ArrayList<Device> devices) {
        for (Device device : devices) {
            if(device.get_device_status().equalsIgnoreCase("on")) {
                device.set_device_status("off");
                System.out.println("Device " + device.get_device_name() + " has been turned off due to emergency.");
            }
        }
        System.out.println("All active devices have been turned off.");
    }

    @Override
    public void send_notification(User homeowner) {
        ArrayList<Device> malfunctioning_devices = SystemDatabase.get_malfunctioning_devices();
        String notification = "You have " + malfunctioning_devices.size() + " device/s require maintenance!";
        homeowner.recieve_notification(notification);
        System.out.println("Notification is sent successfully!");
    }

    @Override
    public void display_functions() {
        super.display_functions();
        System.out.println("1. Generate Device Status Report.");
        System.out.println("2. Provide maintenance.");
        System.out.println("3. Update System Version.");
        System.out.println("4. Turn Off All System Devices.");
        System.out.println("5. View Notification List.");
        System.out.println("6. Switch User.");
        System.out.println("7. Log Out.");
    }
    
    
}

