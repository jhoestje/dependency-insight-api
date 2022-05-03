package org.johoco.depinsight.domain;

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
@Document("relocations")
public class Relocation extends GraphData {

	private String groupId;
	private String artifactId;
	private String version;
	private String message;

	public static String getDocumentName() {
		return "relocations";
	}

}
