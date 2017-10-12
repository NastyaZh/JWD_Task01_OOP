package by.tc.task01.dao.command.impl;

import static by.tc.task01.dao.command.Parser.*;

import by.tc.task01.dao.command.ExecutorAppliance;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Refrigerator;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import java.util.Map;
/**
 *
 * @author Nastya
 */
public class RefrigeratorExecutor implements ExecutorAppliance{
    @Override
    public <E>Appliance createAppliance(Criteria <E> criteria) {
        
        Refrigerator refrigerator = new Refrigerator();
        if(criteria.getCriteria().get(SearchCriteria.Refrigerator.POWER_CONSUMPTION)!= null){
            refrigerator.setPowerConsumption(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Refrigerator.POWER_CONSUMPTION).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Refrigerator.WEIGHT)!= null){
            refrigerator.setWeight(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Refrigerator.WEIGHT).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Refrigerator.FREEZER_CAPACITY)!= null){
            refrigerator.setFreezerCapacity(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Refrigerator.FREEZER_CAPACITY).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Refrigerator.OVERALL_CAPACITY)!= null){
            refrigerator.setOverallCapacity(Double.parseDouble
        (criteria.getCriteria().get(SearchCriteria.Refrigerator.OVERALL_CAPACITY).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Refrigerator.HEIGHT)!= null){
            refrigerator.setHeight(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Refrigerator.HEIGHT).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Refrigerator.WIDTH)!= null){
            refrigerator.setWidth(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Refrigerator.WIDTH).toString()));
        }
        return refrigerator;
    }
    
    @Override
    public <E> boolean criteriaValidator(Criteria<E> criteria) {
        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
            if (entry.getValue() == null) {
                return false;
            }
            String nameKey = entry.getKey().toString();
            if (nameKey.equals("POWER_CONSUMPTION")
                    || nameKey.equals("WEIGHT")
                    || nameKey.equals("FREEZER_CAPACITY")
                    || nameKey.equals("HEIGHT")
                    || nameKey.equals("WIDTH")) {
                if (!tryParseInteger(entry.getValue().toString())) {
                    return false;
                }
            } else if (nameKey.equals("OVERALL_CAPACITY")) {
                if (!tryParseDouble(entry.getValue().toString())) {
                    return false;
                }
            }
        }
        return true;
    }
}
