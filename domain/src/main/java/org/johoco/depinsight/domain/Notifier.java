package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.NotifierKey;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Maybe just store this on Artifact.
 * 
 * @author John Hoestje
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document("notifiers")
public class Notifier extends Entity<NotifierKey> {

	private String type;
	private Boolean sendOnError; // boolean
	private Boolean sendOnFailure; // boolean
	private Boolean sendOnSuccess; // boolean
	private Boolean sendOnWarning; // boolean

	public Notifier(NotifierKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "notifiers";
	}

}
