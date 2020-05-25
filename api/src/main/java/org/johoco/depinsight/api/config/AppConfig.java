package org.johoco.depinsight.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.ToString;

@ToString(includeFieldNames=true)
@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
//link to repo config
public class AppConfig {
	private String name;
	private String environment;
}
