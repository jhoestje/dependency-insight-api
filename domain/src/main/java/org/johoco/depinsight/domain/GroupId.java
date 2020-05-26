package org.johoco.depinsight.domain;

import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@Data
@NodeEntity
public class GroupId {
	@Id
	@GeneratedValue
	private Long id;
	
	@Property(name="value")
	private String value;

	@Relationship(type = "LANGUAGE")
	private Language language;

	@Relationship(type = "LANGUAGE_TYPE", direction = Relationship.INCOMING)
	private Set<ArtifactId> artifactIds;

}
