package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.composite.key.Key;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
public abstract class Entity<KEY extends Key> extends GraphData {

	@NonNull
	private KEY key;

}
