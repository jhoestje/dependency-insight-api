package org.johoco.depinsight.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 *
 * @author John Hoestje
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryPolicy {
	private String enabled;
	private String updatePolicy;
	private String checksumPolicy;
}
