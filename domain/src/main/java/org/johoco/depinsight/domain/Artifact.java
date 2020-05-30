package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.ArtifactKey;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;

@Data
@NodeEntity
public class Artifact extends Entity<ArtifactKey> {

}
