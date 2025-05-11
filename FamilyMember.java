/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_home_system;
import java.util.ArrayList;
private ArrayList<Device> devices;

public class FamilyMember {
    private String name;
    private String user_id;
    private String email;

    public FamilyMember(String name, String user_id, String email) {
        this.name = name;
        this.user_id = user_id;
        this.email = email;
        this.devices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

     public void addDevice(Device device) {
        devices.add(device);
        System.out.println("Device added to " + name + "'s list: " + device.get_device_name());
    }
    public void removeDevice(Device device) {
        devices.remove(device);
        System.out.println("Device removed from " + name + "'s list: " + device.get_device_name());
    }

    public void displayDevices() {
        System.out.println(name + "'s Devices:");
        if (devices.isEmpty()) {
            System.out.println("No devices assigned.");
        } else {
            for (Device device : devices) {
                device.display_info();
            }
        }
    }
}

    

