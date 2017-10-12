package by.tc.task01.entity;

import java.io.Serializable;

public class VacuumCleaner extends Appliance implements Serializable{
    public VacuumCleaner(){}
    public VacuumCleaner(int powerConsumption,String filterType,String bagType,
            String wandType,int motorSpeedRegulation,int cleaningWidth){
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }
    
    private int powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private int motorSpeedRegulation;
    private int cleaningWidth;
    
    public int getPowerConsumption(){
        return powerConsumption;
    }
    public String getFilterType(){
        return filterType;
    }
    public String getBagType(){
        return bagType;
    }
    public String getWandType(){
        return wandType;
    }
    public int getMotorSpeedRegulation(){
        return motorSpeedRegulation;
    }
    public int getCleaningWidth(){
        return cleaningWidth;
    }
    
    public void setPowerConsumption(int powerConsumption){
        this.powerConsumption = powerConsumption;
    }
    public void setFilterType(String filterType){
        this.filterType = filterType;
    }
    public void setBagType(String bagType){
        this.bagType = bagType;
    }
    public void setWandType(String wandType){
        this.wandType = wandType;
    }
    public void setMotorSpeedRegulation(int motorSpeedRegulation){
        this.motorSpeedRegulation = motorSpeedRegulation;
    }
    public void setCleaningWidth(int cleaningWidth){
        this.cleaningWidth = cleaningWidth;
    }
    
    @Override
    public boolean equals (Object obj){
        if(this == obj){
            return true;
        }
        if (null == obj || getClass() != obj.getClass()){
            return false;
        }

        VacuumCleaner vacuumCleaner = (VacuumCleaner)obj;
        
        if((powerConsumption != vacuumCleaner.powerConsumption) ||
           (motorSpeedRegulation != vacuumCleaner.motorSpeedRegulation)||
           (cleaningWidth != vacuumCleaner.cleaningWidth)){
            return false;
        }
        
        if(null == filterType){
            return (filterType == vacuumCleaner.filterType);
        }
        else{
            if(!filterType.equals(vacuumCleaner.filterType)){
                return false;
            }
        }
        
        if(null == bagType){
            return (bagType == vacuumCleaner.bagType);
        }
        else{
            if(!bagType.equals(vacuumCleaner.bagType)){
                return false;
            }
        }
        if(null == wandType){
            return (wandType == vacuumCleaner.wandType);
        }
        else{
            if(!wandType.equals(vacuumCleaner.wandType)){
                return false;
            }
        }
        
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        int prime = 17;
        hash = prime * hash + this.powerConsumption;
        hash = prime * hash + 
                (this.filterType != null ? this.filterType.hashCode() : 0);
        hash = prime * hash + 
                (this.bagType != null ? this.bagType.hashCode() : 0);
        hash = prime * hash + 
                (this.wandType != null ? this.wandType.hashCode() : 0);
        hash = prime * hash + this.motorSpeedRegulation;
        hash = prime * hash + this.cleaningWidth;
        return hash;
    }
    @Override
    public String toString(){
       return "VacuumCleaner :POWER_CONSUMPTION="+this.powerConsumption
               +", FILTER_TYPE="+this.filterType
               +", BAG_TYPE="+this.bagType
               +", WAND_TYPE="+this.wandType
               +", MOTOR_SPEED_REGULATION="+this.motorSpeedRegulation
               +", CLEANING_WIDTH="+this.cleaningWidth; 
    }
}
