/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_home_system;

import java.util.*;


public class SystemDatabase {
    private static ArrayList<String> home_user_ids = new ArrayList();
    private static ArrayList<String> device_ids = new ArrayList();
    private static ArrayList<Device> devices = new ArrayList();
    private static ArrayList<LinkedDevice> all_links = new ArrayList();
    private static ArrayList<FamilyMember> familyMembers = new ArrayList();
    private static ArrayList<Device> malfunctioning_devices = new ArrayList();
    
    public static void add_home_user(String id){        
        home_user_ids.add(id);
    }
    
    public static void add_link(String oid, String did){
        LinkedDevice link = new LinkedDevice(oid, did);
        all_links.add(link);
    }

    public static ArrayList<Device> get_malfunctioning_devices() {
        return malfunctioning_devices;
    }

    public static ArrayList<FamilyMember> getFamilyMembers() {
        return familyMembers;
    }    
}
