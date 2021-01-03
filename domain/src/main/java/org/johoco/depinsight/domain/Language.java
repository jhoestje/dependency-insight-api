package org.johoco.depinsight.domain;

import java.util.Set;

import org.johoco.depinsight.domain.key.LanguageKey;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Relationship.Direction;

import lombok.Data;

@Data
//@NodeEntity
//@RelationshipProperties
@Node
public class Language extends Entity<LanguageKey> {
	private String value;

	@Relationship(type = "LANGUAGE_TYPE", direction = Direction.INCOMING)
	public Set<GroupId> groupIds;
}
