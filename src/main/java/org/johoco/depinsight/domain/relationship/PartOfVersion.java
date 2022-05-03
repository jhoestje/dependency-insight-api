package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.Packaging;
import org.johoco.depinsight.domain.Version;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RelationshipEntity(type = "PART_OF_GROUP")
public class PartOfVersion extends GraphData {

	@Id
	@GeneratedValue
	private Long relationshipId;
	
	@StartNode
	private Packaging packaging;
	
	@EndNode
	private Version version;

}
