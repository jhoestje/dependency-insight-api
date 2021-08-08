package org.johoco.depinsight.domain;

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
public class Developer extends GraphData {

	// maybe move these all to non-nullable in the key
	private String id;
	private String name;
	private String email;

	public static String getDocumentName() {
		return "developers";
	}

}
