package by.tc.task01.dao.command.impl;

import static by.tc.task01.dao.command.Parser.*;

import by.tc.task01.dao.command.ExecutorAppliance;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.Speakers;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import java.util.Map;
/**
 *
 * @author Nastya
 */
public class SpeakersExecutor implements ExecutorAppliance{
    @Override
    public <E>Appliance createAppliance(Criteria<E> criteria) {
        Speakers speakers  = new Speakers();       
        if(criteria.getCriteria().get(SearchCriteria.Speakers.POWER_CONSUMPTION)!= null){
            speakers.setPowerConsumption(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Speakers.POWER_CONSUMPTION).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS)!= null){
            speakers.setNumberOfSpeakers(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS).toString()));
        }
        if(criteria.getCriteria().get(SearchCriteria.Speakers.FREQUENCY_RANGE)!= null){
            speakers.setFrequencyRange(criteria.getCriteria().get(SearchCriteria.Speakers.FREQUENCY_RANGE).toString());
        }
        if(criteria.getCriteria().get(SearchCriteria.Speakers.CORD_LENGTH)!= null){
            speakers.setCordLength(Integer.parseInt
        (criteria.getCriteria().get(SearchCriteria.Speakers.CORD_LENGTH).toString()));
        }
        return speakers;
    }
    @Override
    public <E> boolean criteriaValidator(Criteria<E> criteria) {
        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
            if (entry.getValue() == null) {
                return false;
            }
            String nameKey = entry.getKey().toString();
            if (nameKey.equals("POWER_CONSUMPTION")
                    || nameKey.equals("NUMBER_OF_SPEAKERS")
                    || nameKey.equals("CORD_LENGTH")) {
                if (!tryParseInteger(entry.getValue().toString())) {
                    return false;
                }
            }
        }
        return true;
    }
}
