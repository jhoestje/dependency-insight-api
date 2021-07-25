package org.johoco.depinsight.domain;

import org.johoco.depinsight.domain.key.ScmKey;

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
@Document("scms")
public class Scm extends Entity<ScmKey> {

	private String connection;
	private String developerConnection;

	public Scm(final ScmKey key) {
		super(key);
	}

	public static String getDocumentName() {
		return "scms";
	}

}
