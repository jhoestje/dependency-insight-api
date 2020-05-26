package org.johoco.depinsight.domain;

import java.util.UUID;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

public abstract class Entity {

	@Id
	@GeneratedValue
	private UUID id;

	public UUID getId() {
		return id;
	}
	
	
	//save with new ojbects UUID uuid = UUID.randomUUID();
	// using KernelExtensionFactory to auto set uuid on save
}
