package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.GroupId;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Getter
@Edge("ofGroupId")
public class OfGroupId extends GraphData implements GraphEdge {

	// neo4j annotations
//	@Id
//	@GeneratedValue
//	private Long relationshipId;
//
	@From
	@NonNull
	private ArtifactId artifactId;
//
	@To
	@NonNull
	private GroupId groupId;

	public static String getName() {
		return "ofGroupId";
	}

	public static String getFromName() {
		return ArtifactId.getName();
	}

	public static String getToName() {
		return GroupId.getName();
	}

}
