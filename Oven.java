package by.tc.task01.entity;

import java.io.Serializable;

public class Oven extends Appliance implements Serializable{
    public Oven(){}
    
    public Oven(int powerConsumption,int weight,int capacity,
            int depth,double height,double width){
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.depth = depth;
        this.height = height; 
        this.width = width;
    }
        
    private int powerConsumption;
    private int weight;
    private int capacity;
    private int depth;
    private double height;
    private double width;
     
    public int getPowerConsumption(){
        return powerConsumption;
    }
    public int getWeight(){
        return weight;
    }
    public int getCapacity(){
        return capacity;
    }
    public int getDepth(){
        return depth;
    }
    public double getHeight(){
        return height;
    }
    public double getWidth(){
        return width;
    }
    
    public void setPowerConsumption(int powerConsumption){
        this.powerConsumption = powerConsumption;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public void setDepth(int depth){
        this.depth = depth;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void setWidth(double width){
        this.width = width;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(null == obj || getClass() == obj.getClass()){
            return false;
        }
        Oven oven = (Oven)obj;
        return !(powerConsumption != oven.powerConsumption ||
                weight != oven.weight ||
                capacity != oven.capacity ||
                depth != oven.depth ||
                height != oven.height ||
                width != oven.width);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        int prime = 89;
        hash = prime * hash + this.powerConsumption;
        hash = prime * hash + this.weight;
        hash = prime * hash + this.capacity;
        hash = prime * hash + this.depth;
        hash = prime * hash + (int) 
                (Double.doubleToLongBits(this.height) ^ 
                (Double.doubleToLongBits(this.height) >>> 32));
        hash = prime * hash + (int) 
                (Double.doubleToLongBits(this.width) 
                ^ (Double.doubleToLongBits(this.width) >>> 32));
        return hash;
    }
    
    @Override
    public String toString(){
       return "Oven :POWER_CONSUMPTION="+this.powerConsumption
               +", WEIGHT="+this.weight
               +", CAPACITY="+this.capacity
               +", DEPTH="+this.depth
               +", HEIGHT="+this.height
               +", WIDTH="+this.width; 
    }
}
