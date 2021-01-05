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

//	@Id
//	@GeneratedValue
//	private Long id;
//
//	@Property
//	private KEY key;
//
//	public Long getId() {
//		return id;
//	}
//
//	public KEY getKey() {
//		return key;
//	}
//
//	void setKey(final KEY key) {
//		this.key = key;
//	}

	// save with new ojbects UUID uuid = UUID.randomUUID();
	// using KernelExtensionFactory to auto set uuid on save
}
