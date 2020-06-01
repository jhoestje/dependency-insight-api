package org.johoco.depinsight.domain;

import java.util.Set;

import org.johoco.depinsight.domain.key.LanguageKey;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@Data
@NodeEntity
public class Language extends Entity<LanguageKey> {
	private String value;

	@Relationship(type = "LANGUAGE_TYPE", direction = Relationship.INCOMING)
	public Set<GroupId> groupIds;
}
