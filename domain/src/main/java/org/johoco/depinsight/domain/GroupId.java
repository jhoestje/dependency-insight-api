package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.relationship.LanguageType;
import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//NodeEntity
@Document("groupId")
public class GroupId { // extends GraphData {
//	@Id
//	@GeneratedValue
//	private Long id;

	@Id
	private String value;

	// neo4j attributes
//	@Relationship(type = "LANGUAGE_TYPE", direction = Relationship.OUTGOING)
	private LanguageType language;

//	@Relationship(type = "LANGUAGE_TYPE", direction = Relationship.INCOMING)
//	private Set<ArtifactId> artifactIds;

}
