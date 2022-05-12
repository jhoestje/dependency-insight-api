package org.johoco.depinsight;

import org.johoco.depinsight.web.config.WebConfig;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
@Import(WebConfig.class)
//@EnableConfigurationProperties(CustomProps.class)
public class DependencyInsightAppApplication {

	// private final static Logger log = LoggerFactory.getLogger(DependencyInsightAppApplication.class);

	// this load a little later than below but could still work
	@Autowired
	private void contributeToPropertySources(ConfigurableEnvironment env) {
		// env.addFirst(propertySource);

	}

	public static void main(String[] args) {
//		System.out.println(appConfig.);
//		SpringApplication app = new SpringApplication(DependencyInsightAppApplication.class);
//		app.run();

		new SpringApplicationBuilder().sources(DependencyInsightAppApplication.class)
				.initializers(new ApplicationContextInitializer<ConfigurableApplicationContext>() {
					// good to register the properties earliest as possible; which is here before
					// context load
					// if we want to register a property source in specific location
					@Override
					public void initialize(ConfigurableApplicationContext applicationContext) {
		//				MutablePropertySources propertySources = applicationContext.getEnvironment()
	//							.getPropertySources();
//						propertySources.addFirst(propertySource);
					}
				}).run(args);
	}

}
