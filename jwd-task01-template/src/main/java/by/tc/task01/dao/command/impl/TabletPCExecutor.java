package by.tc.task01.dao.command.impl;

import static by.tc.task01.dao.command.Parser.*;

import by.tc.task01.dao.command.ExecutorAppliance;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.TabletPC;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import java.util.Map;

/**
 *
 * @author Nastya
 */
public class TabletPCExecutor implements ExecutorAppliance{
    @Override
    public <E>Appliance createAppliance(Criteria<E> criteria) {
        int batteryCapacity = 0, displayInches = 0, memoryROM= 0 , flashMemoryCapacity = 0;
        String color = "";
        TabletPC tabletPC = new TabletPC();
        if(criteria.getCriteria().get(SearchCriteria.TabletPC.BATTERY_CAPACITY)!= null){
            tabletPC.setBatteryCapacity(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.TabletPC.BATTERY_CAPACITY).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.TabletPC.DISPLAY_INCHES)!= null){
            tabletPC.setDisplayInches(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.TabletPC.DISPLAY_INCHES).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.TabletPC.MEMORY_ROM)!= null){
            tabletPC.setMemoryROM(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.TabletPC.MEMORY_ROM).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY)!= null){
            tabletPC.setFlashMemoryCapacity(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.TabletPC.COLOR)!= null){
            tabletPC.setColor(criteria.getCriteria().get(SearchCriteria.TabletPC.COLOR).toString());
        }
        return tabletPC;
    }
    @Override
    public <E> boolean criteriaValidator(Criteria<E> criteria) {
        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
            if (entry.getValue() == null) {
                return false;
            }
            String nameKey = entry.getKey().toString();
            if (nameKey.equals("BATTERY_CAPACITY")
                    || nameKey.equals("DISPLAY_INCHES")
                    || nameKey.equals("MEMORY_ROM")
                    || nameKey.equals("FLASH_MEMORY_CAPACITY")) {
                if (!tryParseInteger(entry.getValue().toString())) {
                    return false;
                }
            }
        }
        return true;
    }
}
