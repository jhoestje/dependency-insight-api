package org.johoco.depinsight.domain.composite.key;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * Unique identity for an Artifact.
 * 
 * There are all strings instead of objects because we are not going to link
 * them in the database.
 * 
 * @author John Hoestje
 *
 */
@Data
@Builder
public class ExclusionKey implements Key {
	@NonNull
	private String language;
	@NonNull
	private String groupIdValue;
	@NonNull
	private String artifactIdValue;
}
