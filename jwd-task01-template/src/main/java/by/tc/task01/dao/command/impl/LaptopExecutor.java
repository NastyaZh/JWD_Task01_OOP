package by.tc.task01.dao.command.impl;
import static by.tc.task01.dao.command.Parser.*;

import by.tc.task01.dao.command.ExecutorAppliance;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Laptop;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import java.util.Map;

/**
 *
 * @author Nastya
 */
public class LaptopExecutor implements ExecutorAppliance{
    
    @Override
    public <E>Appliance createAppliance(Criteria <E> criteria) {
        Laptop laptop = new Laptop();
        if(criteria.getCriteria().get(SearchCriteria.Laptop.BATTERY_CAPACITY)!= null){
            laptop.setBatteryCapacity(Double.parseDouble
        (criteria.getCriteria().get(SearchCriteria.Laptop.BATTERY_CAPACITY).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Laptop.OS)!= null){
           laptop.setOS(criteria.getCriteria().get(SearchCriteria.Laptop.OS).toString());
        }
        if(criteria.getCriteria().get(SearchCriteria.Laptop.MEMORY_ROM)!= null){
            laptop.setMemoryROM(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Laptop.MEMORY_ROM).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Laptop.SYSTEM_MEMORY)!= null){
                laptop.setSystemMemory(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Laptop.SYSTEM_MEMORY).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Laptop.CPU)!= null){
            laptop.setCPU(Double.parseDouble
        (criteria.getCriteria().get(SearchCriteria.Laptop.CPU).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Laptop.DISPLAY_INCHS)!= null){
            laptop.setDisplayInchs(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Laptop.DISPLAY_INCHS).toString()));
        }
        return laptop;
	}
    
    @Override
    public <E> boolean criteriaValidator(Criteria<E> criteria) {
        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
            if (entry.getValue() == null) {
                return false;
            }
            String nameKey = entry.getKey().toString();
            if (nameKey.equals("SYSTEM_MEMORY") || nameKey.equals("MEMORY_ROM") 
                    || nameKey.equals("DISPLAY_INCHS")) {
                if (!tryParseInteger(entry.getValue().toString())) {
                    return false;
                }
            }else if (nameKey.equals("CPU") || nameKey.equals("BATTERY_CAPACITY")) {
                if (!tryParseDouble(entry.getValue().toString())) {
                    return false;
                }
            }
        }
        return true;
    }
}
