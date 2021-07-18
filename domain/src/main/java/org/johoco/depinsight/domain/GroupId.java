package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.GroupIdKey;
import org.johoco.depinsight.domain.relationship.OfLanguage;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;

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

	@Relations(edges = OfLanguage.class, lazy = false)
	private Language language;

//	@Relationship(type = "LANGUAGE_TYPE", direction = Relationship.INCOMING)
//	private Set<ArtifactId> artifactIds;

	public static String getDocumentName() {
		return "groupIds";
	}

	public String getValue() {
		if (this.getKey() != null) {
			return this.getKey().getGroupIdValue();
		}
		return null;
	}

}
