package by.tc.task01.entity;

import java.io.Serializable;

public class TabletPC extends Appliance implements Serializable{
    public TabletPC(){}
    
    public TabletPC(int batteryCapacity, int displayInches, int memoryROM,
            int flashMemoryCapacity, String color){
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryROM = memoryROM;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;  
    }
    
    private int batteryCapacity;
    private int displayInches;
    private int memoryROM;
    private int flashMemoryCapacity;
    private String color;
    
    public int getBatteryCapacity(){
        return batteryCapacity;
    }
    public int getDisplayInches(){
        return displayInches;
    }
    public int getMemoryROM(){
        return memoryROM;
    }
    public int getFlashMemoryCapacity(){
        return flashMemoryCapacity;
    }
    public String getColor(){
        return color;
    }
    
    public void setBatteryCapacity(int batteryCapacity){
        this.batteryCapacity = batteryCapacity;
    }
    public void setDisplayInches(int displayInches){
        this.displayInches = displayInches;
    }
    public void setMemoryROM(int memoryROM){
        this.memoryROM = memoryROM;
    }
    public void setFlashMemoryCapacity(int flashMemoryCapacity){
        this.flashMemoryCapacity = flashMemoryCapacity;
    }
    public void setColor(String color){
        this.color = color;
    }
    
    @Override
    public boolean equals (Object obj){
        if(this == obj){
            return true;
        }
        if(null == obj || getClass() != obj.getClass()){
            return false;
        }
        TabletPC tabletPC = (TabletPC)obj;
        
        if(batteryCapacity != tabletPC.batteryCapacity ||
           displayInches != tabletPC.displayInches ||
           memoryROM != tabletPC.memoryROM ||
           flashMemoryCapacity != tabletPC.flashMemoryCapacity){
            return false;
        }
        if(null == color){
            return (color == tabletPC.color);
        }
        else {
            if(!color.equals(tabletPC.color)){
                return false;
            }
        }      
        return true;
    }
    
    @Override
    public int hashCode(){
        int hash = 9;
        int prime = 21;
        hash = prime * hash + this.batteryCapacity;
        hash = prime * hash + this.displayInches;
        hash = prime * hash + this.memoryROM;
        hash = prime * hash + this.flashMemoryCapacity;
        hash = prime * hash + 
                (this.color != null ? this.color.hashCode() : 0 );
        return hash;
    }
    
    @Override
    public String toString(){
       return "TabletPC :BATTERY_CAPACITY="+this.batteryCapacity
               +", DISPLAY_INCHES="+this.displayInches
               +", MEMORY_ROM="+this.memoryROM
               +", FLASH_MEMORY_CAPACITY="+this.flashMemoryCapacity
               +", COLOR="+this.color; 
    }
}
