package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.relationship.LanguageType;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//NodeEntity
@Document("groupIds")
//@HashIndex(fields = { "value", "language" }, unique = true)
//@PersistentIndex(fields = {"surname"})
public class GroupId extends GraphData {
//	@Id /// db document field: _key
////	@GeneratedValue
//	private String id;

//	@ArangoId // db document field: _id
//	private String arangoId;

//	@Id
	private String value;

	@Relations(edges = LanguageType.class, lazy = false)
	private Language language;

//	@Relationship(type = "LANGUAGE_TYPE", direction = Relationship.INCOMING)
//	private Set<ArtifactId> artifactIds;

}
