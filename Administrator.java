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
        
        System.out.println("All devices are functioning normally.");
        return false;
    }

    public void generate_report(ArrayList<Device> devices, ArrayList<LinkedDevice> all_links, ArrayList<Device> malfunctioning_devices){
        for(Device device : devices) {
            System.out.println("Device " + devices.indexOf(device) + " information");
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
        
        int choice;
        
        /*
        do{
           System.out.println("Do you want to notify the homeowner?");
           System.out.println("1. yes\n2. no");        
           choice = input.nextInt();
           
           if(choice == 1){
               send_notification();
           }
           else if(choice != 2){
               System.out.println("Invalid choice! Try again.");
           }
            
        }while(choice != 1 && choice != 2);*/
    }

    public void provide_maintenance(ArrayList<Device> malfunctioning_devices) {
        for (Device device : malfunctioning_devices) {            
            System.out.println("Maintenance provided for device: " + device.get_device_name());
            device.reset_usage_counter();
            
        }
        System.out.println("Maintenance Done successfully!");

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
        String notification = "You have " + malfunctioning_devices.size() + " devices require maintenance!";
        homeowner.recieve_notification(notification);
    }

    @Override
    public void display_function() {
        super.display_function();
        System.out.println("1. Generate Device Status Report.");
        System.out.println("2. Provide maintenance.");
        System.out.println("3. Update System Version.");
        System.out.println("4. Turn Off All System Devices.");
        System.out.println("5. Switch User.");
        System.out.println("6. Log Out.");
    }    
}

