package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.GroupId;

import com.arangodb.springframework.annotation.Edge;
import com.arangodb.springframework.annotation.From;
import com.arangodb.springframework.annotation.To;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Edge("partOfGroupId")
public class PartOfGroupId extends GraphData {

	// neo4j annotations
//	@Id
//	@GeneratedValue
//	private Long relationshipId;
//
	@From
	private ArtifactId artifactId;
//
	@To
	private GroupId groupId;

}
