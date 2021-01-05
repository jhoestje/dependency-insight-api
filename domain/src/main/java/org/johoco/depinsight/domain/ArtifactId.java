package org.johoco.depinsight.domain;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

//import org.neo4j.ogm.annotation.Id;
//import org.neo4j.ogm.annotation.NodeEntity;
//import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@Data
@Node("Artifact")
public class ArtifactId {
//	@Id @GeneratedValue private Long id;

	@Id
	private String value;

	@Relationship(type = "GROUP_ID")
	private GroupId groupId;
}
