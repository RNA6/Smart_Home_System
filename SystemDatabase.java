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
    
    public static void add_home_user(String id){        
        home_user_ids.add(id);
    }
    
    public static void add_device(){        
        //Sarah code
    }
    
    public static void add_link(String oid, String did){
        LinkedDevice link = new LinkedDevice(oid, did);
        all_links.add(link);
    }
    
    public static void display_devices(){
        //Rahaf code
    }
    
    
    
}
