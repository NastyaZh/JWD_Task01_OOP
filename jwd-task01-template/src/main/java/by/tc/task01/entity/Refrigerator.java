package by.tc.task01.entity;

import java.io.Serializable;

public class Refrigerator extends Appliance implements Serializable{
    public Refrigerator(){}
    
    public Refrigerator(int powerConsumption,int weight,int freezerCapacity,
            double overallCapacity,int height,int width){
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height; 
        this.width = width;
    }
    
    private int powerConsumption;
    private int weight;
    private int freezerCapacity;
    private double overallCapacity;
    private int height;
    private int width;
    
    public int getPowerConsumption(){
        return powerConsumption;
    }
    public int getweight(){
        return weight;
    }
    public int getFreezerCapacity(){
        return freezerCapacity;
    }
    public double getOverallCapacity(){
        return overallCapacity;
    }
    public int getHeight(){
        return height;
    }
    public int getWidth(){
        return width;
    }
    
    public void setPowerConsumption(int powerConsumption){
        this.powerConsumption = powerConsumption;
    }
    public void setWeight(int weight){
        this.weight = weight;
    }
    public void setFreezerCapacity(int freezerCapacity){
        this.freezerCapacity = freezerCapacity;
    }
    public void setOverallCapacity(double overallCapacity){
        this.overallCapacity = overallCapacity;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public void setWidth(int width){
        this.width = width;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(null == obj || getClass() != obj.getClass()){
            return false;
        }
        Refrigerator refrigerator = (Refrigerator)obj;
        return !(powerConsumption != refrigerator.powerConsumption ||
                weight != refrigerator.weight ||
                freezerCapacity != refrigerator.freezerCapacity ||
                overallCapacity != refrigerator.overallCapacity ||
                height != refrigerator.height ||
                width != refrigerator.width);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        int prime = 67;
        hash = prime * hash + this.powerConsumption;
        hash = prime * hash + this.weight;
        hash = prime * hash + this.freezerCapacity;
        hash = prime * hash + (int) 
                (Double.doubleToLongBits(this.overallCapacity) ^
                (Double.doubleToLongBits(this.overallCapacity) >>> 32));
        hash = prime * hash + this.height;
        hash = prime * hash + this.width;
        return hash;
    }
    
    @Override
    public String toString(){
       return "Refrigerator :POWER_CONSUMPTION="+this.powerConsumption
               +", WEIGHT="+this.weight
               +", FREEZER_CAPACITY="+this.freezerCapacity
               +", OVERALL_CAPACITY="+this.overallCapacity
               +", HEIGHT="+this.height
               +", WIDTH="+this.width; 
    }
}
