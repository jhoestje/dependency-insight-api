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
@Document("sites")
public class Site extends GraphData {

	private String id;
	private String name;
	private String url;

	public static String getDocumentName() {
		return "sites";
	}

}
