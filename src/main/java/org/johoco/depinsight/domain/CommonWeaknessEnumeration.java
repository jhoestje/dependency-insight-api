package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.StringKey;

import lombok.Data;

@Data
public class CommonWeaknessEnumeration extends Entity<StringKey> {
	private String name;
	// Key
	private String cweId;
	private String description;
}
