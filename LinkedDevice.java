/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smart_home_system;

public class LinkedDevice {
    private String owner_id;
    private String device_id;

    public LinkedDevice(String owner_id, String device_id) {
        this.owner_id = owner_id;
        this.device_id = device_id;
    }

    @Override
    public String toString() {
        return "Linked_Device{" + "owner_id=" + owner_id + ", device_id=" + device_id + '}';
    }
    
    
    
}
