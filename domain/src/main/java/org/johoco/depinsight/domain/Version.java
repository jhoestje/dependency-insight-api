package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.relationship.PartOfArtifactId;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@NodeEntity("Version")
public class Version extends GraphData {
	
	@Id
	private String value;
	
	// not sure about how to do/if need to do keys (lang + gid + aid)
//	@org.neo4j.ogm.annotation.Transient
//	private String key;

	@Relationship(type = "PART_OF_ARTIFACTID", direction = Relationship.OUTGOING)
	private PartOfArtifactId partOfGroupId;
}
