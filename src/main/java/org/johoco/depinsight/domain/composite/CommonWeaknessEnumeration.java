package org.johoco.depinsight.domain.composite;

import org.johoco.depinsight.domain.Entity;
import org.johoco.depinsight.domain.composite.key.StringKey;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CommonWeaknessEnumeration extends Entity<StringKey> {
	private String name;
	// Key
	private String cweId;
	private String description;

	public CommonWeaknessEnumeration(StringKey key) {
		super(key);
	}
}
