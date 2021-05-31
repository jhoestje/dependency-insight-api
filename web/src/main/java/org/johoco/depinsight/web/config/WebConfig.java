package org.johoco.depinsight.web.config;

import org.johoco.depinsight.api.config.ApiConfig;
import org.johoco.depinsight.repository.config.RepositoryConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "org.johoco.depinsight.web")
@EnableConfigurationProperties(WebProperties.class)
@Import({ ApiConfig.class, RepositoryConfig.class })
//link to repo config
public class WebConfig {

}
