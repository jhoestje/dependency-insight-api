package org.johoco.depinsight.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 *
 * @author John Hoestje
 */
@Data
public class Profile {
	private String id;
	private Activation activation;
	private BuildBase build;
	private List<String> modules;
	private DistributionManagement distributionManagement;
	// property template: <code>&lt;name&gt;value&lt;/name&gt;</code>
	private Map<String, String> properties;
	private DependencyManagementDTO dependencyManagement;
	private List<DependencyDTO> dependency;
	private List<Repository> repositories;
	private List<Repository> pluginRepositories;
	// reports element per XSD <b>Deprecated</b>. Now ignored by Maven.
	private Reporting reporting;
}
