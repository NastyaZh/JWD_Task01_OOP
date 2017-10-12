package by.tc.task01.entity;

import java.io.Serializable;

public class Speakers extends Appliance implements Serializable{
    public Speakers(){}
    
    public Speakers(int powerConsumption,int numberOfSpeakers,
            String frequencyRange,int cordLength){
        this.powerConsumption = powerConsumption;
        this.numberOfSpeakers = numberOfSpeakers;
        this.frequencyRange = frequencyRange;
        this.cordLength = cordLength;
    }
    
    private int powerConsumption;
    private int numberOfSpeakers;
    private String frequencyRange;
    private int cordLength;
    
    public int getPowerConsumption(){
        return powerConsumption;
    }
    public int getNumberOfSpeakers(){
        return numberOfSpeakers;
    }
    public String getFrequencyRange(){
        return frequencyRange;
    }
    public int getCordLength(){
        return cordLength;
    }
    
    public void setPowerConsumption(int powerConsumption){
        this.powerConsumption = powerConsumption;
    }
    public void setNumberOfSpeakers(int numberOfSpeakers){
        this.numberOfSpeakers = numberOfSpeakers;
    }
    public void setFrequencyRange(String frequencyRange){
        this.frequencyRange = frequencyRange;
    }
    public void setCordLength(int cordLength){
        this.cordLength = cordLength;
    }
    
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(null == obj || getClass() != obj.getClass()){
            return false;
        }
        Speakers speakers = (Speakers)obj;
        if(powerConsumption != speakers.powerConsumption ||
           numberOfSpeakers != speakers.numberOfSpeakers ||
           cordLength != speakers.cordLength){
            return false;
        }
        if(null == frequencyRange){
            return (frequencyRange == speakers.frequencyRange);
        }
        else{
            if(!frequencyRange.equals(speakers.frequencyRange)){
                return false;
            }
        }      
        return true;
    }
    
    @Override
    public int hashCode(){
        int hash = 3;
        int prime = 28;
        hash = prime * hash + this.powerConsumption;
        hash = prime * hash + this.numberOfSpeakers;
        hash = prime * hash + this.cordLength;
        hash = prime * hash +
                (frequencyRange != null ? this.frequencyRange.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString(){
       return "Speakers :POWER_CONSUMPTION="+this.powerConsumption
               +", NUMBER_OF_SPEAKERS="+this.numberOfSpeakers
               +", FREQUENCY_RANGE="+this.frequencyRange
               +", CORD_LENGTH="+this.cordLength; 
    }
}
