package ch.fhnw.digibp;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.impl.util.json.JSONObject;
import org.camunda.connect.Connectors;
import org.camunda.connect.httpclient.HttpConnector;
import org.camunda.connect.httpclient.HttpRequest;

//do some logging for reporting
//maybe we can work with that: https://docs.camunda.org/manual/7.8/user-guide/process-engine/history/#user-operation-log 
public class SendNotSupportedEmail implements JavaDelegate {

	private final static Logger LOGGER = Logger.getLogger("EMAIL");

	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("I will now send an e-mail to '" + execution.getVariable("emailAddress") + "' concerning "
				+ execution.getVariable("AffectedApplication"));

		HttpConnector http = Connectors.getConnector(HttpConnector.ID);
		HttpRequest request = http.createRequest();
		request.setRequestParameter("method", "POST");
		request.setRequestParameter("url", "https://hooks.zapier.com/hooks/catch/3017214/katznf/");

		request.header("Content-Type", "application/json");

		String email = (String) execution.getVariable("customerMail");

		String msg = "Dear " + execution.getVariable("customerName") + "\n\n"
				+ "This is an automated message to notify you, that your ticket request is not supported. \n\n" + "\nSummary: "
				+ execution.getVariable("summary") + "\nDescription: " + execution.getVariable("description")
				+ "\nTicket Open Date: " + execution.getVariable("ticketOpenDate") + "\nTicket Status: "
				+ execution.getVariable("ticketStatus") + "\nTicket Origin: " + execution.getVariable("ticketOrigin")
				+ "\nImpact: " + execution.getVariable("impact") + "\nUrgency: " + execution.getVariable("urgency")
				+ "\nPriority: " + execution.getVariable("priority") + "\nAffected Application: "
				+ execution.getVariable("affectedApplication") +

				"\nSystem ID: " + execution.getVariable("systemID") + "\nStep by Step Instruction: "
				+ execution.getVariable("stepByStep") + "\nCustomer Name: " + execution.getVariable("customerName")
				+ "\nCustomer Mail: " + execution.getVariable("customerMail") + "\nCustomer Phone: "
				+ execution.getVariable("customerPhone") +

				"\nReal Incident: " + execution.getVariable("isReallyIncident") + "\nSupported: "
				+ execution.getVariable("incidentSupported") +

				"\n\n Thank you for your understanding.\n\nBest Regards, \nSäntis Group";

		LOGGER.info("Message: " + msg);

		String json = new JSONObject().put("email", email).put("msg", msg).put("title", "Incident Notification")
				.toString();

		request.setRequestParameter("payload", json);

		request.execute();

	}

}