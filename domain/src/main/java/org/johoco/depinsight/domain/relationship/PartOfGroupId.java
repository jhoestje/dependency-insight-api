package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.GroupId;

import com.arangodb.springframework.annotation.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@RelationshipEntity(type = "PART_OF_GROUP")
@Document("partOfGroupId")
public class PartOfGroupId extends GraphData {

	// neo4j annotations
//	@Id
//	@GeneratedValue
//	private Long relationshipId;
//
//	@StartNode
	private ArtifactId artifactId;
//
//	@EndNode
	private GroupId groupId;

}
