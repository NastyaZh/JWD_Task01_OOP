package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

public class Main {

	public static void main(String[] args) {
            
		Appliance appliance;
                
		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//////////////////////////////////////////////////////////////////

		Criteria<Oven> criteriaOven = new Criteria<Oven>();
                criteriaOven.setApplianceType("Oven");
                criteriaOven.add(Oven.WEIGHT, 10);                
		criteriaOven.add(Oven.WIDTH, 59.5);
                criteriaOven.add(Oven.CAPACITY, 32);

		appliance = service.find(criteriaOven);            

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		criteriaOven = new Criteria<Oven>();
                criteriaOven.setApplianceType("Oven");
		criteriaOven.add(Oven.HEIGHT, 200);
		criteriaOven.add(Oven.DEPTH, 300);

		appliance = service.find(criteriaOven);

		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////
		
		Criteria<TabletPC> criteriaTabletPC = new Criteria<TabletPC>();
                criteriaTabletPC.setApplianceType("TabletPC");
		criteriaTabletPC.add(TabletPC.COLOR, "BLUE");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM, 4);

		appliance = service.find(criteriaTabletPC);

		PrintApplianceInfo.print(appliance);
                
                
                
                criteriaTabletPC = new Criteria<TabletPC>();
                criteriaTabletPC.setApplianceType("TabletPC");
		criteriaTabletPC.add(TabletPC.MEMORY_ROM, 8000);

		appliance = service.find(criteriaTabletPC);

		PrintApplianceInfo.print(appliance);
                
                
                Criteria<Speakers> criteriaSpeakers = new Criteria<Speakers>();
                criteriaSpeakers.setApplianceType("Speakers");
		criteriaSpeakers.add(Speakers.FREQUENCY_RANGE, "2-4");

		appliance = service.find(criteriaSpeakers);

		PrintApplianceInfo.print(appliance);

	}

}
