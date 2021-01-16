package org.johoco.depinsight.domain;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=true)
@NodeEntity
public class Packaging extends GraphData {
	
	@Id
	private String value;
}
