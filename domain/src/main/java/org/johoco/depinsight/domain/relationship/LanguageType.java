package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.GraphData;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;

import com.arangodb.springframework.annotation.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@RelationshipEntity(type = "LANGUAGE_TYPE")
@Document("language_type")
public class LanguageType extends GraphData {

// neo4j attributes
//	@Id
//	@GeneratedValue
//	private Long relationshipId;
//
//	@StartNode
	private GroupId groupId;
//	@EndNode
	private Language language;

}
