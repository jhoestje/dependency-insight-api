package org.johoco.depinsight.domain.composite;

import java.util.List;
import java.util.Map;

import org.johoco.depinsight.domain.CiManagement;
import org.johoco.depinsight.domain.Contributor;
import org.johoco.depinsight.domain.Developer;
import org.johoco.depinsight.domain.DistributionManagement;
import org.johoco.depinsight.domain.Entity;
import org.johoco.depinsight.domain.IssueManagement;
import org.johoco.depinsight.domain.License;
import org.johoco.depinsight.domain.MailingList;
import org.johoco.depinsight.domain.Organization;
import org.johoco.depinsight.domain.Prerequisite;
import org.johoco.depinsight.domain.Repository;
import org.johoco.depinsight.domain.Scm;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;
import org.johoco.depinsight.domain.relationship.OfContributor;
import org.johoco.depinsight.domain.relationship.OfDeveloper;
import org.johoco.depinsight.domain.relationship.OfLicense;
import org.johoco.depinsight.domain.relationship.OfOrganization;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * @author John Hoestje
 *
 */
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

	@Relations(edges = OfOrganization.class, lazy = false)
	private Organization organization;

	@Relations(edges = OfLicense.class, lazy = false)
	private List<License> licenses;

	@Relations(edges = OfDeveloper.class, lazy = false)
	private List<Developer> developers;

	@Relations(edges = OfContributor.class, lazy = false)
	private List<Contributor> contributors;

	private List<MailingList> mailingLists;
	private Prerequisite prerequisites;
	private List<String> modules;
	private Scm scm;
	private IssueManagement issueManagement;
	private CiManagement ciManagement;
	private DistributionManagement distributionManagement;
	private List<DependencyManagement> dependencyManagement;
	private List<Dependency> dependencies;
	private Map<String, String> properties;
	private List<Repository> repositories;
	private List<Repository> pluginRepositories;
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
