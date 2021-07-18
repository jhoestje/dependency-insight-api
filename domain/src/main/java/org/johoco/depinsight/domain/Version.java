package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.relationship.OfArtifactId;

import com.arangodb.springframework.annotation.Document;
import com.arangodb.springframework.annotation.Relations;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Document("versions")
public class Version extends GraphData {

	private String value;

	@Relations(edges = OfArtifactId.class, lazy = false)
	private ArtifactId artifactId;

	public static String getDocumentName() {
		return "versions";
	}

}
