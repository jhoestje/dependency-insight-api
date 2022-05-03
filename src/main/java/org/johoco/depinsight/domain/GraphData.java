package org.johoco.depinsight.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.Property;

import lombok.Data;

@Data
public class GraphData {

	@Property
	private Date createdDate;
	
}
