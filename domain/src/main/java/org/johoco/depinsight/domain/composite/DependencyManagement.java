package org.johoco.depinsight.domain.composite;

import org.johoco.depinsight.domain.Entity;
import org.johoco.depinsight.domain.composite.key.DependencyKey;

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
public class DependencyManagement extends Entity<DependencyKey> {

	private Artifact managedBy;
	private Artifact transitiveOf; // or dependency??
	private Boolean directDependecy;
	private Boolean inherited;
	private Boolean optional;

	public DependencyManagement(DependencyKey key) {
		super(key);
	}

}
