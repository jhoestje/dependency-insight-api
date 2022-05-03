package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.Version;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.StartNode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PartOfArtifactId extends GraphData {
	
	@Id
	@GeneratedValue
	private Long relationshipId;
	
	@StartNode
	private Version version;
	
	@EndNode
	private ArtifactId artifactId;
}
