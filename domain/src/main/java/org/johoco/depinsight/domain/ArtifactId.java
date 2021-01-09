package org.johoco.depinsight.domain;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

//import org.neo4j.ogm.annotation.Id;
//import org.neo4j.ogm.annotation.NodeEntity;
//import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@Data
@NodeEntity("Artifact")
public class ArtifactId {
//	@Id @GeneratedValue private Long id;

	@Id
	private String value;

	@Relationship(type = "GROUP_ID")
	private GroupId groupId;
}
