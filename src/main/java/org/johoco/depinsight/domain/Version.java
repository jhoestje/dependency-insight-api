package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.VersionKey;
import org.johoco.depinsight.domain.relationship.OfArtifactId;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper = true)
@Document("versions")
public class Version extends Entity<VersionKey> {

//	private String value;

	@Relations(edges = OfArtifactId.class, lazy = false)
	private ArtifactId artifactId;

	public Version(VersionKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "versions";
	}

	public @NonNull String getValue() {
		return getKey().getVersionValue();
	}

}
