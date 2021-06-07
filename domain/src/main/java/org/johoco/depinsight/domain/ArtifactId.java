package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.relationship.OfGroupId;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Document("artifactIds")
public class ArtifactId extends GraphData {

	private String value;

	@Relations(edges = OfGroupId.class, lazy = false)
	private GroupId groupId;

	public static String getName() {
		return "artifactIds";
	}
}
