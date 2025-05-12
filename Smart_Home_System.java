/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package smart_home_system;

import java.util.*;
import java.io.*;


public class Smart_Home_System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<String> home_user_ids =SystemDatabase.get_home_user_ids();
        ArrayList<String> device_ids = SystemDatabase.get_device_ids();
        ArrayList<Device> devices = SystemDatabase.get_devices();
        ArrayList<LinkedDevice> all_links = SystemDatabase.get_all_links();
        ArrayList<FamilyMember> familyMembers = SystemDatabase.get_familyMembers();
        ArrayList<Device> malfunctioning_devices = SystemDatabase.get_malfunctioning_devices();

        Scanner input = new Scanner(System.in);
        boolean invalid;
        int choice;
        int index;
        
        do{
            invalid = false;
            try{
                Administrator admin = new Administrator("Ahmed", "123456789", "abcd", "Ahmed@gmail.com", "12/5/1980");
                HomeOwner homeowner = new HomeOwner("Fahad", "135792468", "efgh", "Fahad@gmail.com", "22/4/1984");
                FamilyMember familyMember;

                SystemDatabase.add_home_user(homeowner.get_user_id());
                do{
                    System.out.println("--------Smart Home System--------");
                    System.out.println("1. Homeowner.");
                    System.out.println("2. Administrator.");
                    System.out.println("3. FamilyMembers.");
                    System.out.println("4. Terminate.");
                    System.out.print("Your Choice: ");
                    choice = input.nextInt();
                    input.nextLine();

                    switch(choice){
                        case 1:
                            if(!homeowner.is_logged_in()){
                                homeowner.login();
                            }
                            if(homeowner.is_logged_in()){
                                do{
                                    invalid = false;
                                    try{
                                        do{
                                            homeowner.display_functions();
                                            System.out.print("Your Choice: ");
                                            choice = input.nextInt();
                                            input.nextLine(); 
                                            System.out.println();

                                            switch(choice){
                                                case 1:
                                                    homeowner.add_family_member(familyMembers, home_user_ids, admin);
                                                    if(!familyMembers.isEmpty()){
                                                        homeowner.display_family_members(familyMembers);
                                                    }
                                                    break;

                                                case 2:
                                                    homeowner.remove_family_member(devices, familyMembers, all_links, device_ids);
                                                    if(!familyMembers.isEmpty()){
                                                        homeowner.display_family_members(familyMembers);
                                                    }
                                                    break;

                                                case 3:
                                                    homeowner.display_family_members(familyMembers);
                                                    break;

                                                case 4:
                                                    homeowner.add_device(devices, familyMembers, home_user_ids, all_links, device_ids);
                                                    if(!devices.isEmpty()){
                                                        homeowner.display_all_devices(devices, all_links, device_ids, home_user_ids);
                                                    }
                                                    break;

                                                case 5:
                                                    homeowner.remove_device(devices, all_links, device_ids);
                                                    if(!devices.isEmpty()){
                                                        homeowner.display_all_devices(devices, all_links, device_ids, home_user_ids);
                                                    }
                                                    break;

                                                case 6:

                                                    homeowner.use_device(devices);
                                                    break;

                                                case 7:
                                                    homeowner.send_notification(admin);
                                                    break;

                                                case 8:
                                                    homeowner.display_notifications();
                                                    break;

                                                case 9:
                                                    homeowner.switch_users();
                                                    break;

                                                case 10:
                                                    homeowner.logout();
                                                    break;

                                                default:
                                                    System.out.println("Invalid choice!");
                                            }
                                        }while(choice != 10 && choice != 9);
                                    }
                                    catch(InputMismatchException e){
                                        System.out.println("Invalid input!! please enter numbers!");
                                        input.nextLine();
                                        invalid = true;
                                    }
                                }while(invalid);                                                        
                            }

                            break;

                        case 2:
                            if(!admin.is_logged_in()){
                                admin.login();
                            }
                            if(admin.is_logged_in()){
                                do{
                                    invalid = false;
                                    try{
                                        do{
                                            admin.display_functions();
                                            System.out.print("Your Choice: ");
                                            choice = input.nextInt();
                                            input.nextLine();
                                            System.out.println(); 

                                            switch(choice){
                                                case 1:
                                                    admin.generate_report(devices, all_links, malfunctioning_devices);
                                                    if (malfunctioning_devices.isEmpty()){
                                                        System.out.println("All devices are functioning normally.");
                                                    }
                                                    else{
                                                        do{
                                                            invalid = false;
                                                            try{
                                                                do{
                                                                    System.out.println("Do you want to notify the homeowner?");
                                                                    System.out.println("1. yes\n2. no");        
                                                                    choice = input.nextInt();

                                                                    if(choice == 1){
                                                                        admin.send_notification(homeowner);
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
                                                    break;

                                                case 2:
                                                    admin.provide_maintenance(malfunctioning_devices);
                                                    break;

                                                case 3:
                                                    Device.update_system_version();
                                                    break;

                                                case 4:
                                                    admin.turn_off(devices);
                                                    break;

                                                case 5:
                                                    admin.display_notifications();
                                                    break;

                                                case 6:
                                                    admin.switch_users();
                                                    break;

                                                case 7:
                                                    admin.logout();
                                                    break;

                                                default:
                                                    System.out.println("Invalid choice!");
                                            }
                                        }while(choice != 6 && choice != 7);  
                                    }
                                    catch(InputMismatchException e){
                                        System.out.println("Invalid input!! please enter numbers!");
                                        input.nextLine();
                                        invalid = true;
                                    }
                                }while(invalid);
                                                      
                            }

                            break;

                        case 3:
                            if(familyMembers.isEmpty()){
                                System.out.println("No family members added.");
                                break;
                            }
                            index = 1;
                            System.out.println();
                            for(FamilyMember member: familyMembers){
                                System.out.println((index++) + ". " + member.get_username());
                            }

                            System.out.print("Your Choice: ");
                            choice = input.nextInt();
                            if(choice >= 1 && choice <= familyMembers.size()){
                                familyMember = familyMembers.get(choice-1);
                                if(!familyMember.is_logged_in()){
                                    familyMember.login();
                                }
                                if(familyMember.is_logged_in()){
                                    do{
                                        invalid = false;
                                        try{
                                            do{
                                                familyMember.display_functions();
                                                System.out.print("Your Choice: ");
                                                choice = input.nextInt();
                                                input.nextLine();
                                                System.out.println(); 

                                                switch(choice){
                                                    case 1:
                                                        familyMember.update_inofrmation();
                                                        break;

                                                    case 2:
                                                        familyMember.view_private_devices(all_links, devices, device_ids);
                                                        break;

                                                    case 3:
                                                        familyMember.use_device(devices);
                                                        break;

                                                    case 4:
                                                        familyMember.send_notification(homeowner);
                                                        break;

                                                    case 5:
                                                        familyMember.display_notifications();
                                                        break;

                                                    case 6:
                                                        admin.switch_users();
                                                        break;

                                                    case 7:
                                                        familyMember.logout();
                                                        break;

                                                    default:
                                                        System.out.println("Invalid choice!");
                                                }
                                            }while(choice != 6 && choice != 7);    
                                        }
                                        catch(InputMismatchException e){
                                            System.out.println("Invalid input!! please enter numbers!");
                                            input.nextLine();
                                            invalid = true;
                                        }
                                    }while(invalid);                                                        
                                }

                            }
                            else{
                                System.out.println("Invalid choice!");
                                choice = 0;
                            }
                            break; 

                        case 4:
                            System.out.println("Thank you for using our system:)");
                            break;

                        default:
                            System.out.println("Invalid choice!");        
                    }
                    System.out.println("______________________________________\n");
                }while(choice != 4);
            }
            catch(InputMismatchException e){
                System.out.println("Invalid input!! please enter numbers!\n");
                input.nextLine();
                invalid = true;
            }
            catch(NullPointerException e1){
                System.out.println("There was a null pointer to be accessed!\n");
                invalid = true;
            }
        }while(invalid);
        
    }
        
        
    
}
