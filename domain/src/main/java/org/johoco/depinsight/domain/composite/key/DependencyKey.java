package org.johoco.depinsight.domain.composite.key;

import org.johoco.depinsight.domain.Scope;
import org.johoco.depinsight.domain.composite.Artifact;

import lombok.Data;
import lombok.NonNull;

@Data
public class DependencyKey implements Key {

	@NonNull
	private Artifact backingArtifact;
	@NonNull
	private Artifact dependencyOf; // or dependency??
	@NonNull
	private Scope scope;
}
