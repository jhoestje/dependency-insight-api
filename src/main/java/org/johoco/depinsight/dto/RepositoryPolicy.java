package org.johoco.depinsight.dto;

import lombok.Data;

/**
 *
 *
 * @author John Hoestje
 */
@Data
public class RepositoryPolicy {
	private String enabled;
	private String updatePolicy;
	private String checksumPolicy;
}
