/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_home_system;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeOwner extends HomeUser {
    private Scanner input = new Scanner(System.in);

    public HomeOwner(String username, String user_id, String password, String email, String date_of_birth) {
        super(username, user_id, password, email, date_of_birth);
    }

    public void add_family_member(ArrayList<FamilyMember> familyMembers, ArrayList<String> home_user_ids, Administrator admin) {
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        
        String user_id;
        do{
            System.out.print("Enter User Id: ");
            user_id = input.nextLine(); 
            user_id = user_id.trim();
            
            if(user_id.equalsIgnoreCase(admin.get_user_id())){
                System.out.println("This user id already exists!");
                    user_id = ""; 
            }
            else{
               for(String home_user_id: home_user_ids){
                    if(home_user_id.equalsIgnoreCase(user_id)){
                        System.out.println("This user id already exists!");
                        user_id = "";  
                        return;
                    }
                } 
            }            
        }while(user_id.equals(""));
        
        System.out.print("Enter Password: ");
        String password = input.nextLine();
        
        System.out.print("Enter Email: ");
        String email = input.nextLine();
        
        System.out.print("Enter Date of Birth: ");
        String date_of_birth = input.nextLine();
        
        System.out.println();
        
        if (familyMembers.size() < 10) {
            FamilyMember familyMember = new FamilyMember(username, user_id, password, email, date_of_birth);
            familyMembers.add(familyMember);
            SystemDatabase.add_home_user(familyMember.get_user_id());
            System.out.println("Family member " + familyMember.get_username()+ " added successfully.");
        } else {
            System.out.println("You cannot add more than 10 family members!");
        }
    }

    public void remove_family_member(ArrayList<Device> devices, ArrayList<FamilyMember> familyMembers, ArrayList<LinkedDevice> all_links, ArrayList<String> device_ids) {
        String user_id;
        FamilyMember dfamilyMember = null;
        System.out.print("Enter the family member id to be deleted: ");
        user_id = input.nextLine();
        
        for (FamilyMember member : familyMembers){
            if(user_id.equalsIgnoreCase(member.get_user_id())) {
                dfamilyMember = member;
            }
        }
        
        if(dfamilyMember != null) {
            int choice;
            boolean invalid;
            do{
                invalid = false;
                try{
                    do{
                        System.out.println("Are you sure you want to remove this family member?");
                        System.out.println("1: Remove\n2: Cancel");
                        System.out.print("Enter your choice: ");

                        choice = input.nextInt();
                        input.nextLine();

                        if(choice == 1){
                            familyMembers.remove(dfamilyMember);
                            System.out.println("Family member " + dfamilyMember.get_username()+ " removed.");
                            for(LinkedDevice link : all_links){
                                if(link.get_owner_id().equalsIgnoreCase(dfamilyMember.get_user_id())){
                                    device_ids.add(link.get_device_id());
                                    all_links.remove(link);
                                }
                            }
                            //for(int i=0; i<size; i++)
                            for (Device device : devices){
                                if(device_ids.contains(device.get_device_id())) {
                                    devices.remove(device);
                                }
                            }
                            return;
                        }
                        else if(choice != 2){
                           System.out.println("Invalid choice! Try again."); 
                        }
                    }while(choice != 1 && choice != 2);
                }
                catch(InputMismatchException e){
                    System.out.println("Invalid input!! please enter numbers!");
                    input.nextLine();
                    invalid = true;
                }
            }while(invalid);
            
        }
        else {
            System.out.println("Family member not found.");
        }
        device_ids.clear();
    }

    public void display_family_members(ArrayList<FamilyMember> familyMembers) {
        if (familyMembers.isEmpty()) {
            System.out.println("No family members added.");
        } else {
            System.out.println("Family Members List:");
            for (FamilyMember member : familyMembers) {
                System.out.println((familyMembers.indexOf(member)+1) + ". " +
                        member.get_username() + " " +
                        member.get_user_id());
            }
        }
    }

    public void add_device(ArrayList<Device> devices, ArrayList<FamilyMember> familyMembers, ArrayList<String> home_user_ids, ArrayList<LinkedDevice> all_links, ArrayList<String> device_ids){
        String owner_id;
        
        System.out.print("Enter Device Name: ");
        String device_name = input.nextLine();
        
        String device_id;
        do{
            System.out.print("Enter Device Id: ");
            device_id = input.nextLine(); 
            device_id = device_id.trim();
            
            for(Device device: devices){
                if(device.get_device_id().equalsIgnoreCase(device_id)){
                    System.out.println("This device id already exists");
                    device_id = "";  
                    return;
                }
            }
        }while(device_id.equals(""));
        
        boolean is_private =false;
        boolean invalid;
        do{
            invalid = false;
            try{
                System.out.println("Is the device private?");
                System.out.print("true of false: ");

                is_private = input.nextBoolean();
                input.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input!! please enter numbers!");
                input.nextLine();
                invalid = true;
            }
        }while(invalid);
        
        
        Device device = new Device(device_name, device_id , is_private);
        
        devices.add(device);
        
        if(is_private){
            do{
                System.out.println("\nYour id: " + this.get_user_id());
                display_family_members(familyMembers);
                System.out.println();
                System.out.println("Enter device owner id: ");
                owner_id = input.nextLine();

                if(home_user_ids.contains(owner_id)){
                    break;
                }
                else{
                    System.out.println("This id does not exist. Try again!");
                }
            }while(!home_user_ids.contains(owner_id));
            
            SystemDatabase.add_link(owner_id, device_id);
            
            String username = "";
            if(owner_id.equalsIgnoreCase(this.get_user_id())){
                username = this.get_username();
            }
            else{
                for (FamilyMember member : familyMembers){
                    if (member.get_user_id().equalsIgnoreCase(owner_id)){
                        username = member.get_username();
                        break;
                    }
                }    
            }
            
            System.out.println("Device " + device.get_device_name() + " is added to " + username + "'s list.");
        }
        else{
            System.out.println("Public device " + device.get_device_name() + " is added succefully!");
        }
    }
    
    public void remove_device(ArrayList<Device> devices, ArrayList<LinkedDevice> all_links, ArrayList<String> device_ids){
        String device_id;
        Device ddevice = null;
        System.out.print("Enter the device id to be deleted: ");
        device_id = input.nextLine();
        
        if(devices.isEmpty()){
            System.out.println("There is no device in the system!");
            return;
        }
        
        for (Device device : devices){
            if(device_id.equalsIgnoreCase(device.get_device_id())) {
                ddevice = device;
                break;
            }
        }
        
        if(ddevice != null) {
            int choice;
            boolean invalid;
            do{
                invalid = false;
                try{
                    do{
                        System.out.println("Are you sure you want to remove this device?");
                        System.out.println("1: Remove\n2: Cancel");
                        System.out.print("Enter your choice: ");

                        choice = input.nextInt();
                        input.nextLine();

                        if(choice == 1){
                            devices.remove(ddevice);
                            System.out.println("Device removed: " + ddevice.get_device_name());
                            for(LinkedDevice link : all_links){
                                if(link.get_device_id().equalsIgnoreCase(ddevice.get_device_id())){
                                    all_links.remove(link);
                                    return;
                                }
                            }
                            return;
                        } 
                        if(choice != 2){
                        System.out.println("Invalid choice! Try again.");
                        }
                    }while(choice != 1);
                }
                catch(InputMismatchException e){
                    System.out.println("Invalid input!! please enter numbers!");
                    input.nextLine();
                    invalid = true;
                }
            }while(invalid);
            
        }
        else{
            System.out.println("Device not found!");
        }
    }

    public void display_all_devices(ArrayList<Device> devices, ArrayList<LinkedDevice> all_links, ArrayList<String> device_ids, ArrayList<String> home_user_ids) {
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
                    index = devices.indexOf(device)+1;
                    System.out.println("Index: " + index +
                                       ", Name: " + device.get_device_name() +
                                       ", Status: " + device.get_device_status());
                }
            }
        }
        
        for (LinkedDevice link : all_links) {
            if (home_user_ids.contains(link.get_owner_id())) {
                device_ids.add(link.get_device_id());
            }
        }
        if(device_ids.isEmpty()){
            System.out.println("There is no private devices!");
        }
        else{
            index = 1;
            System.out.println("All Private Devices:");
            for (Device device : devices) {
                if (device_ids.contains(device.get_device_id())) {
                    System.out.println("Index: " + (index++));
                    device.display_info();
                }
            }
        }
        device_ids.clear();
    } 
    
    @Override
    public void send_notification(User administrator) {
        String notification = "I have some devices that require maintenance!";
        administrator.recieve_notification(notification);
        System.out.println("Notification is sent successfully!");
    }
    
    @Override
    public void display_functions() {
        super.display_functions();
        System.out.println("1. Add a Family Member.");
        System.out.println("2. Remove a Family Member.");
        System.out.println("3. View Registered Family Members .");
        System.out.println("4. Add a Device.");
        System.out.println("5. Remove a Device.");
        System.out.println("6. Use Devices.");
        System.out.println("7. Send Notification to Administrator.");
        System.out.println("8. View Notification List.");
        System.out.println("9. Switch User.");
        System.out.println("10. Log Out.");
    }
}
