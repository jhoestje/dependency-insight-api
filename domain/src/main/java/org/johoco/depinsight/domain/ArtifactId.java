package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.relationship.PartOfGroupId;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

//import org.neo4j.ogm.annotation.Id;
//import org.neo4j.ogm.annotation.NodeEntity;
//import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@Data
@NodeEntity("ArtifactId")
public class ArtifactId {
//	@Id @GeneratedValue private Long id;

	@Id
	private String value;

	@Relationship(type = "PART_OF_GROUP", direction = Relationship.OUTGOING)
	private PartOfGroupId partOfGroupId;
}
