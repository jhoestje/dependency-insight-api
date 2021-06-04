package org.johoco.depinsight.domain;

import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.To;

import lombok.Data;

@Data
//@EqualsAndHashCode(callSuper = true)
//NodeEntity
@Document("versions")
public class Version { // extends GraphData {

	@Id
//	@GeneratedValue
	private String id;

	// neo4j attributes
//	@Id
	private String value;

	@To
	private ArtifactId artifactId;

	public static String getName() {
		return "versions";
	}

	// not sure about how to do/if need to do keys (lang + gid + aid)
//	@org.neo4j.ogm.annotation.Transient
//	private String key;

	// neo4j attributes
//	@Relationship(type = "PART_OF_ARTIFACTID", direction = Relationship.OUTGOING)
	// private PartOfArtifactId partOfGroupId;
}
