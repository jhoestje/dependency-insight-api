package org.johoco.depinsight.domain;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;

@Data
@NodeEntity
public class ArtifactId {
//	@Id @GeneratedValue private Long id;
	
	@Id
	private String value;
}
