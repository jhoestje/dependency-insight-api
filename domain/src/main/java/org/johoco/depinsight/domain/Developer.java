package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.DeveloperKey;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * 
 * @author John Hoestje
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document("developers")
public class Developer extends Entity<DeveloperKey> {

	public Developer(final DeveloperKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "developers";
	}

	public String getId() {
		return this.getKey().getId();
	}

	public String getName() {
		return this.getKey().getName();
	}

	public String getEmail() {
		return this.getKey().getEmail();
	}
}
