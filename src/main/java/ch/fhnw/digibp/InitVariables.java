package ch.fhnw.digibp;

import java.util.logging.Logger;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
//do some logging for reporting

//maybe we can work with that: https://docs.camunda.org/manual/7.8/user-guide/process-engine/history/#user-operation-log 
public class InitVariables implements JavaDelegate {

	private final static Logger LOGGER = Logger.getLogger("InitVars started");
	public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

	private DelegateExecution execution;

	private void setIfNull(String varName, String value) {

		LOGGER.info("Check variable content of '" + varName + "' defined as '" + execution.getVariable(varName) + "'");

		Object var = execution.getVariable(varName);
		if (var == null) {
			execution.setVariable(varName, value);
			LOGGER.info("set to '" + varName + "' to '" + value + "'");
		}
	}

	private void setVar(String varName, String value) {

		execution.setVariable(varName, value);
		LOGGER.info("set to '" + varName + "' to '" + value + "'");
	}

	public static String now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}

	public void execute(DelegateExecution execution) throws Exception {

		this.execution = execution;

		setIfNull("impact", "3");
		setIfNull("urgency", "3");
		setIfNull("priority", "3");
		setIfNull("affectedApplication", "undefined");
		setIfNull("summary", "");
		setIfNull("description", "");
		setIfNull("systemID", "");
		setIfNull("stepByStep", "");
		setIfNull("customerName", "");
		setIfNull("customerMail", "");
		setIfNull("customerPhone", "");

		setVar("ticketOpenDate", now());
		setVar("ticketStatus", "NEW");
		setVar("ticketOrigin", "MANUAL");

		setIfNull("isReallyIncident", "");
		setIfNull("incidentSupported", "");
		setIfNull("isCritical", "false");

	}

}