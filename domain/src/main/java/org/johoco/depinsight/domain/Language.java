package org.johoco.depinsight.domain;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;

@Data
//NodeEntity
@Document
public class Language { // extends Entity<LanguageKey> {

	// neo4j attributes
//	@Id
	private String value;

//	public Language(LanguageKey key) {
//		super.setKey(key);
//	}

//	@Relationship(type = "LANGUAGE_TYPE", direction = Relationship.INCOMING)
//	public List<Lan> groupIds;

}
