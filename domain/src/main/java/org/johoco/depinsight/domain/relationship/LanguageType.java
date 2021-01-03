package org.johoco.depinsight.domain.relationship;

import org.johoco.depinsight.domain.Entity;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Language;

//@RelationshipEntity(type = "LANGUAGE_TYPE")
public class LanguageType extends Entity {
	// @Property private String title;
//	@StartNode
	private GroupId actor;
//	@EndNode
	private Language movie;

}
