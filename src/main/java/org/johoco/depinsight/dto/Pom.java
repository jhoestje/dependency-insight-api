package org.johoco.depinsight.dto;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Per https://maven.apache.org/xsd/maven-4.0.0.xsd
 * 
 * @author John Hoestje
 *
 */
@Data
@NoArgsConstructor
//@Builder
public class Pom {
	// TODO: add language?

	private String modelVersion;
	private Gav parent;

	private String groupId;
	private String artifactId;
	private String version;
	private String packaging;
	private String name;
	private String description;
	private String url;
	private String inceptionYear;
	private Organization organization;
	private List<License> licenses;
	private List<Developer> developers;
	private List<Contributor> contributors;
	private List<MailingLists> mailingLists;
	private Prerequisites prerequisites;
	private List<String> modules;
	private Scm scm;
	private IssueManagement issueManagement;
	private CiManagement ciManagement;
	private DistributionManagement distributionManagement;
	private List<DependencyManagementDTO> dependencyManagement;
	private List<DependencyDTO> dependencies;
	private Map<String, String> properties;
	private List<Repository> repositories;
	private List<Repository> pluginRepositories;
	private Build build;
	// reports element per XSD <b>Deprecated</b>. Now ignored by Maven.
	private Reporting reporting;
	private List<Profile> profiles;

}
