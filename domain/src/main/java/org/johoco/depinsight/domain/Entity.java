package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.composite.key.Key;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Entity<KEY extends Key> extends GraphData {

	@NonNull
	private KEY key;

}
