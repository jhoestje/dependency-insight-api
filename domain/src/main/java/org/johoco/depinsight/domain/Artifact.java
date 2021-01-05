package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.ArtifactKey;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;

import lombok.Data;

@Data
// @NodeEntity
@RelationshipProperties
public class Artifact extends Entity<ArtifactKey> {
	private Artifact parentArtifact;
	private Artifact managingByArtifact;
}
