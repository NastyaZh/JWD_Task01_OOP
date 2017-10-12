package by.tc.task01.dao.impl;

import by.tc.task01.dao.ApplianceDAO;
import by.tc.task01.dao.command.ApplianceDirector;
import by.tc.task01.entity.*;
import by.tc.task01.entity.criteria.Criteria;

import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO{
    @Override
    public <E> Appliance find(Criteria <E> criteria) {
        if(checkContains(criteria)){
            ApplianceDirector applianceDirector = new ApplianceDirector();
            return applianceDirector.getExecutorAppliance(criteria.getApplianceType()).createAppliance(criteria);
        }
        return null;
    }
    private <E> Boolean checkContains(Criteria <E> criteria){
        String request;
        FileWorker f = new FileWorker();
        for (Map.Entry<E, Object> entry : criteria.getCriteria().entrySet()) {
            request = entry.getKey() +"="+ entry.getValue();
            if(!f.readFromFile(criteria.getApplianceType(), request)){
                return false;
            }
        }
        return true;
    }
}