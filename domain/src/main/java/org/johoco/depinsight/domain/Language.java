package org.johoco.depinsight.domain;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Document("languages")
public class Language extends GraphData { // extends Entity<LanguageKey> {

	// neo4j attributes
//	@Id
	private String value;

//	public Language(LanguageKey key) {
//		super.setKey(key);
//	}

//	@Relationship(type = "LANGUAGE_TYPE", direction = Relationship.INCOMING)
//	public List<Lan> groupIds;

	public static String getName() {
		return "languages";
	}

}
