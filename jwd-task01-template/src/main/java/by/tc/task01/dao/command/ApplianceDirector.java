package by.tc.task01.dao.command;

import by.tc.task01.dao.command.impl.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nastya
 */
public class ApplianceDirector {
        private final Map<String, ExecutorAppliance> map = new HashMap<>();
    
    public ApplianceDirector() {
        map.put("Oven", new OvenExecutor());
	map.put("Laptop", new LaptopExecutor());
	map.put("Refrigerator", new RefrigeratorExecutor());
	map.put("Speakers", new SpeakersExecutor());
	map.put("TabletPC", new TabletPCExecutor());
	map.put("VacuumCleaner", new VacuumCleanerExecutor());
    }
    public ExecutorAppliance getExecutorAppliance(String typeName) {
		return map.get(typeName);
	}
}
