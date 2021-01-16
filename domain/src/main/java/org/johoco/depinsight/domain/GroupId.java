package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.relationship.LanguageType;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@NodeEntity
public class GroupId extends GraphData {
//	@Id
//	@GeneratedValue
//	private Long id;

//	@Property(name = "value")
	@Id
	private String value;
	
	@Relationship(type = "LANGUAGE_TYPE", direction = Relationship.OUTGOING)
	private LanguageType language;

//	@Relationship(type = "LANGUAGE_TYPE", direction = Relationship.INCOMING)
//	private Set<ArtifactId> artifactIds;

}
