/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_home_system;


public class Administrator {
        public Administrator(String username, String user_id, String password, String email, String date_of_birth) {
    super(username, user_id, password, email, date_of_birth);
}

    
    public boolean check_devices(ArrayList<Device> device_List) {
    boolean check = false;

    for (Device device : device_List) {
        if (device.getUsage_counter() >= MAX_USAGE) {
            check = true;
             generate_report();
        }
    }
    if (!check) {
        System.out.println("All devices are functioning normally.");
    }

    return check;
}
    
public void generate_report(ArrayList<Device> devices_List,  send_notification) {
    boolean maintenanceNeeded = false;
    ArrayList<Device> devices_needing_maintenance = new ArrayList<>();

    for (Device device : devices_List) {
        if (device.get_usage_counter() >= Device.getMaxUsage()) {
            maintenanceNeeded = true;
            devices_needing_maintenance.add(device);
        }
    }

    if (maintenanceNeeded) {
        System.out.println("Maintenance required for the following devices:");
        for (Device d : devices_needing_maintenance) {
            System.out.println("- Device Name: " + d.get_device_name() + ", ID: " + d.get_device_id());
        }

        if (send_Notification) {
            send_notifications(); // Assuming this sends notifications to the homeowner
        } else {
            System.out.println("Report stored internally. Waiting for homeowner to resolve the issue.");
        }

    } else {
        System.out.println("All devices are operating within normal usage limits.");
    }
}
}

private void send_notificatio() {
    System.out.println();
}

 public void provide_maintenance(ArrayList<Device> devices) {
    for (Device device : devices) {
        if (device.get_usage_counter() >= get_max_operating_cycles()) {
            System.out.println("Maintenance provided for device: " + device.get_device_name());
            device.set_usage_counter(0);
        }
    }
    System.out.println("Maintenance Done successfully");
    
}
   
 public void update_system_version(double ////// ) {
    //////////
    System.out.println("System version updated to: " + newVersion);
}
   
   public void turn_off(ArrayList<Device> devices_List) {/////
    for (Device device : devices_List) {
        if (device.get_device_status().equalsIgnoreCase("on")) {
            device.set_device_status("off");
            System.out.println("Device " + device.get_device_name() + " has been turned off due to emergency.");
        }
    }
    System.out.println("All active devices have been turned off.");
}

}
