package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.DependencyKey;

import lombok.Data;

/**
 * Unique identifier of a Dependency.
 * 
 * @author John Hoestje
 *
 */
@Data
public class Dependency extends Entity<DependencyKey> {

	private Artifact managedBy;
	private Artifact transitiveOf; // or dependency??
	private Boolean directDependecy;
	private Boolean inherited;
	private Boolean optional;

//	managedby
//	transitive of
//	direct dependency
//	inheritied
//	optional

}
