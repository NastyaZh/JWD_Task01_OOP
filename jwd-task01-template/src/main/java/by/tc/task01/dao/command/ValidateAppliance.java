package by.tc.task01.dao.command;

import by.tc.task01.entity.criteria.Criteria;

/**
 *
 * @author Nastya
 */
public interface ValidateAppliance {
    <E> boolean criteriaValidator(Criteria<E> criteria);
}
