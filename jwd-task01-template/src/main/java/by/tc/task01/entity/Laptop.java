package by.tc.task01.entity;

import java.io.Serializable;

public class Laptop extends Appliance implements Serializable{
    public Laptop(){}
    
    public Laptop(double batteryCapacity,String os,int memoryROM,int systemMemory,
            double cpu,int displayInchs){
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryROM = memoryROM;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInchs = displayInchs;   
    }
    
    private double batteryCapacity;
    private String os;
    private int memoryROM;
    private int systemMemory;
    private double cpu;
    private int displayInchs;
    
    public double getBatteryCapacity(){
        return batteryCapacity;
    }
    public String getOS(){
        return os;
    }
    public int getMemoryROM(){
        return memoryROM;
    }
    public int getSystemMemory(){
        return systemMemory;
    }
    public double getCPU(){
        return cpu;
    }
    public int getDisplayInchs(){
        return displayInchs;
    }
    
    public void setBatteryCapacity(double batteryCapacity){
        this.batteryCapacity = batteryCapacity;
    }
    public void setOS(String os){
        this.os = os;
    }
    public void setMemoryROM(int memoryROM){
        this.memoryROM = memoryROM;
    }
    public void setSystemMemory(int systemMemory){
        this.systemMemory = systemMemory;
    }
    public void setCPU(double cpu){
        this.cpu = cpu;
    }
    public void setDisplayInchs(int displayInchs){
        this.displayInchs = displayInchs;
    }
    
        @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(null == obj || getClass() != obj.getClass()){
            return false;
        }
        Laptop laptop = (Laptop)obj;
        if( batteryCapacity != laptop.batteryCapacity ||
                memoryROM != laptop.memoryROM||
                systemMemory != laptop.systemMemory ||
                cpu != laptop.cpu ||
                displayInchs != laptop.displayInchs){
            return false;
        }
        
        if(null == os){
            return (os == laptop.os);
        }
        else{
            if(! os.equals(laptop.os)){
                return false;
            }
        }
        return true;
        
    }

    @Override
    public int hashCode() {
        int hash = 7;
        int prime = 59;
        hash = prime * hash + (int) 
                (Double.doubleToLongBits(this.batteryCapacity) 
                ^ (Double.doubleToLongBits(this.batteryCapacity) >>> 32));
        hash = prime * hash + 
                (this.os != null ? this.os.hashCode() : 0);
        hash = prime * hash + this.memoryROM;
        hash = prime * hash + this.systemMemory;
        hash = prime * hash + (int) 
                (Double.doubleToLongBits(this.cpu) 
                ^ (Double.doubleToLongBits(this.cpu) >>> 32));
        hash = prime * hash + this.displayInchs;
        return hash;
    }
    
    @Override
    public String toString(){
       return "Laptop :BATTERY_CAPACITY="+this.batteryCapacity
               +", OS="+this.os
               +", MEMORY_ROM="+this.memoryROM
               +", SYSTEM_MEMORY="+this.systemMemory
               +", CPU="+this.cpu
               +", DISPLAY_INCHS="+this.displayInchs; 
    }
	
}
