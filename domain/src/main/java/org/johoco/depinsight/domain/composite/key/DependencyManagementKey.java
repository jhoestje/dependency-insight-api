package org.johoco.depinsight.domain.composite.key;

import org.johoco.depinsight.domain.Scope;
import org.johoco.depinsight.domain.composite.Artifact;

import lombok.Data;
import lombok.NonNull;

@Data
public class DependencyManagementKey implements Key {

	@NonNull
	private Artifact backingArtifact;
	@NonNull
	private DependencyManagementKey dependencyOf; // key or dependency or artifact??
	@NonNull
	private Scope scope;
}
