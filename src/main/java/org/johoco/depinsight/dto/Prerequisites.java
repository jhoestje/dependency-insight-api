package org.johoco.depinsight.dto;

import lombok.Data;

/**
 * Describes the prerequisites a project can have.
 * 
 * example <prerequisites> <maven>3.0.4</maven> </prerequisites>
 *
 * @author John Hoestje
 */
@Data
public class Prerequisites {
	private String maven;
}
