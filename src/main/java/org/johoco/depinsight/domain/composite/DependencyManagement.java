package org.johoco.depinsight.domain.composite;

import org.johoco.depinsight.domain.Entity;
import org.johoco.depinsight.domain.composite.key.DependencyManagementKey;

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
@Document("dependencyManagements")
public class DependencyManagement extends Entity<DependencyManagementKey> {

	private Artifact managedBy;
	// or Artifact.. prob dep for scope and additional metadata
	private Dependency transitiveOf;
	private Boolean directDependecy;
	private Boolean inherited;
	private Boolean optional;

	public DependencyManagement(DependencyManagementKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "dependencyManagements";
	}

}
