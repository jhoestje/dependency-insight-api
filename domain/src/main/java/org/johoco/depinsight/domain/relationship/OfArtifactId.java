package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.Version;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode(callSuper = true)
@Edge("ofArtifactId")
public class OfArtifactId extends GraphData implements GraphEdge {

	@From
	@NonNull
	private Version groupId;

	@To
	@NonNull
	private ArtifactId language;

	public static String getName() {
		return "ofArtifactId";
	}

	public static String getFromName() {
		return Version.getName();
	}

	public static String getToName() {
		return ArtifactId.getName();
	}

	// neo4j annotations
//	@Id
//	@GeneratedValue
//	private Long relationshipId;
//	
//	@StartNode
//	private Version version;
//	
//	@EndNode
//	private ArtifactId artifactId;
}
