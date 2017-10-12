package by.tc.task01.service.validation;

import by.tc.task01.dao.command.ApplianceDirector;
import by.tc.task01.dao.command.ValidateAppliance;
import by.tc.task01.entity.criteria.Criteria;

public class Validator {
	 
	public static <E> boolean criteriaValidator(Criteria<E> criteria) {
            if(criteria.getCriteria().isEmpty()){
                return false;
            }
            ApplianceDirector applianceDirector = new ApplianceDirector();
            ValidateAppliance appliance = applianceDirector.getExecutorAppliance(criteria.getApplianceType());
		return appliance.criteriaValidator(criteria);
	}
}
