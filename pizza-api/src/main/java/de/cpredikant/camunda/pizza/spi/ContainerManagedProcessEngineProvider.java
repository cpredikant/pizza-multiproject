package de.cpredikant.camunda.pizza.spi;

import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.ProcessEngineService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;

import java.util.Set;

public class ContainerManagedProcessEngineProvider implements ProcessEngineProvider {

  @Override
  public ProcessEngine getDefaultProcessEngine() {
    ProcessEngine defaultProcessEngine = BpmPlatform.getDefaultProcessEngine();
    if(defaultProcessEngine != null) {
      return defaultProcessEngine;
    } else {
      return ProcessEngines.getDefaultProcessEngine(false);
    }
  }

  @Override
  public ProcessEngine getProcessEngine(String name) {
    return ProcessEngines.getProcessEngine(name);
  }

  @Override
  public Set<String> getProcessEngineNames() {
    return ProcessEngines.getProcessEngines().keySet();
  }

}
