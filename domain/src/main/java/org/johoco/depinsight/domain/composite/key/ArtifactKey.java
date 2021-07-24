package org.johoco.depinsight.domain.composite.key;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Unique identity for an Artifact.
 * 
 * There are all strings instead of objects because we are not going to link
 * them in the database.
 * 
 * @author John Hoestje
 *
 */
@RequiredArgsConstructor
@ToString
@Getter
@Builder
public class ArtifactKey implements Key {
	// TODO: include language??
	@NonNull
	private String language;
	@NonNull
	private String groupIdValue;
	@NonNull
	private String artifactIdValue;
	@NonNull
	private String version;
	@NonNull
	private String packaging;
}
