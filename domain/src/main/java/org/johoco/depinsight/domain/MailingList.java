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
@Document("mailinglists")
public class MailingList extends GraphData {

	private String name;
	private String subscribe;
	private String unsubscribe;
	private String post;
	private String archive;
	private String otherArchives;

	public static String getDocumentName() {
		return "mailinglists";
	}

}
