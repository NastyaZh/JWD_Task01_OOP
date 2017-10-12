package by.tc.task01.dao.command;

import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;

/**
 *
 * @author Nastya
 */
public interface CreateAppliance {
    <E>Appliance createAppliance(Criteria <E> criteria);
}
