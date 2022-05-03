package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.IssueManagementKey;

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
@Document("issueManagements")
public class IssueManagement extends Entity<IssueManagementKey> {

	private String system;

	public IssueManagement(final IssueManagementKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "issueManagements";
	}

}
