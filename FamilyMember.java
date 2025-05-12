/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_home_system;
import java.util.*;

public class FamilyMember extends HomeUser{
    private Scanner input = new Scanner(System.in);
    private static String login_notification = " has logged in to the system!";

    public FamilyMember(String username, String user_id, String password, String email, String date_of_birth){
        super(username, user_id, password, email, date_of_birth);
    }

    @Override
    public void login() {
        super.login(); 
        
        ArrayList<FamilyMember> familyMembers = SystemDatabase.get_familyMembers();
        for(FamilyMember member: familyMembers){
            if(!member.get_user_id().equalsIgnoreCase(this.get_user_id()))
            member.recieve_notification(this.get_username() + login_notification);
        }
    }

    public void view_private_devices(ArrayList<LinkedDevice> all_links, ArrayList<Device> devices, ArrayList<String> device_ids) {
               
        for(LinkedDevice link : all_links){
            if(link.get_owner_id().equalsIgnoreCase(this.get_user_id())){
                device_ids.add(link.get_device_id());
            }
        }
                
        if(device_ids.isEmpty()){
            System.out.println("No private devices assigned to you.");
        }
        else{
            System.out.println(this.get_username() + "'s Devices:");
            int index = 1;
            for(Device device : devices) {
                if (device_ids.contains(device.get_device_id())) {
                    System.out.print(index++);
                    device.display_info();
                }
            }
        }
    }

    public void update_inofrmation(){
        
        int choice;
        String new_info;
        boolean invalid;
        do{
            invalid = false;
            try{
                do{
                    System.out.println("What do you want to update?");
                    System.out.println("1. Username\n2. Email\n3. Pssword\n4.Exit");
                    System.out.print("Enter your choice: ");

                    choice = input.nextInt();
                    input.nextLine();
                    System.out.println();

                    switch(choice){
                        case 1:
                            System.out.print("Enter new username: ");
                            break;

                        case 2:
                            System.out.print("Enter new email: ");
                            break;

                        case 3:
                            System.out.print("Enter new password: ");
                            break;

                        case 4:
                            return;

                        default:
                            System.out.println("Invalid choice!");
                            continue;
                    }

                    new_info = input.nextLine();
                    new_info = new_info.trim();

                    if(new_info.isEmpty()){
                        System.out.println("This field can not be empty!");
                        continue;
                    }

                    switch(choice){
                        case 1:
                            this.set_username(new_info);
                            break;

                        case 2:
                            this.set_email(new_info);
                            break;

                        case 3:
                            this.set_password(new_info);
                            break;                                 
                    }
                    System.out.println("Your account updated successfully!\n");
                }while(choice != 4);
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input!! please enter numbers!");
                input.nextLine();
                invalid = true;
            }
        }while(invalid);
        
    }

    @Override
    public void send_notification(User homeowner) {
        String notification = "Some devices don't work!";
        homeowner.recieve_notification(notification);
        System.out.println("Notification is sent successfully!");
    }
    
    @Override
    public void display_functions() {
        super.display_functions();
        System.out.println("1. Update User Information.");
        System.out.println("2. View Private Devices List.");
        System.out.println("3. Use Devices.");
        System.out.println("4. Send Notification to Homeowner.");
        System.out.println("5. View Notification List.");
        System.out.println("6. Switch User.");
        System.out.println("7. Log Out.");
    }
}

    
