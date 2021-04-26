package org.johoco.depinsight.domain;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//NodeEntity
@Document("version")
public class Version { // extends GraphData {

	// neo4j attributes
//	@Id
	private String value;

	// not sure about how to do/if need to do keys (lang + gid + aid)
//	@org.neo4j.ogm.annotation.Transient
//	private String key;

	// neo4j attributes
//	@Relationship(type = "PART_OF_ARTIFACTID", direction = Relationship.OUTGOING)
	// private PartOfArtifactId partOfGroupId;
}
