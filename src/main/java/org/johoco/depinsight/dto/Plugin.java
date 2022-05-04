package org.johoco.depinsight.dto;

import java.util.List;

import lombok.Data;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 * 
 * @author John Hoestje
 *
 */
@Data
public class Plugin {
	private String groupId;
	private String artifactId;
	private String version;
	private String extensions;
	List<PluginExecution> executions;
	// aether
	List<DependencyDTO> dependencies;
	// goals element per XSD: <b>Deprecated</b>. Unused by Maven
	private String inherited;
	// configuration element per XSD: <xs:any minOccurs="0" maxOccurs="unbounded" processContents="skip"/>

}
