package by.tc.task01.dao.command.impl;

import static by.tc.task01.dao.command.Parser.*;

import by.tc.task01.dao.command.ExecutorAppliance;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Oven;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import java.util.Map;

/**
 *
 * @author Nastya
 */
public class OvenExecutor implements ExecutorAppliance{
    
    @Override
    public <E>Appliance createAppliance(Criteria <E> criteria) {
        Oven oven = new Oven();
        if(criteria.getCriteria().get(SearchCriteria.Oven.POWER_CONSUMPTION)!= null){
            oven.setPowerConsumption(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Oven.POWER_CONSUMPTION).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Oven.WEIGHT)!= null){
            oven.setWeight(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Oven.WEIGHT).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Oven.CAPACITY)!= null){
            oven.setCapacity(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Oven.CAPACITY).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Oven.DEPTH)!= null){
            oven.setDepth(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Oven.DEPTH).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Oven.HEIGHT)!= null){
            oven.setHeight(Double.parseDouble
        (criteria.getCriteria().get(SearchCriteria.Oven.HEIGHT).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Oven.WIDTH)!= null){
            oven.setWidth(Double.parseDouble
        (criteria.getCriteria().get(SearchCriteria.Oven.WIDTH).toString()));
        }
        return oven;
    }
    @Override
    public <E> boolean criteriaValidator(Criteria<E> criteria) {
        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
            if (entry.getValue() == null) {
                return false;
            }
            String nameKey = entry.getKey().toString();
            if (nameKey.equals("HEIGHT") || nameKey.equals("WIDTH")) {
                if (!tryParseDouble(entry.getValue().toString())) {
                    return false;
                }
            } else if (nameKey.equals("POWER_CONSUMPTION")
                    || nameKey.equals("WEIGHT") || nameKey.equals("CAPACITY") 
                    || nameKey.equals("DEPTH")) {
                if (!tryParseInteger(entry.getValue().toString())) {
                    return false;
                }
            }
        }
        return true;
    }
}
