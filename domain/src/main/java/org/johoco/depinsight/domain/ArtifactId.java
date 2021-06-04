package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.relationship.OfGroupId;
import org.springframework.data.annotation.Id;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.To;

//import org.neo4j.ogm.annotation.Id;
//import org.neo4j.ogm.annotation.NodeEntity;
//import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@Data
//NodeEntity
@Document("artifactIds")
public class ArtifactId {
	@Id
//	@GeneratedValue
	private String id;

	private String value;

	// not sure about how to do/if need to do keys (lang + gid + aid)
//	@org.neo4j.ogm.annotation.Transient
//	private String key;

//	@Relationship(type = "PART_OF_GROUP", direction = Relationship.OUTGOING)
	@To
	private OfGroupId partOfGroupId;

	public static String getName() {
		return "artifactIds";
	}
}
