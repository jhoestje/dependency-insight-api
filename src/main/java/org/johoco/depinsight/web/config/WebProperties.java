package org.johoco.depinsight.web.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(includeFieldNames = true)
@Data
@NoArgsConstructor
@ConfigurationProperties
// to get new values from config server
//@RefreshScope
//link to repo properties
public class WebProperties {
	private String name;
	private String environment;
}
