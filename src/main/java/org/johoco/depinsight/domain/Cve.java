package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.composite.key.StringKey;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Cve extends Entity<StringKey> {

	public Cve(StringKey key) {
		super(key);
	}

}
