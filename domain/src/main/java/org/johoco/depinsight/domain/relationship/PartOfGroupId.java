package org.johoco.depinsight.domain.relationship;

import java.util.Date;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GroupId;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RelationshipEntity(type = "PART_OF_GROUP")
public class PartOfGroupId {

	@Id
	@GeneratedValue
	private Long relationshipId;

	@Property
	private Date createdDate;
	
	@StartNode
	private ArtifactId artifactId;
	
	@EndNode
	private GroupId groupId;

}
