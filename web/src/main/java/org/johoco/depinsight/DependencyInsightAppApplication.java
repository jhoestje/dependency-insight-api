package org.johoco.depinsight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DependencyInsightAppApplication {

	private final static Logger log = LoggerFactory.getLogger(DependencyInsightAppApplication.class);
	
	public static void main(String[] args) {
//		System.out.println(appConfig.);
		SpringApplication app = new SpringApplication(DependencyInsightAppApplication.class);
		app.run();
	}

}
