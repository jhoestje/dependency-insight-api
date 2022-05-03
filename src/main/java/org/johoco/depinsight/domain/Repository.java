package org.johoco.depinsight.domain;

import java.util.List;

import org.johoco.depinsight.domain.key.RepositoryKey;

import com.arangodb.springframework.annotation.Document;

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
@Document("repositories")
public class Repository extends Entity<RepositoryKey> {

	private RepositoryPolicy releases;
	private RepositoryPolicy snapshots;
	private String id;
	private String name;
	private String layout;

	public Repository(final RepositoryKey key) {
		super(key);
	}

	@NonNull
	private List<String> maven;

	public static String getDocumentName() {
		return "repositories";
	}

}
