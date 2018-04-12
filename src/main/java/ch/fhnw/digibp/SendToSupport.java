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
public class SendToSupportEmail implements JavaDelegate {

	private final static Logger LOGGER = Logger.getLogger("EMAIL");

	public void execute(DelegateExecution execution) throws Exception {
		LOGGER.info("I will now send an e-mail to '" + execution.getVariable("emailAddress") + "' concerning "
				+ execution.getVariable("AffectedApplication"));

		HttpConnector http = Connectors.getConnector(HttpConnector.ID);
		HttpRequest request = http.createRequest();
		request.setRequestParameter("method", "POST");
		request.setRequestParameter("url", "https://hooks.zapier.com/hooks/catch/3017214/katznf/");

		request.header("Content-Type", "application/json");

		String email = "saentisgroupincident@gmail.com"; // Add Support E-Mail here!

		String msg = "Dear Support"
				+ "This is an automated message with a support request for you.\n\n" + "\nSummary: "
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

				"\n Please contact the customer directly with the information we provided.\n\nBest Regards, Säntis Group";

		LOGGER.info("Message: " + msg);

		String json = new JSONObject().put("email", email).put("msg", msg).put("title", "New Support Request")
				.toString();

		request.setRequestParameter("payload", json);

		request.execute();

	}

}