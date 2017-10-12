package by.tc.task01.main;

import by.tc.task01.entity.Appliance;

public class PrintApplianceInfo {
	
	public static void print(Appliance appliance) {
            if(null != appliance){
                System.out.println(appliance.toString());
            }
            else{
                System.out.println("Something wrong...");
            }
		
	}
}
