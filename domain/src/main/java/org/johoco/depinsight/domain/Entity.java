package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.Key;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

public abstract class Entity<KEY extends Key> {

//	@Id
//	@GeneratedValue
//	private UUID id;
//
//	private KEY key;
//
//	public UUID getId() {
//		return id;
//	}
//
//	public KEY getKey() {
//		return key;
//	}
	@Id
	@GeneratedValue
	private Long id;

	// save with new ojbects UUID uuid = UUID.randomUUID();
	// using KernelExtensionFactory to auto set uuid on save
}
