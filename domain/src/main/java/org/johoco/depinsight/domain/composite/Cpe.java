package org.johoco.depinsight.domain.composite;

import org.johoco.depinsight.domain.Entity;
import org.johoco.depinsight.domain.composite.key.StringKey;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Cpe extends Entity<StringKey> {
	public Cpe(StringKey key) {
		super(key);
	}
}
