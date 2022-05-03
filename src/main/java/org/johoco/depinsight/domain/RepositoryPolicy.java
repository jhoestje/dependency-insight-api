package org.johoco.depinsight.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Maybe just store this on Repository.
 * 
 * @author John Hoestje
 *
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class RepositoryPolicy extends GraphData {

	private String enabled;
	private String updatePolicy;
	private String checksumPolicy;

}
