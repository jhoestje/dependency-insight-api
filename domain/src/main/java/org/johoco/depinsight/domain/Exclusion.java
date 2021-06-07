package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.composite.key.ArtifactKey;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Exclusion extends Entity<ArtifactKey> {
	public Exclusion(ArtifactKey key) {
		super(key);
	}
}
