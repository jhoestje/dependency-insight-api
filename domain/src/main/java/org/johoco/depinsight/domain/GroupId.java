package org.johoco.depinsight.domain;

import java.util.Set;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import lombok.Data;

@Data
@Node
public class GroupId {
//	@Id
//	@GeneratedValue
//	private Long id;

//	@Property(name = "value")
	@Id
	private String value;

	@Relationship(type = "LANGUAGE")
	private Language language;

	@Relationship(type = "LANGUAGE_TYPE", direction = Direction.INCOMING)
	private Set<ArtifactId> artifactIds;

}
