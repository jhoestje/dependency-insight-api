package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.composite.key.StringKey;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RiskWeight extends Entity<StringKey> {
	private String value;

	public RiskWeight(StringKey key) {
		super(key);
	}
}
