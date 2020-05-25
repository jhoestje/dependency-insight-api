package org.johoco.depinsight.domain;

import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import lombok.Data;

@Data
@NodeEntity
public class Language {
	@Id @GeneratedValue private Long id;
	private String value;
	
	@Relationship(type = "GROUP_IDS")
	  public Set<GroupId> groupIds;
}
