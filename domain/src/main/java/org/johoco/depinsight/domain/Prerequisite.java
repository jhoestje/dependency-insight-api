package org.johoco.depinsight.domain;

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
//@Document("prerequisites")
public class Prerequisite extends GraphData {

	@NonNull
	private String maven;

	public static String getDocumentName() {
		return "prerequisites";
	}

}
