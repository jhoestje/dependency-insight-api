package org.johoco.depinsight.domain.relationship;

import java.util.Date;

import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RelationshipEntity(type = "LANGUAGE_TYPE")
public class LanguageType {

	@Id
	@GeneratedValue
	private Long relationshipId;

	@Property
	private Date createdDate;
	
	@StartNode
	private GroupId groupId;
	@EndNode
	private Language language;

}
