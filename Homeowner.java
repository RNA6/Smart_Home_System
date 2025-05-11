/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_home_system;

public class HomeOwner extends User {
    private ArrayList<FamilyMember> familyMembers;
    private ArrayList<Device> devices;

    public HomeOwner(String username, String user_id, String password, String email, String date_of_birth) {
        super(username, user_id, password, email, date_of_birth);
        this.familyMembers = new ArrayList<>();
        this.devices = new ArrayList<>();
    }

    public void addFamilyMember(FamilyMember familyMember) {
        if (familyMembers.size() < 10) { 
            familyMembers.add(familyMember);
            System.out.println("Family member " + familyMember.getName() + " added.");
        } else {
            System.out.println("Cannot add more than 10 family members.");
        }
    }

    public void removeFamilyMember(FamilyMember familyMember) {
        if (familyMembers.contains(familyMember)) {
            familyMembers.remove(familyMember);
            System.out.println("Family member " + familyMember.getName() + " removed.");
        } else {
            System.out.println("Family member not found.");
        }
    }

    public void displayFamilyMembers() {
        if (familyMembers.isEmpty()) {
            System.out.println("No family members added.");
        } else {
            System.out.println("Family Members List:");
            for (FamilyMember member : familyMembers) {
                System.out.println(member.getName());
            }
        }
    }

    public void addDevice(Device device) {
        devices.add(device);
        System.out.println("Device added: " + device.get_device_name());
    }

    public void removeDevice(Device device) {
        if (devices.contains(device)) {
            devices.remove(device);
            System.out.println("Device removed: " + device.get_device_name());
        } else {
            System.out.println("Device not found.");
        }
    }

    public void displayDevices() {
        if (devices.isEmpty()) {
            System.out.println("No devices available.");
        } else {
            System.out.println("Devices List:");
            for (Device device : devices) {
                device.display_info();
            }
        }
    }

    public void sendNotification(String message) {
        System.out.println("Sending notification to system administrator: " + message);
    }

    public void displayNotifications() {
        System.out.println("Notifications for HomeOwner " + getUsername() + ":");
        super.display_notification();
    }
}

    
}
