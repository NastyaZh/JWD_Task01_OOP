package by.tc.task01.dao.command.impl;

import static by.tc.task01.dao.command.Parser.*;

import by.tc.task01.dao.command.ExecutorAppliance;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.VacuumCleaner;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import java.util.Map;

/**
 *
 * @author Nastya
 */
public class VacuumCleanerExecutor implements ExecutorAppliance{
    @Override
    public <E>Appliance createAppliance(Criteria<E> criteria) {
        VacuumCleaner vacuumCleaner = new VacuumCleaner();
        
        if(criteria.getCriteria().get(SearchCriteria.VacuumCleaner.FILTER_TYPE)!= null){
            vacuumCleaner.setFilterType(criteria.getCriteria().get(SearchCriteria.VacuumCleaner.FILTER_TYPE).toString());
        }
        if(criteria.getCriteria().get(SearchCriteria.VacuumCleaner.BAG_TYPE)!= null){
            vacuumCleaner.setBagType(criteria.getCriteria().get(SearchCriteria.VacuumCleaner.BAG_TYPE).toString());
        }
        if(criteria.getCriteria().get(SearchCriteria.VacuumCleaner.WAND_TYPE)!= null){
            vacuumCleaner.setWandType(criteria.getCriteria().get(SearchCriteria.VacuumCleaner.WAND_TYPE).toString());
        }
        if(criteria.getCriteria().get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION)!= null){
            vacuumCleaner.setPowerConsumption(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION)!= null){
            vacuumCleaner.setMotorSpeedRegulation(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH)!= null){
            vacuumCleaner.setCleaningWidth(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.VacuumCleaner.CLEANING_WIDTH).toString()));
        }
        
        return vacuumCleaner;
    }
    @Override
    public <E> boolean criteriaValidator(Criteria<E> criteria) {
        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
            if (entry.getValue() == null) {
                return false;
            }
            String nameKey = entry.getKey().toString();
            if (nameKey.equals("POWER_CONSUMPTION") 
                    || nameKey.equals("MOTOR_SPEED_REGULATION")
                    || nameKey.equals("CLEANING_WIDTH")) {
                if (!tryParseInteger(entry.getValue().toString())) {
                    return false;
                }
            }
        }
        return true;
    }
}
