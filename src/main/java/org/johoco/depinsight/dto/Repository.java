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
public class Repository {
	private RepositoryPolicy releases;
	private RepositoryPolicy snapshots;
	private String id;
	private String name;
	private String url;
	private String layout;
}
