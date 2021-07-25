package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.composite.key.ExclusionKey;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Exclusion extends Entity<ExclusionKey> {
	public Exclusion(ExclusionKey key) {
		super(key);
	}
}
