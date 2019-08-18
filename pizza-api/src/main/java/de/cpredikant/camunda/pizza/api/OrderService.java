package de.cpredikant.camunda.pizza.api;

import de.cpredikant.camunda.pizza.util.EngineUtil;
import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/order")
@Produces({"application/json"})
@Consumes({"application/json"})
public class OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);


    @POST
    @Path("/approve")
    public void approveOrders() {

        ProcessEngine processEngine = EngineUtil.lookupProcessEngine(null);

        List<Task> tasks = processEngine.getTaskService().createTaskQuery().taskName("Approve Order").list();

        for (Task task : tasks){
            processEngine.getTaskService().complete(task.getId());
            LOGGER.info("Complete Task {}", task.getId());
        }
    }


}
