package de.cpredikant.camunda.pizza.spi;

import org.camunda.bpm.engine.ProcessEngine;

import java.util.Set;

public interface ProcessEngineProvider {

    ProcessEngine getDefaultProcessEngine();

    ProcessEngine getProcessEngine(String name);

    Set<String> getProcessEngineNames();

}
