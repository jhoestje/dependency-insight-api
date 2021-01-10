package org.johoco.depinsight.domain;

import java.util.List;

import org.johoco.depinsight.domain.key.LanguageKey;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@Data
@NodeEntity
public class Language extends Entity<LanguageKey> {

	private String value;

//	public Language(LanguageKey key) {
//		super.setKey(key);
//	}

//	@Relationship(type = "LANGUAGE_TYPE", direction = Relationship.INCOMING)
//	public List<Lan> groupIds;

}
