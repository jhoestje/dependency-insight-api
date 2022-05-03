package org.johoco.depinsight.domain;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Maybe just store this on Artifact.
 * 
 * @author John Hoestje
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document("deploymentRepositories")
public class DeploymentRepository extends GraphData {

	private String uniqueVersion; // boolean
	private RepositoryPolicy releases;
	private RepositoryPolicy snapshots;
	private String id;
	private String name;
	private String url;
	private String layout;

	public static String getDocumentName() {
		return "deploymentRepositories";
	}

}
