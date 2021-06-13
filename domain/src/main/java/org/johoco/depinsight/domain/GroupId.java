package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.GroupIdKey;

import com.arangodb.springframework.annotation.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode(callSuper = true)
@Getter
@Document("groupIds")
public class GroupId extends Entity<GroupIdKey> {

	public GroupId(GroupIdKey key) {
		super(key);
	}

//	@Relations(edges = OfLanguage.class, lazy = false)
//	private Language language;

//	@Relationship(type = "LANGUAGE_TYPE", direction = Relationship.INCOMING)
//	private Set<ArtifactId> artifactIds;

	public static String getName() {
		return "groupIds";
	}

}
