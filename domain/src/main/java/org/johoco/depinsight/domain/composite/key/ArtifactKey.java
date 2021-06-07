package org.johoco.depinsight.domain.composite.key;

import org.johoco.depinsight.domain.ArtifactId;
import org.johoco.depinsight.domain.GroupId;
import org.johoco.depinsight.domain.Packaging;
import org.johoco.depinsight.domain.Version;

import lombok.Data;
import lombok.NonNull;

/**
 * Unique identity for an Artifact.
 * 
 * @author John Hoestje
 *
 */
@Data
public class ArtifactKey implements Key {
	@NonNull
	private GroupId groupId;
	@NonNull
	private ArtifactId artifactId;
	@NonNull
	private Version version;
	@NonNull
	private Packaging packaging;
}
