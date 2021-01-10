package org.johoco.depinsight.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 *  API data transfer object.
 *  
 * @author John Hoestje
 * 
 */
@Getter
@Setter
public class Gav {
	private String groupId;
	private String artifactId;
	private String version;
}
