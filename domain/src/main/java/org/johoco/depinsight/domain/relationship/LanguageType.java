package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.Entity;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "LANGUAGE_TYPE")
public class LanguageType extends Entity {
	//    @Property  private String title;
	@StartNode
	private GroupId actor;
	@EndNode
	private Language movie;

}
