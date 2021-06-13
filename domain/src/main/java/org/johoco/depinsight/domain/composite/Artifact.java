package org.johoco.depinsight.domain.composite;

import org.johoco.depinsight.domain.Entity;
import org.johoco.depinsight.domain.composite.key.ArtifactKey;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper = true)
@Getter
@Document("artifacts")
public class Artifact extends Entity<ArtifactKey> {
	private Artifact parentArtifact;
	private Artifact managingByArtifact;

	public Artifact(ArtifactKey key) {
		super(key);
	}

	public static String getName() {
		return "artifacts";
	}
}
