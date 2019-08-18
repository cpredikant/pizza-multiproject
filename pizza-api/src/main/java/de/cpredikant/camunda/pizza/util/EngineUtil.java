package de.cpredikant.camunda.pizza.util;

import de.cpredikant.camunda.pizza.spi.ProcessEngineProvider;
import org.camunda.bpm.engine.ProcessEngine;

import java.util.Iterator;
import java.util.ServiceLoader;

public final class EngineUtil {


    public static ProcessEngine lookupProcessEngine(String engineName) {

        ServiceLoader<ProcessEngineProvider> serviceLoader = ServiceLoader.load(ProcessEngineProvider.class);
        Iterator<ProcessEngineProvider> iterator = serviceLoader.iterator();

        if(iterator.hasNext()) {
            ProcessEngineProvider provider = iterator.next();
            if (engineName == null) {
                return provider.getDefaultProcessEngine();
            } else {
                return provider.getProcessEngine(engineName);
            }
        } else {
            throw new RuntimeException("Es ging etwas schrecklich schief!");
        }
    }
}
