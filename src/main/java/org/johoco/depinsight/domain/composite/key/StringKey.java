package org.johoco.depinsight.domain.composite.key;

import lombok.Data;

/**
 * Unique identity for an Artifact.
 * 
 * @author John Hoestje
 *
 */
@Data
public class StringKey implements Key {
	private String value;
}
