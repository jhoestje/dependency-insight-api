package org.johoco.depinsight.domain;

import java.util.List;

import com.arangodb.springframework.annotation.Document;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * Maybe just store this on Artifact.
 * 
 * @author John Hoestje
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@Document("prerequisites")
public class Repository extends GraphData {

	private RepositoryPolicy releases;
	private RepositoryPolicy snapshots;
	private String id;
	private String name;
	private String url;
	private String layout;

	@NonNull
	private List<String> maven;

	public static String getDocumentName() {
		return "prerequisites";
	}

}
