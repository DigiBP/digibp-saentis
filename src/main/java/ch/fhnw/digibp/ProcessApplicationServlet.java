package ch.fhnw.digibp;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineConfiguration;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@EnableProcessApplication
public class ProcessApplicationServlet extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ProcessApplicationServlet.class, args);
		
		//set history to full
		//ProcessEngine processEngine = ProcessEngineConfiguration
			//	  .createProcessEngineConfigurationFromResourceDefault()
				//  .setHistory(ProcessEngineConfiguration.HISTORY_FULL)
				  //.buildProcessEngine();
		
		
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ProcessApplicationServlet.class);
	}
}