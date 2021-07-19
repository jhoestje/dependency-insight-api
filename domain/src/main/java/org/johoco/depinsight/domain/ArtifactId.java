package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.ArtifactIdKey;
import org.johoco.depinsight.domain.relationship.OfGroupId;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document("artifactIds")
public class ArtifactId extends Entity<ArtifactIdKey> {

	@Relations(edges = OfGroupId.class, lazy = false)
	private GroupId groupId;

	public ArtifactId(ArtifactIdKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "artifactIds";
	}

	public String getValue() {
		if (this.getKey() != null) {
			return this.getKey().getArtifactIdValue();
		}
		return null;
	}
}
