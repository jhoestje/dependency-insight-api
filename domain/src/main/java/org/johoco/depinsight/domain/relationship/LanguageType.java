package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RelationshipEntity(type = "LANGUAGE_TYPE")
public class LanguageType extends GraphData {

	@Id
	@GeneratedValue
	private Long relationshipId;

	
	@StartNode
	private GroupId groupId;
	@EndNode
	private Language language;

}
