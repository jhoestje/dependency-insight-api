package org.johoco.depinsight.domain;

import java.util.List;

import com.arangodb.springframework.annotation.Document;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * Maybe just store this on Artifact.
 * 
 * @author John Hoestje
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Document("prerequisites")
public class Prerequisite extends GraphData {

	@NonNull
	private List<String> maven;

	public static String getDocumentName() {
		return "prerequisites";
	}

}
