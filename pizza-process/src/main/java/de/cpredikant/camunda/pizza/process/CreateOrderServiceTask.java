package de.cpredikant.camunda.pizza.process;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Named;

@Named
@Stateless
public class CreateOrderServiceTask implements JavaDelegate {

    private final static Logger LOGGER = LoggerFactory.getLogger(CreateOrderServiceTask.class);

    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Create Order {}", delegateExecution.getProcessInstanceId());
    }
}
