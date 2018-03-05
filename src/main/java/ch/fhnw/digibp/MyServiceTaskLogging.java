package ch.fhnw.digibp;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
//do some logging for reporting
//maybe we can work with that: https://docs.camunda.org/manual/7.8/user-guide/process-engine/history/#user-operation-log 
public class MyServiceTaskLogging implements JavaDelegate {

  private final static Logger LOGGER = Logger.getLogger("TICKETLOGGING");

  public void execute(DelegateExecution execution) throws Exception {
    LOGGER.info("Processing request by '" + execution.getVariable("customerId") + "'...");
  }

}