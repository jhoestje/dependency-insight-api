package org.johoco.depinsight.domain.composite;

import java.util.List;

import org.johoco.depinsight.domain.Entity;
import org.johoco.depinsight.domain.Exclusion;
import org.johoco.depinsight.domain.composite.key.DependencyKey;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Unique identifier of a Dependency.
 * 
 * @author John Hoestje
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document("dependencies")
public class Dependency extends Entity<DependencyKey> {

	private Artifact managedBy;
	private Artifact transitiveOf; // or dependency??
	private Boolean directDependecy;
	private Boolean inherited;
	private Boolean optional;
	private List<Exclusion> exclusions;

	private String type;
	private String classifier;
	private String scope;
	private String systemPath;

	public Dependency(DependencyKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "dependencies";
	}

}
