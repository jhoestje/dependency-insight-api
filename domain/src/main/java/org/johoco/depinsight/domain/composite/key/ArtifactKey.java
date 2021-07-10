package org.johoco.depinsight.domain.composite.key;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Unique identity for an Artifact.
 * 
 * @author John Hoestje
 *
 */
@RequiredArgsConstructor
@ToString
@Getter
public class ArtifactKey implements Key {
	// TODO: include language??
	@NonNull
	private String language;
	@NonNull
	private String groupId;
	@NonNull
	private String artifactId;
	@NonNull
	private String version;
	@NonNull
	private String packaging;
}
