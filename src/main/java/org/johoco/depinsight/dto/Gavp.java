package org.johoco.depinsight.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Gavp {
	private String artifactId;
	private String groupId;
	private String version;
	private String extension;
}
