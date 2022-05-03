package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.ArtifactKey;

import lombok.Data;

@Data
// @NodeEntity
//@RelationshipProperties
public class Artifact extends Entity<ArtifactKey> {
	private Artifact parentArtifact;
	private Artifact managingByArtifact;
}
