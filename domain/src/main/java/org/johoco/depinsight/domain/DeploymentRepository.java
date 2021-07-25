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
@Document("distributionManagements")
public class DeploymentRepository extends GraphData {

	private DeploymentRepository repository;
	private DeploymentRepository snapshotRepository;
	private Site site;
	private String downloadUrl;
	private Relocation relocation;
	private String status;

	public static String getDocumentName() {
		return "distributionManagements";
	}

}
