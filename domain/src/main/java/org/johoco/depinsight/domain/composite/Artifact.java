package org.johoco.depinsight.domain.composite;

import java.util.List;
import java.util.Map;

import org.johoco.depinsight.domain.Entity;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;

import com.arangodb.springframework.annotation.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@Document("artifacts")
public class Artifact extends Entity<ArtifactKey> {
	private Artifact parentArtifact;
	private Artifact managingByArtifact;

	private String name;
	private String description;
	private String url;
	private String inceptionYear;
//	private Organization organization;
//	private List<License> licenses;
//	private List<Developer> developers;
//	private List<Contributor> contributors;
//	private List<MailingLists> mailingLists;
//	private Prerequisites prerequisites;
	private List<String> modules;
//	private Scm scm;
//	private IssueManagement issueManagement;
//	private CiManagement ciManagement;
//	private DistributionManagement distributionManagement;
//	private List<DependencyManagementDTO> dependencyManagement;
//	private List<DependencyDTO> dependencies;
	private Map<String, String> properties;
//	private List<Repository> repositories;
//	private List<Repository> pluginRepositories;
//	private Build build;
	// reports element per XSD <b>Deprecated</b>. Now ignored by Maven.
//	private Reporting reporting;
//	private List<Profile> profiles;

	public Artifact(ArtifactKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "artifacts";
	}

}
