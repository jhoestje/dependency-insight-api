package org.johoco.depinsight.domain;

import java.util.UUID;

import org.johoco.depinsight.domain.key.Key;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

public abstract class Entity<KEY extends Key> {

	@Id
	@GeneratedValue
	private UUID id;

	private KEY key;

	public UUID getId() {
		return id;
	}

	public KEY getKey() {
		return key;
	}

	// save with new ojbects UUID uuid = UUID.randomUUID();
	// using KernelExtensionFactory to auto set uuid on save
}
