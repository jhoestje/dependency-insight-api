package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.GroupIdKey;
import org.johoco.depinsight.domain.relationship.OfLanguage;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Document("groupIds")
public class GroupId extends Entity<GroupIdKey> {

	private String value;

	@Relations(edges = OfLanguage.class, lazy = false)
	private Language language;

//	@Relationship(type = "LANGUAGE_TYPE", direction = Relationship.INCOMING)
//	private Set<ArtifactId> artifactIds;

	public static String getName() {
		return "groupIds";
	}

}
