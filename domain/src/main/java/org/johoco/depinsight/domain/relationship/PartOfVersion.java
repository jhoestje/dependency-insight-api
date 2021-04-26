package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.GraphData;

import com.arangodb.springframework.annotation.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@RelationshipEntity(type = "PART_OF_GROUP")
@Document("partOfVersion")
public class PartOfVersion extends GraphData {

	// neo4j annotations
//	@Id
//	@GeneratedValue
//	private Long relationshipId;
//	
//	@StartNode
//	private Packaging packaging;
//	
//	@EndNode
//	private Version version;

}
