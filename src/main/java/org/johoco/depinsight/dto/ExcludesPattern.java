package org.johoco.depinsight.dto;

import lombok.Data;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 * 
 * May be merged with Excludes??
 * 
 * @author John Hoestje
 *
 */
@Data
public class ExcludesPattern {
	private String groupId;
	private String artifactId;
}
